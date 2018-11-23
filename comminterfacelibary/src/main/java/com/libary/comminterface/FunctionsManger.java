package com.libary.comminterface;

import android.text.TextUtils;

import java.util.HashMap;

//function 管理类
public class FunctionsManger {
    private static FunctionsManger _instance;
    //容器用来存放函数不同类型的接口，key是函数名
    private HashMap<String,FunctionNoParmNoResult> mFunctionNoParmNoResult;
    private HashMap<String,FunctionNoParmWithResult> mFunctionNoParmWithResult;
    private HashMap<String,FunctionWithParmNoResult> mFunctionWithParmNoResult;
    private HashMap<String,FunctionWithParmWithResult> mFunctionWithParmWithResult;
    private HashMap<String,FunctionWithMultiParmNoResult> mFunctionWithMultiParmNoResult;
    private HashMap<String,FunctionWithMultiParmWithResult> mFunctionWithMultiParmWithResult;
    private FunctionsManger(){
        //初始化
        mFunctionNoParmNoResult = new HashMap<>();
        mFunctionNoParmWithResult = new HashMap<>();
        mFunctionWithParmNoResult = new HashMap<>();
        mFunctionWithParmWithResult = new HashMap<>();
        mFunctionWithMultiParmNoResult = new HashMap<>();
        mFunctionWithMultiParmWithResult  = new HashMap<>();
    }

    //单例模式
    public static FunctionsManger getInstance(){
        if(_instance == null){
            _instance = new FunctionsManger();
        }
        return _instance;
    }

    //无参数无返回值，添加
    public FunctionsManger addFunction(FunctionNoParmNoResult func){
        mFunctionNoParmNoResult.put(func.getmFunctionName(),func);
        return this;
    }
    //无参数无返回值，调用
    public void invokeFunction(String functionName){
        if(TextUtils.isEmpty(functionName)){
            throw new RuntimeException("Function name can not be empty");
        }
        if(mFunctionNoParmNoResult != null){
            FunctionNoParmNoResult func = mFunctionNoParmNoResult.get(functionName);
            if(func != null){
                func.function();
            }else{
                throw new RuntimeException("Function "+functionName+" is not exits");
            }
        }
    }

    //无参数有返回值，添加
    public FunctionsManger addFunction(FunctionNoParmWithResult func){
        mFunctionNoParmWithResult.put(func.getmFunctionName(),func);
        return this;
    }
    //无参数有返回值，调用
    public <Result> Result invokeFunction(String functionName,Class<Result> clazz){
        if(TextUtils.isEmpty(functionName)){
            throw new RuntimeException("Function name can not be empty");
        }
        if(mFunctionNoParmWithResult != null){
            FunctionNoParmWithResult func = mFunctionNoParmWithResult.get(functionName);
            if(func != null){
                if(clazz != null){
                    return clazz.cast(func.function());
                }else{
                    return (Result)func.function();
                }
            }else{
                throw new RuntimeException("Function "+functionName+" is not exits");
            }
        }
        return null;
    }


    //有参数无返回值，添加
    public FunctionsManger addFunction(FunctionWithParmNoResult func){
        mFunctionWithParmNoResult.put(func.getmFunctionName(),func);
        return this;
    }
    //有参数无返回值，调用
    public <Param> void invokeFunction(String functionName,Param param){
        if(TextUtils.isEmpty(functionName)){
            throw new RuntimeException("Function name can not be empty");
        }
        if(mFunctionWithParmNoResult != null){
            FunctionWithParmNoResult func = mFunctionWithParmNoResult.get(functionName);
            if(func != null){
               func.function(param);
            }else{
                throw new RuntimeException("Function "+functionName+" is not exits");
            }
        }
    }

    //有参数有返回值，添加
    public FunctionsManger addFunction(FunctionWithParmWithResult func){
        mFunctionWithParmWithResult.put(func.getmFunctionName(),func);
        return this;
    }
    //有参数有返回值，调用
    public <Param,Result> Result invokeFunction(String functionName,Param param,Class<Result> clazz){
        if(TextUtils.isEmpty(functionName)){
            throw new RuntimeException("Function name can not be empty");
        }
        if(mFunctionWithParmWithResult != null){
            FunctionWithParmWithResult func = mFunctionWithParmWithResult.get(functionName);
            if(func != null){
                if(clazz != null){
                    return clazz.cast(func.function(param));
                }else{
                    return (Result) func.function(param);
                }
            }else{
                throw new RuntimeException("Function "+functionName+" is not exits");
            }
        }
        return null;
    }


    //有多个参数无返回值，添加
    public FunctionsManger addFunction(FunctionWithMultiParmNoResult func){
        mFunctionWithMultiParmNoResult.put(func.getmFunctionName(),func);
        return this;
    }
    //有多个参数无返回值，调用
    public void invokeFunction(String functionName,Object ... param){
        if(TextUtils.isEmpty(functionName)){
            throw new RuntimeException("Function name can not be empty");
        }
        if(mFunctionWithMultiParmNoResult != null){
            FunctionWithMultiParmNoResult func = mFunctionWithMultiParmNoResult.get(functionName);
            if(func != null){
                func.function(param);
            }else{
                throw new RuntimeException("Function "+functionName+" is not exits");
            }
        }
    }

    //有多个参数有返回值，添加
    public FunctionsManger addFunction(FunctionWithMultiParmWithResult func){
        mFunctionWithMultiParmWithResult.put(func.getmFunctionName(),func);
        return this;
    }
    //有多个参数有返回值，调用
    public <Result> Result invokeFunction(String functionName,Class<Result> clazz,Object ... param){
        if(TextUtils.isEmpty(functionName)){
            throw new RuntimeException("Function name can not be empty");
        }
        if(mFunctionWithMultiParmWithResult != null){
            FunctionWithMultiParmWithResult func = mFunctionWithMultiParmWithResult.get(functionName);
            if(func != null){
                if(clazz != null){
                    return clazz.cast(func.function(param));
                }else{
                    return (Result) func.function(param);
                }
            }else{
                throw new RuntimeException("Function "+functionName+" is not exits");
            }
        }
        return null;
    }

    //退出应用时调用
    public void clear(){
        mFunctionNoParmNoResult.clear();
        mFunctionNoParmWithResult.clear();
        mFunctionWithParmNoResult.clear();
        mFunctionWithParmWithResult.clear();
        mFunctionWithMultiParmNoResult.clear();
        mFunctionWithMultiParmWithResult.clear();
    }
}

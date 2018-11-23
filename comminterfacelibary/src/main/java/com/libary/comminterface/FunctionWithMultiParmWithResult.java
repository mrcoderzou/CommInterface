package com.libary.comminterface;


public abstract class FunctionWithMultiParmWithResult<Result> extends Function{
    public FunctionWithMultiParmWithResult(String mFunctionName) {
        super(mFunctionName);
    }

    //返回值用泛型，可变参数
    public abstract Result function(Object ... param);
}

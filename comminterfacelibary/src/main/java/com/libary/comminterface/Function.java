package com.libary.comminterface;

//基类
public abstract class Function {
    private String mFunctionName;

    public String getmFunctionName() {
        return mFunctionName;
    }

    public Function(String mFunctionName){
        this.mFunctionName = mFunctionName;
    }
}

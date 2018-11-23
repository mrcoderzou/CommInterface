package com.libary.comminterface;

public abstract class FunctionWithParmNoResult<Param> extends Function{
    public FunctionWithParmNoResult(String mFunctionName) {
        super(mFunctionName);
    }

    //单个参数用泛型传入
    public abstract void function(Param param);
}

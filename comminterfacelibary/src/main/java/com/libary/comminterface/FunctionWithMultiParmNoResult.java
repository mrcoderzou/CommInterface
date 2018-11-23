package com.libary.comminterface;

public abstract class FunctionWithMultiParmNoResult extends Function{
    public FunctionWithMultiParmNoResult(String mFunctionName) {
        super(mFunctionName);
    }

    //多个参数用可变数组
    public abstract void function(Object ... param);
}

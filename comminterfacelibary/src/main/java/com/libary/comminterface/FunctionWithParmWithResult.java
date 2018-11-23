package com.libary.comminterface;

public abstract class FunctionWithParmWithResult<Param,Result> extends Function{
    public FunctionWithParmWithResult(String mFunctionName) {
        super(mFunctionName);
    }

    public abstract Result function(Param param);
}

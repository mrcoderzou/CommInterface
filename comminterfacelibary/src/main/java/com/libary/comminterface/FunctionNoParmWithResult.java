package com.libary.comminterface;

public abstract class FunctionNoParmWithResult<Result> extends Function{
    public FunctionNoParmWithResult(String mFunctionName) {
        super(mFunctionName);
    }

    //返回值类型使用泛型
    public abstract Result function();
}

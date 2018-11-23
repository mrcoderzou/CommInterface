package com.libary.comminterface;

//这里为什么要定义成abstract，因为函数体的实现要交给子类
public abstract class FunctionNoParmNoResult extends Function {
    public FunctionNoParmNoResult(String mFunctionName) {
        super(mFunctionName);
    }

    //没有实现的函数体，具体实现交给子类
    public abstract void function();
}

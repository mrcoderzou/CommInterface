package com.test.comminterface.custom;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.View;

import com.libary.comminterface.FunctionsManger;


public class WithParamNoResultButton extends AppCompatButton {

    public static final String NAME_WPNR = WithParamNoResultButton.class.getName()+"_wpnr";

    public WithParamNoResultButton(Context context) {
        super(context);
        initEvent();
    }

    public WithParamNoResultButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initEvent();
    }

    public WithParamNoResultButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initEvent();
    }

    private void initEvent(){
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                FunctionsManger.getInstance().invokeFunction(NAME_WPNR,"hello world");
            }
        });
    }
}

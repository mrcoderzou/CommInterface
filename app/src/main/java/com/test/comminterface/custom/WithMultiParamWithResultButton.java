package com.test.comminterface.custom;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.View;

import com.libary.comminterface.FunctionsManger;


public class WithMultiParamWithResultButton extends AppCompatButton {

    public static final String NAME_WMPWR = WithMultiParamWithResultButton.class.getName()+"wmpwr";

    public WithMultiParamWithResultButton(Context context) {
        super(context);
        initEvent();
    }

    public WithMultiParamWithResultButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initEvent();
    }

    public WithMultiParamWithResultButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initEvent();
    }

    private void initEvent(){
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = FunctionsManger.getInstance().invokeFunction(NAME_WMPWR,String.class,"hello world",2);
                setText(result);
            }
        });
    }
}

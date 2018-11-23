package com.test.comminterface.custom;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.View;

import com.libary.comminterface.FunctionsManger;


public class WithMultiParamNoResultButton extends AppCompatButton {

    public static final String NAME_WMPWNR = WithMultiParamNoResultButton.class.getName()+"wmpnr";

    public WithMultiParamNoResultButton(Context context) {
        super(context);
        initEvent();
    }

    public WithMultiParamNoResultButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initEvent();
    }

    public WithMultiParamNoResultButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initEvent();
    }

    private void initEvent(){
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                FunctionsManger.getInstance().invokeFunction(NAME_WMPWNR,"hello world",2);
            }
        });
    }
}

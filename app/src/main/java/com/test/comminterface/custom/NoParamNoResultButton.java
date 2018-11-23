package com.test.comminterface.custom;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.View;

import com.libary.comminterface.FunctionsManger;

public class NoParamNoResultButton extends AppCompatButton {
    public static final String NAME_NPNR = NoParamNoResultButton.class.getSimpleName()+"_npnr";
    public NoParamNoResultButton(Context context) {
        super(context);
        initEvent();
    }

    public NoParamNoResultButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initEvent();
    }

    public NoParamNoResultButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initEvent();
    }

    private void initEvent(){
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                FunctionsManger fm = FunctionsManger.getInstance();
                fm.invokeFunction(NAME_NPNR);
            }
        });
    }
}

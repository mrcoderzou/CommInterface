package com.test.comminterface.custom;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.View;

import com.libary.comminterface.FunctionsManger;

public class NoParamWithResultButton extends AppCompatButton {
    public static final String NAME_NPWR = NoParamWithResultButton.class.getSimpleName()+"_npwr";
    public NoParamWithResultButton(Context context) {
        super(context);
        initEvent();
    }

    public NoParamWithResultButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initEvent();
    }

    public NoParamWithResultButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initEvent();
    }

    private void initEvent(){
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                FunctionsManger fm = FunctionsManger.getInstance();
                String result = fm.invokeFunction(NAME_NPWR,String.class);
                setText(result);
            }
        });
    }
}

package com.test.comminterface.custom;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.View;


public class NormalButton extends AppCompatButton {
    public NormalButton(Context context) {
        super(context);
        initEvent();
    }

    public NormalButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initEvent();
    }

    public NormalButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initEvent();
    }

    public interface Callback{
        void callback();
    }
    public interface Callback1{

    }
    private Callback callback;

    public void setCallback(Callback callback){
        this.callback = callback;
    }

    private void initEvent(){
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(callback != null){
                    callback.callback();
                }
            }
        });
    }
}

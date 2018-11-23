package com.test.comminterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.libary.comminterface.FunctionNoParmNoResult;
import com.libary.comminterface.FunctionNoParmWithResult;
import com.libary.comminterface.FunctionWithMultiParmNoResult;
import com.libary.comminterface.FunctionWithMultiParmWithResult;
import com.libary.comminterface.FunctionWithParmNoResult;
import com.libary.comminterface.FunctionWithParmWithResult;
import com.libary.comminterface.FunctionsManger;
import com.test.comminterface.custom.NoParamNoResultButton;
import com.test.comminterface.custom.NoParamWithResultButton;
import com.test.comminterface.custom.NormalButton;
import com.test.comminterface.custom.WithMultiParamNoResultButton;
import com.test.comminterface.custom.WithMultiParamWithResultButton;
import com.test.comminterface.custom.WithParamNoResultButton;
import com.test.comminterface.custom.WithParamWithResultButton;

public class MainActivity extends AppCompatActivity implements NormalButton.Callback{
    private NormalButton nb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initFunction();
    }

    private void initView(){
        nb = findViewById(R.id.nb);
        nb.setCallback(this);
    }

    private void initFunction(){
        FunctionsManger fm = FunctionsManger.getInstance();
        fm.addFunction(new FunctionNoParmNoResult(NoParamNoResultButton.NAME_NPNR) {
            @Override
            public void function() {
                showToast("activity 中调用无参无返回值接口 ："+NoParamNoResultButton.NAME_NPNR);
            }
        }).addFunction(new FunctionWithMultiParmWithResult<String>(WithMultiParamWithResultButton.NAME_WMPWR) {
            @Override
            public String function(Object... param) {
                String param1 = param[0].toString();
                int param2 = (Integer) param[1];
                return param1 + param2;
            }
        }).addFunction(new FunctionNoParmWithResult<String>(NoParamWithResultButton.NAME_NPWR) {
            @Override
            public String function() {
                return "来自activity的返回结果";
            }
        }).addFunction(new FunctionWithParmNoResult<String>(WithParamNoResultButton.NAME_WPNR) {
            @Override
            public void function(String o) {
                showToast("接收参数为:"+o);
            }
        }).addFunction(new FunctionWithParmWithResult<String,String>(WithParamWithResultButton.NAME_WPWR) {
            @Override
            public String function(String o) {
                return "来自activity返回，参数："+o;
            }
        }).addFunction(new FunctionWithMultiParmNoResult(WithMultiParamNoResultButton.NAME_WMPWNR) {
            @Override
            public void function(Object... param) {
                String param1 = param[0].toString();
                int param2 = (Integer) param[1];
                showToast("参数1："+param1+" 参数2："+param2);
            }
        });
    }

    private void showToast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }



    @Override
    public void callback() {
        showToast("activity 中调用普通接口");
    }
}

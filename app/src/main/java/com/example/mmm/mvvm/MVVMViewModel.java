package com.example.mmm.mvvm;

import android.app.Application;
import android.util.Log;
import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.mmm.BR;
import com.example.mmm.bean.Account;

public class MVVMViewModel extends BaseObservable {

    private String inputStr="aaa";
    private String result;

    private MVVMModel_Interface model;
    private Application application;

    // 一般需要传入application对象，方便在viewmodel中使用application
    // 比如sharedpreference
    public MVVMViewModel(Application application) {
        this.application = application;
        this.model = new MVVMModel();
    }
    public void onclick(View v){
        model.getAccountData(inputStr, new MVVMModel_Interface.CallBack() {
            @Override
            public void onSuccess(Account account) {
                String result = account.getName()+":"+account.getLevel();
                setResult(result);
            }

            @Override
            public void onFail() {
                String result = "报错了！！！";
                setResult(result);
            }
        });
    }

    @Bindable
    public String getInputStr() {
        return inputStr;
    }

    public void setInputStr(String inputStr) {
        this.inputStr = inputStr;
        notifyPropertyChanged(BR.inputStr);
    }

    @Bindable
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
        notifyPropertyChanged(BR.result);
    }
}

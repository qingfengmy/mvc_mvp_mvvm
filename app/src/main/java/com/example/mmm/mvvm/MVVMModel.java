package com.example.mmm.mvvm;

import com.example.mmm.bean.Account;

import java.util.Random;

public class MVVMModel implements MVVMModel_Interface {

    //查询用户数据

    @Override
    public void getAccountData(String accountName, CallBack callBack) {
        Random random = new Random();
        boolean isSuccess = random.nextBoolean();
        if (isSuccess) {
            Account account = new Account();
            account.setName(accountName);
            account.setLevel(100);
            callBack.onSuccess(account);
        } else {
            callBack.onFail();
        }
    }
}

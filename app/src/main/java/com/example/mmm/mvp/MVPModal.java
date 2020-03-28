package com.example.mmm.mvp;

import com.example.mmm.bean.Account;
import com.example.mmm.normal.MCallBack;

import java.util.Random;

public class MVPModal implements MVPModal_Interface {

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

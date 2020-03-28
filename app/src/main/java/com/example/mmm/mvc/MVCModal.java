package com.example.mmm.mvc;

import com.example.mmm.bean.Account;
import com.example.mmm.normal.MCallBack;

import java.util.Random;

public class MVCModal {

    //查询用户数据
    public void getAccountData(String accountName, MCallBack mCallBack) {
        Random random = new Random();
        boolean isSuccess = random.nextBoolean();
        if (isSuccess) {
            Account account = new Account();
            account.setName(accountName);
            account.setLevel(100);
            mCallBack.onSuccess(account);
        } else {
            mCallBack.onFail();
        }
    }
}

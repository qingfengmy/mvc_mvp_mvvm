package com.example.mmm.normal;

import com.example.mmm.bean.Account;

public interface MCallBack {
    void onSuccess(Account account);
    void onFail();
}

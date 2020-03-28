package com.example.mmm.mvp;

import com.example.mmm.bean.Account;

public interface MVPModal_Interface {
    void getAccountData(String accountName, CallBack callBack);

    // 这个属于modal的功能，所以写在这里好些
    interface CallBack {
        void onSuccess(Account account);

        void onFail();
    }
}

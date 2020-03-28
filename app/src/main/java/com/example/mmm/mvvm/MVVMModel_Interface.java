package com.example.mmm.mvvm;

import com.example.mmm.bean.Account;

public interface MVVMModel_Interface {
    void getAccountData(String accountName, CallBack callBack);

    // 这个属于modal的功能，所以写在这里好些
    interface CallBack {
        void onSuccess(Account account);

        void onFail();
    }
}

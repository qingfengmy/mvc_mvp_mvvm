package com.example.mmm.mvp;

import com.example.mmm.bean.Account;

public interface MVPActivity_Interface {

    //展示获取信息成功界面
    void showSuccessPage(Account account);

    //展示获取信息失败界面
    void showFailPage();
}

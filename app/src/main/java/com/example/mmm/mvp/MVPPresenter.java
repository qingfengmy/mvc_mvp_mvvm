package com.example.mmm.mvp;

import com.example.mmm.bean.Account;

public class MVPPresenter {
    // 本来应该是实例，降低耦合，用接口隔开，只需要部分函数，不需要其他函数；
    private MVPModal_Interface mvpModal;
    // 本来应该是实例，降低耦合，使用接口，不需要activity其他复杂的部分，只需要交互相关的东西。
    private MVPActivity_Interface mvpActivity;

    public MVPPresenter(MVPActivity_Interface mvpActivity) {
        this.mvpModal = new MVPModal();
        this.mvpActivity = mvpActivity;
    }
    // 查询逻辑
    public void getAccountData(String accountName){
        mvpModal.getAccountData(accountName, new MVPModal_Interface.CallBack() {
            @Override
            public void onSuccess(Account account) {
                mvpActivity.showSuccessPage(account);
            }

            @Override
            public void onFail() {
                mvpActivity.showFailPage();
            }
        });
    }
}

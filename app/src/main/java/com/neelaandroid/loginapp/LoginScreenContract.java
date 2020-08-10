package com.neelaandroid.loginapp;

public interface LoginScreenContract {
    interface View extends BaseView<Presenter> {
        void showValidationErrorMsg(String message);
        void loginSuccessFully();
        void loginFail();
    }

    interface Presenter extends BasePresenter {

        void handleLogin(String username, String password);
    }
}

package com.neelaandroid.loginapp.presenters;

import android.text.TextUtils;
import android.util.Patterns;

import com.neelaandroid.loginapp.App;
import com.neelaandroid.loginapp.LoginScreenContract;
import com.neelaandroid.loginapp.utils.SharedPreferencesClass;

public class LoginScreenPresenterImpl implements LoginScreenContract.Presenter {
    private LoginScreenContract.View view;
    private final String EMAIL= "neelam26@gmail.com";
    private final String  PWD= "neelam123";

    public LoginScreenPresenterImpl(LoginScreenContract.View view) {
        this.view = view;
        this.view.setPresenter(this);
    }

    @Override
    public void handleLogin(String username, String password) {

        if (hasError(username, password)) {
            return;
        } else {
            if (username.equals(EMAIL) && password.equals(PWD)) {
                SharedPreferencesClass preferencesClass = new SharedPreferencesClass(App.getContext());
                preferencesClass.createUserLoginSession("userName", username);
                preferencesClass.createUserLoginSession("password", password);
                view.loginSuccessFully();

            } else {
                view.loginFail();
            }

        }
    }


    private boolean hasError(String username, String password) {
        if (TextUtils.isEmpty(username)) {
            view.showValidationErrorMsg("The email is empty");
            return true;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(username).matches()) {
            view.showValidationErrorMsg("The email is invalid");
            return true;

        }

        if (TextUtils.isEmpty(password)) {
            view.showValidationErrorMsg("The password is empty");
            return true;
        }

        if (password.length() < 5) {
            view.showValidationErrorMsg("Password is weak");
            return true;
        }
        return false;

    }

//
//    @Override
//
//    public void start() {
//
//    }
}

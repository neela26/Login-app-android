package com.neelaandroid.loginapp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.neelaandroid.loginapp.LoginScreenContract;
import com.neelaandroid.loginapp.R;
import com.neelaandroid.loginapp.presenters.LoginScreenPresenterImpl;


public class LoginActivity extends AppCompatActivity  implements LoginScreenContract.View {
    EditText mEditUserName, mEditPassword;
    Button mButtonLogin;
    LoginScreenContract.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        presenter=new LoginScreenPresenterImpl(this);

        mEditUserName = (EditText) findViewById(R.id.EditText_Username);
        mEditPassword = (EditText) findViewById(R.id.EditText_Password);
        mButtonLogin =  (Button) findViewById(R.id.Button_login);

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               presenter.handleLogin(mEditUserName.getText().toString().trim(), mEditPassword.getText().toString().trim());
            }
        });

    }

    @Override
    public void showValidationErrorMsg(String message) {
        Toast.makeText(this, ""+message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccessFully() {
        Toast.makeText(this, this.getString(R.string.login_success), Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,DashboardActivity.class);
       startActivity(intent);
       finish();
    }


    @Override
    public void loginFail() {
        Toast.makeText(this, this.getString(R.string.login_fail), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(LoginScreenContract.Presenter presenter) {
        this.presenter=presenter;

    }
}
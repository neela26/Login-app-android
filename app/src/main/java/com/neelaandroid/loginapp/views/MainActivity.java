package com.neelaandroid.loginapp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.neelaandroid.loginapp.R;
import com.neelaandroid.loginapp.utils.SharedPreferencesClass;

public class MainActivity extends AppCompatActivity {
     SharedPreferencesClass  mPreferencesClass;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    //    setContentView(R.layout.activity_main);
       mPreferencesClass=new SharedPreferencesClass(this);
       if(mPreferencesClass.isUserLoggedIn())
       {
           intent=new Intent(this,DashboardActivity.class);
       }
       else
       {
           intent = new Intent(MainActivity.this, LoginActivity.class);
       }

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK |
                Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();


    }
}
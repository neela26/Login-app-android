package com.neelaandroid.loginapp.utils;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class SharedPreferencesClass {
    public static final String userName = "UserName";
    public static final String password = "Password";
    private static final String IS_USER_LOGIN = "IsUserLoggedIn";
    SharedPreferences mPref;
    SharedPreferences.Editor editor;
    Context context;

    public SharedPreferencesClass(Context context) {
        this.context = context;
        mPref = context.getApplicationContext().getSharedPreferences("user_details", MODE_PRIVATE);
        editor = mPref.edit();
    }

    public void createUserLoginSession(String key, String Value) {
        editor.putBoolean(IS_USER_LOGIN, true);
        editor.putString(key, Value); // Storing string
        editor.commit(); // commit changes
    }

    public String getValue(String key) {
        return mPref.getString(key, null); // getting String
    }

    public void clear(Context context) {
        editor.clear();
        editor.commit(); // commit changes

    }

    public boolean isUserLoggedIn() {
        return mPref.getBoolean(IS_USER_LOGIN, false);
    }

}



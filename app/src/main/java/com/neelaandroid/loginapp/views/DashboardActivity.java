package com.neelaandroid.loginapp.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.neelaandroid.loginapp.R;
import com.neelaandroid.loginapp.utils.SharedPreferencesClass;

public class DashboardActivity extends AppCompatActivity {
    TextView mTextViewUserName;
    SharedPreferencesClass mPreferencesClass;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        mTextViewUserName = findViewById(R.id.Text_UserName);
        mPreferencesClass = new SharedPreferencesClass(this);
        String name = mPreferencesClass.getValue("userName");
        mTextViewUserName.setText(this.getString(R.string.user_welcome_message)+ name);

        intent = new Intent(this, MainActivity.class);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.setting:
                break;
            case R.id.logout:
                mPreferencesClass.clear(this);
                startActivity(intent);
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
package com.sanchev.provectus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.wang.avi.AVLoadingIndicatorView;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        InternetConnectionChecker internetConnectionChecker = new InternetConnectionChecker(this);
        internetConnectionChecker.execute();
    }

    public void internetIsOk() {
        UserStorage.getInstance(this);
    }

    public void updateUsersList() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
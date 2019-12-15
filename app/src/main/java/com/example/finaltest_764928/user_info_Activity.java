package com.example.finaltest_764928;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class user_info_Activity extends AppCompatActivity {
    public static final String TAG = "id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info_);

        userInfo_fragment userInfoFragment = (userInfo_fragment) getSupportFragmentManager().findFragmentById(R.id.userInfo);
        Intent intent = getIntent();
        int id = intent.getExtras().getInt(TAG);
        userInfoFragment.showDetails(id);
    }


}

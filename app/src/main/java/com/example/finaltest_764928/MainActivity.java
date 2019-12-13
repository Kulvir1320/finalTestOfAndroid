package com.example.finaltest_764928;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private boolean mIsDualPane = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View detailView = findViewById(R.id.userInfo);
        mIsDualPane = detailView != null && detailView.getVisibility() == View.VISIBLE;
    }
}

package com.example.finaltest_764928;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements Listener {
    private boolean mIsDualPane = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View detailView = findViewById(R.id.userInfo);
        mIsDualPane = detailView != null && detailView.getVisibility() == View.VISIBLE;
    }


    @Override
    public void onItemClick(int id) {
        if (mIsDualPane){
            userInfo_fragment userInfoFragment =  (userInfo_fragment) getSupportFragmentManager().findFragmentById(R.id.userInfo);
            userInfoFragment.showDetails(id);


        }else{
            Intent intent = new Intent(this,user_info_Activity.class);
            intent .putExtra(user_info_Activity.TAG,id);
            startActivity(intent);
        }
    }
}

package com.example.finaltest_764928;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registerActivity extends AppCompatActivity {
   EditText name, email, phone;
   Button adduser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
       phone = findViewById(R.id.number);
        adduser = findViewById(R.id.save);

        adduser.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View view) {
                if(!name.getText().toString().isEmpty() & !email.getText().toString().isEmpty() &
                        !phone.getText().toString().isEmpty()){
                    UserDetails user = new UserDetails(name.getText().toString()
                             ,email.getText().toString(),phone.getText().toString());
                    Toast.makeText(registerActivity.this,"Save succesfully", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(registerActivity.this,TrafficLight_activity.class);
                    intent.putExtra("user",user);
                    startActivity(intent);
                } else {
                   Toast.makeText(registerActivity.this,"fill y0ur fileds", Toast.LENGTH_LONG).show();
                }
            }
       });



    }
}

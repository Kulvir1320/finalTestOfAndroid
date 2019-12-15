package com.example.finaltest_764928;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class TrafficLight_activity extends AppCompatActivity {
    GridView gridView;
    ImageButton refresh;
    Button verify;
    CheckBox checkBox;
    int[] Traficimages = {R.drawable.img1, R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,
            R.drawable.img6,R.drawable.img7,R.drawable.img8,R.drawable.img9};
    int[] correctImages = {R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4};
    boolean[] clicked = {false, false, false, false, false, false, false, false, false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traffic_light_activity);
        refresh = findViewById(R.id.refresh);
        gridView = findViewById(R.id.gridView);
        verify = findViewById(R.id.verify);
        checkBox = findViewById(R.id.box);
        final IconAdapter iconAdapter = new IconAdapter(this,Traficimages);
        gridView.setAdapter(iconAdapter);


        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Traficimages = func;

                for(int a = 0; a<6; a++)
                {
                    int i = Traficimages[a];
                    Traficimages[a] = Traficimages[a+1];
                    Traficimages[a+1] = i;
                }
               gridView.setAdapter(iconAdapter);
               iconAdapter.notifyDataSetChanged();



            }

        });

        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int match = 0;
                int tickmark_total = 0;

                for (int a = 0; a < clicked.length; a++) {
                    if (clicked[a] == true) {
                        tickmark_total++;


                        for (int index = 0; index < correctImages.length; index++) {
                            if (correctImages[index] == Traficimages[a]) {
                                match += 1;
                            }
                        }
                    }
                }
                if (checkBox.isChecked()) {

                    if (match == tickmark_total) {

                        Intent intent = getIntent();
                        UserDetails userDetails = (UserDetails) intent.getSerializableExtra("user");
                        UserDetails.DetailsOfUser.add(userDetails);
                        Intent intent1 = new Intent(TrafficLight_activity.this, MainActivity.class);
                        startActivity(intent1);
                    }


                } else {

                    Toast.makeText(TrafficLight_activity.this, "check box not checked", Toast.LENGTH_SHORT).show();
                }

            }


        });


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ImageView imageView = view.findViewById(R.id.image_view);
                if (clicked[i] == false){

                imageView.setImageResource(R.drawable.checked);
                clicked[i] = true;}
                else{
                    imageView.setImageResource(0);
                    clicked[i] = false;
                }
            }
        });
    }




}

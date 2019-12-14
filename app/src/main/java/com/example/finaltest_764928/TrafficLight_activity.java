package com.example.finaltest_764928;

import androidx.appcompat.app.AppCompatActivity;

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
    int[] clicked = {0,0,0,0,0,0,0,0,0};

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
                gridView.setAdapter(iconAdapter);
                iconAdapter.notifyDataSetChanged();
            }


        });

        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int rightCount = 0;
                int clickedCount = 0;

                for (int i =0;i<clicked.length; i++)
                    if(clicked[i] == 1){
                        clickedCount +=1;
                        for(int j=0; j<correctImages.length;j++)
                        {
                            if(correctImages[j] == Traficimages[i]){
                                rightCount +=1;
                            }
                        }
                    }
                if(rightCount==4 & clickedCount==4 & checkBox.isChecked()) {

                    Toast.makeText(TrafficLight_activity.this, "succesfull", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(TrafficLight_activity.this, "not able to reister", Toast.LENGTH_LONG).show();
                }
            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ImageView imageView = view.findViewById(R.id.image_view);
                imageView.setImageResource(R.drawable.checked);
            }
        });
    }




}

package com.example.onlinetrainingandcourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Popular extends AppCompatActivity {

    private ImageView homefooterpannel, homeHomebtn, homeedubtn, homesrcbtn, homesavebtn, homeprofilebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular);

        homefooterpannel = findViewById(R.id.homefooterpannel);
        homeHomebtn = findViewById(R.id.homeHomebtn);
        homeedubtn = findViewById(R.id.homeedubtn);
        homesrcbtn = findViewById(R.id.homesrcbtn);
        homesavebtn = findViewById(R.id.homesavebtn);
        homeprofilebtn = findViewById(R.id.homeprofilebtn);

        homeHomebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Popular.this, Home.class);
                startActivity(intent);
            }
        });

        homeedubtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Popular.this, EducationActivity.class);
                startActivity(intent);
            }
        });

        homesavebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Popular.this, SaveActivity.class);
                startActivity(intent);
            }
        });

        homeprofilebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Popular.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
    }
}
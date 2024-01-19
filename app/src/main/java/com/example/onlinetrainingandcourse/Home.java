package com.example.onlinetrainingandcourse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class Home extends AppCompatActivity {

    private RecyclerView horizontalRecyclerView;
    private LinearLayout HomeAlltopicsbtn, homePopularbtn, homeNewestbtn, homeAdvancebtn;
    private ImageView homefooterpannel, homeHomebtn, homeedubtn, homesrcbtn, homesavebtn, homeprofilebtn;
    private TextView homeSeeAllbtn;

    HomeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Initialize all variables using findViewById
        horizontalRecyclerView = findViewById(R.id.homeRecycleView);
        HomeAlltopicsbtn = findViewById(R.id.HomeAlltopicsbtn);
        homePopularbtn = findViewById(R.id.homePopularbtn);
        homeNewestbtn = findViewById(R.id.homeNewestbtn);
        homeAdvancebtn = findViewById(R.id.homeAdvancebtn);
        homefooterpannel = findViewById(R.id.homefooterpannel);
        homeHomebtn = findViewById(R.id.homeHomebtn);
        homeedubtn = findViewById(R.id.homeedubtn);
        homesrcbtn = findViewById(R.id.homesrcbtn);
        homesavebtn = findViewById(R.id.homesavebtn);
        homeprofilebtn = findViewById(R.id.homeprofilebtn);
        homeSeeAllbtn = findViewById(R.id.homeSeeAllbtn);


        // Create a LinearLayoutManager with horizontal orientation
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        // Set the LayoutManager for the RecyclerView
        horizontalRecyclerView.setLayoutManager(layoutManager);

        // Create and set an adapter for your RecyclerView
//        HomeAdapter homeAdapter = new HomeAdapter();
//        horizontalRecyclerView.setAdapter(adapter);
//        horizontalRecyclerView.setAdapter(homeAdapter);


        // when clicked on home button

        homeHomebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Home.class);
                startActivity(intent);
                finish();
            }
        });

        // when clicked on education button

        homeedubtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, EducationActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // when clicked on search button

        homesrcbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, SearchActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // when clicked on save button

        homesavebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, SaveActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // when clicked on profile button

        homeprofilebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, ProfileActivity.class);
                startActivity(intent);
                finish();
            }
        });

        HomeAlltopicsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, AllTopics.class);
                startActivity(intent);
            }
        });

        homePopularbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,Popular.class);
                startActivity(intent);
            }
        });

        homeNewestbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,Newest.class);
                startActivity(intent);
            }
        });

        homeAdvancebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Advanace.class);
                startActivity(intent);
            }
        });


        //card..got this code from firebase documentation..
        //https://firebase.google.com/docs/database/android/read-and-write
        //now whole firebase data has been fetched in the options variable..

        FirebaseRecyclerOptions<HomeModel> options =
                new FirebaseRecyclerOptions.Builder<HomeModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("homecard"), HomeModel.class)
                        .build();



        //now we will pass this options variable to the adapter..
//        adapter = new HomeAdapter(options);

        adapter = new HomeAdapter(options, new HomeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(HomeModel model) {
                // Handle item click here, e.g., start CodeDetailsActivity and pass data
                Intent intent = new Intent(Home.this, CodeDetailsActivity.class);
                intent.putExtra("coursename", model.getCoursename());
                intent.putExtra("description", model.getDescription());
                intent.putExtra("offerby", model.getOfferby());
                intent.putExtra("videourl", model.getVideourl());
                intent.putExtra("rating", model.getRating());
                // Add any other data you want to pass to CodeDetailsActivity
                startActivity(intent);
            }
        });
        horizontalRecyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }


}
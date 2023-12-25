package com.example.onlinetrainingandcourse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.SearchView;
//import android.widget.Toolbar;


import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;
import androidx.appcompat.widget.Toolbar;

public class EducationActivity extends AppCompatActivity {

    private Toolbar careerToolbar;
    private SearchView careerSearchView;
    private SwipeRefreshLayout careerRefreshLayout;
    private RecyclerView careerListView;
    private FloatingActionButton careerFilterFab;
    HomeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);

        // Initialize variables using findViewById
        careerToolbar = findViewById(R.id.career_toolbar);
        careerSearchView = findViewById(R.id.career_search_view);
//        careerRefreshLayout = findViewById(R.id.career_refresh_layout);
        careerListView = findViewById(R.id.career_list_view);
        careerFilterFab = findViewById(R.id.career_filter_fab);

        // Set up your RecyclerView (example: setLayoutManager)
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        careerListView.setLayoutManager(layoutManager);

        // Now you can use these variables as needed in your activity
        // For example, you can set up a click listener for the FloatingActionButton
        careerFilterFab.setOnClickListener(view -> {
            // Handle the click event for the FloatingActionButton
        });

        FirebaseRecyclerOptions<HomeModel> options =
                new FirebaseRecyclerOptions.Builder<HomeModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("homecard"), HomeModel.class)
                        .build();


        adapter = new HomeAdapter(options, new HomeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(HomeModel model) {
                // Handle item click here, e.g., start CodeDetailsActivity and pass data
                Intent intent = new Intent(EducationActivity.this, CodeDetailsActivity.class);
                intent.putExtra("coursename", model.getCoursename());
                intent.putExtra("description", model.getDescription());
                intent.putExtra("offerby", model.getOfferby());
                intent.putExtra("videourl", model.getVideourl());
                intent.putExtra("rating", model.getRating());
                // Add any other data you want to pass to CodeDetailsActivity
                startActivity(intent);
            }
        });
        careerListView.setAdapter(adapter);


    }



}
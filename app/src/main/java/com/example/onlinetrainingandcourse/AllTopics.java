package com.example.onlinetrainingandcourse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.annotations.NonNull;

public class AllTopics extends AppCompatActivity {
    private ImageView homefooterpannel, homeHomebtn, homeedubtn, homesrcbtn, homesavebtn, homeprofilebtn;
    RecyclerView recyclerView;


    private AllTopicAdapter adapter;
    private List<AllTopicModel> topicList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_topics);
        homefooterpannel = findViewById(R.id.homefooterpannel);
        homeHomebtn = findViewById(R.id.homeHomebtn);
        homeedubtn = findViewById(R.id.homeedubtn);
        homesrcbtn = findViewById(R.id.homesrcbtn);
        homesavebtn = findViewById(R.id.homesavebtn);
        homeprofilebtn = findViewById(R.id.homeprofilebtn);
        recyclerView = findViewById(R.id.topic_list);

        // Create a LinearLayoutManager with horizontal orientation
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        // Set the LayoutManager for the RecyclerView
        recyclerView.setLayoutManager(layoutManager);

        homeHomebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllTopics.this, Home.class);
                startActivity(intent);
            }
        });

        homeedubtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllTopics.this, EducationActivity.class);
                startActivity(intent);
            }
        });

        homesavebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllTopics.this, SaveActivity.class);
                startActivity(intent);
            }
        });

        homeprofilebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllTopics.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

//        topicList = new ArrayList<>();
//        adapter = new AllTopicAdapter(topicList);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(adapter);
//
//        // Fetch data from Firebase Realtime Database
//        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("alltopic");
//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                topicList.clear();
//                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
//                    AllTopicModel topic = dataSnapshot.getValue(AllTopicModel.class);
//                    topicList.add(topic);
//                }
//                adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                // Handle errors
//            }
//        });

        FirebaseRecyclerOptions<AllTopicModel> options =
                new FirebaseRecyclerOptions.Builder<AllTopicModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("alltopic"), AllTopicModel.class)
                        .build();

        adapter = new AllTopicAdapter(options);
        recyclerView.setAdapter(adapter);



    }
}
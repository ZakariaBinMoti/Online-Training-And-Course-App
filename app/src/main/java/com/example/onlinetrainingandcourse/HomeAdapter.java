package com.example.onlinetrainingandcourse;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.FirebaseApp;

//public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.viewholder> {
public class HomeAdapter extends FirebaseRecyclerAdapter<HomeModel, HomeAdapter.viewholder> {

    private final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(HomeModel model);
    }



    public HomeAdapter(@NonNull FirebaseRecyclerOptions<HomeModel> options, OnItemClickListener listener) {
        super(options);
        this.listener = listener;
    }

//    public HomeAdapter(@NonNull FirebaseRecyclerOptions<HomeModel> options) {
//        super(options);
//    }
    @Override
    protected void onBindViewHolder(@NonNull viewholder holder, int position, @NonNull HomeModel model) {

        holder.homeTitle.setText(model.getCoursename());
        holder.homeofferby.setText(model.getOfferby());
//        holder.homeratings.setText(model.getRating().toString());
        // Handle potential null rating
        if (model.getRating() != null) {
            holder.homeratings.setText(model.getRating().toString());
        } else {
            holder.homeratings.setText("N/A");
        }
        if (model.getPicurl() != null) {
            FirebaseApp.initializeApp(holder.homeImage.getContext());

            Glide.with(holder.homeImage.getContext()).load(model.getPicurl()).into(holder.homeImage);
        } else {
            // Optionally, you can set a placeholder or handle the case where the URL is null.
            Glide.with(holder.homeImage.getContext()).load(R.drawable.java).into(holder.homeImage);
        }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(getItem(position));
                }
            }
        });



    }



    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_card_row, parent, false);
        return new viewholder(view);


    }


//    @NonNull
//    @Override
//    public HomeAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return null;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull HomeAdapter.viewholder holder, int position) {
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return 0;
//    }

    public class viewholder extends RecyclerView.ViewHolder {

        ImageView homeImage;
        TextView homeTitle, homeofferby, homeratings;
         public viewholder(@NonNull View itemView) {


            super(itemView);
            homeImage = itemView.findViewById(R.id.homecardimage);
            homeTitle = itemView.findViewById(R.id.homecardcoursename);
            homeofferby = itemView.findViewById(R.id.homecardcourseoffer);
            homeratings = itemView.findViewById(R.id.homecardcourserating);

             itemView.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     int position = getAdapterPosition();
                     if (position != RecyclerView.NO_POSITION) {
                         listener.onItemClick(getItem(position));
                     }
                 }
             });
        }
    }
}

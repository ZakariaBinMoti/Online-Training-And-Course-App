package com.example.onlinetrainingandcourse;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.List;

import io.reactivex.rxjava3.annotations.NonNull;

//public class AllTopicAdapter extends RecyclerView.Adapter<AllTopicAdapter.ViewHolder> {
////public class AllTopicAdapter extends FirebaseRecyclerAdapter<AllTopicModel, AllTopicAdapter.ViewHolder>{
//
//    private List<AllTopicModel> topicList;
//
//    public AllTopicAdapter(List<AllTopicModel> topicList) {
//        this.topicList = topicList;
//    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_topic_row, parent, false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        AllTopicModel topic = topicList.get(position);
//        holder.topicNameTextView.setText(topic.getTopicName());
//    }
//
//    @Override
//    public int getItemCount() {
//        return topicList.size();
//    }
//
//    public static class ViewHolder extends RecyclerView.ViewHolder {
//        TextView topicNameTextView;
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            topicNameTextView = itemView.findViewById(R.id.topicrowtextView);
//        }
//    }
//}

public class AllTopicAdapter extends FirebaseRecyclerAdapter<AllTopicModel, AllTopicAdapter.ViewHolder>{
    public AllTopicAdapter(@NonNull FirebaseRecyclerOptions<AllTopicModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull AllTopicModel model) {
        holder.topicNameTextView.setText(model.getTopicName());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_topic_row, parent, false);
        return new ViewHolder(view);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView topicNameTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            topicNameTextView = itemView.findViewById(R.id.topicrowtextView);
        }
    }
}


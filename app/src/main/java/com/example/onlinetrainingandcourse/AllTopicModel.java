package com.example.onlinetrainingandcourse;

public class AllTopicModel {

    private String topicName;

    public AllTopicModel() {
        // Default constructor required for Firebase
    }

    public AllTopicModel(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }
}

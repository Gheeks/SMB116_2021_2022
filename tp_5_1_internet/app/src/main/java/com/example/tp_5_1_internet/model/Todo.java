package com.example.tp_5_1_internet.model;
import org.json.JSONObject;

public class Todo {

    private int userId;
    private int id;
    private String title;
    private boolean completed;

    public Todo(JSONObject jsonObject) {
        this.userId = jsonObject.optInt("userId");
        this.id = jsonObject.optInt("id");
        this.title = jsonObject.optString("title");
        this.completed = jsonObject.optBoolean("completed");
    }

    @Override
    public String toString() {
        return "Todo{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
package com.example.tp_5_1_internet.rest;

import com.example.tp_5_1_internet.model.Todo;

import java.util.List;

public interface TodoListCallback {
    void onSuccess(List<Todo> todoList);
    void onFailure(String errorMsg);
}

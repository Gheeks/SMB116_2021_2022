package com.example.tp_5_1_internet.rest;

import com.example.tp_5_1_internet.model.Todo;

public interface TodoCallback {
    void onSuccess(Todo todo);
    void onFailure(String errorMsg);
}

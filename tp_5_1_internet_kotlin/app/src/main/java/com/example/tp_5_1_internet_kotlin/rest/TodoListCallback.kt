package com.example.tp_5_1_internet_kotlin.rest

import com.example.tp_5_1_internet_kotlin.model.Todo

interface TodoListCallback {
    fun onSuccess(todoList: List<Todo>)
    fun onFailure(errorMsg: String?)
}
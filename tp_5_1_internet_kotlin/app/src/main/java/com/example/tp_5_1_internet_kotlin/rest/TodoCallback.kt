package com.example.tp_5_1_internet_kotlin.rest

import com.example.tp_5_1_internet_kotlin.model.Todo

interface TodoCallback {
    fun onSuccess(todo: Todo)
    fun onFailure(errorMsg: String?)
}
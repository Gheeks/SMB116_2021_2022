package com.example.tp_5_1_internet_kotlin.model

import org.json.JSONObject

class Todo(jsonObject: JSONObject) {

    private val id: Int
    private val userId: Int
    private val title: String
    private val completed: Boolean

    init {
       with(jsonObject) {
           id = optInt("userId")
           userId = optInt("id")
           title = optString("title")
           completed = optBoolean("completed")
       }
    }

    override fun toString(): String {
        return "Todo(id=$id, userId=$userId, title='$title', completed=$completed)"
    }

}
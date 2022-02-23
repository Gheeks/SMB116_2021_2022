package com.example.tp_5_1_internet_kotlin.rest

import com.example.tp_5_1_internet_kotlin.model.Todo
import okhttp3.*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.util.*
import java.util.concurrent.TimeUnit

class Repository {

    // Création d'un client http avec des timeouts de 10 secondes
    private val client: OkHttpClient = OkHttpClient.Builder()
        .callTimeout(10, TimeUnit.SECONDS)
        .connectTimeout(10, TimeUnit.SECONDS)
        .build()

    fun getTodoList(callback: TodoListCallback) {
        val todoList: ArrayList<Todo> = ArrayList<Todo>()
        val request: Request = Request.Builder()
            .url("https://jsonplaceholder.typicode.com/todos")
            .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                callback.onFailure(e.message)
            }

            @Throws(IOException::class)
            override fun onResponse(call: Call, response: Response) {
                try {
                    response.body.use { responseBody ->
                        if (!response.isSuccessful || responseBody == null) {
                            callback.onFailure(response.message)
                            return
                        }

                        // Api is returning an array
                        val jsonArray = JSONArray(responseBody.string())
                        for (i in 0 until jsonArray.length()) {
                            val todo = Todo(jsonArray.getJSONObject(i))
                            todoList.add(todo)
                        }
                        callback.onSuccess(todoList)
                    }
                } catch (e: JSONException) {
                    callback.onFailure(e.message)
                }
            }
        })
    }

    fun getTodo(id: String, callback: TodoCallback) {
        val request: Request = Request.Builder()
            .url("https://jsonplaceholder.typicode.com/todos/$id")
            .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                callback.onFailure(e.message)
            }

            @Throws(IOException::class)
            override fun onResponse(call: Call, response: Response) {
                try {
                    response.body.use { responseBody ->
                        if (!response.isSuccessful || responseBody == null) {
                            callback.onFailure(response.message)
                            return
                        }
                        val jsonObj = JSONObject(responseBody.string())
                        callback.onSuccess(Todo(jsonObj))
                    }
                } catch (e: JSONException) {
                    callback.onFailure(e.message)
                }
            }
        })
    }

    // 1 - En s'aidant des méthodes ci-dessus, complétez le corps et les paramètres des méthodes pour :
    // - Récupérer la liste des utilisateurs
    // - Récupérer un utilisateur par son id
    // - Récupérer la liste des commentaires
    // - Récupérer un commentaire par son id
    val userList: Unit
        get() {}

    fun getUser(id: String?) {}
    val commentList: Unit
        get() {}

    fun getComment(id: String?) {}
}
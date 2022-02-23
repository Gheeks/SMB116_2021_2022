package com.example.tp_5_1_internet.rest;

import com.example.tp_5_1_internet.model.Todo;
import com.example.tp_5_1_internet.model.User;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class Repository {

    private final OkHttpClient client;

    public Repository() {
        // Création d'un client http avec des timeouts de 10 secondes
        client = new OkHttpClient.Builder()
                .callTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .build();
    }

    public void getTodoList(TodoListCallback callback) {
        ArrayList<Todo> todoList = new ArrayList<>();

        Request request = new Request.Builder()
                .url("https://jsonplaceholder.typicode.com/todos")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                callback.onFailure(e.getMessage());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try(ResponseBody responseBody = response.body()) {
                    if (!response.isSuccessful() || responseBody == null) {
                        callback.onFailure(response.message());
                        return;
                    }

                    // Api is returning an array
                    JSONArray jsonArray = new JSONArray(responseBody.string());

                    for (int i = 0; i < jsonArray.length(); i++) {
                        Todo todo = new Todo(jsonArray.getJSONObject(i));
                        todoList.add(todo);
                    }

                    callback.onSuccess(todoList);

                }  catch (JSONException e) {
                    callback.onFailure(e.getMessage());
                }
            }
        });
    }

    public void getTodo(String id, TodoCallback callback) {
        Request request = new Request.Builder()
                .url("https://jsonplaceholder.typicode.com/todos/" + id)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                callback.onFailure(e.getMessage());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try(ResponseBody responseBody = response.body()) {
                    if (!response.isSuccessful() || responseBody == null) {
                        callback.onFailure(response.message());
                        return;
                    }

                    JSONObject jsonObj = new JSONObject(responseBody.string());
                    callback.onSuccess(new Todo(jsonObj));

                }  catch (JSONException e) {
                    callback.onFailure(e.getMessage());
                }
            }
        });
    }

    // 1 - En s'aidant des méthodes ci-dessus, complétez le corps et les paramètres des méthodes pour :
    // - Récupérer la liste des utilisateurs
    // - Récupérer un utilisateur par son id
    // - Récupérer la liste des commentaires
    // - Récupérer un commentaire par son id

    public void getUserList() {

    }

    public void getUser(String id) {

    }

    public void getCommentList() {

    }

    public void getComment(String id) {

    }
}

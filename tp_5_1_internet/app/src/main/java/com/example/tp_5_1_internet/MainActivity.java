package com.example.tp_5_1_internet;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tp_5_1_internet.model.Todo;
import com.example.tp_5_1_internet.rest.Repository;
import com.example.tp_5_1_internet.rest.TodoCallback;
import com.example.tp_5_1_internet.rest.TodoListCallback;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private final ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() {
        @Override
        public void onAvailable(@NonNull Network network) {
            super.onAvailable(network);
            checkConnectionForActiveNetwork(connectivityManager.getActiveNetwork());
        }

        @Override
        public void onLost(@NonNull Network network) {
            super.onLost(network);
            checkConnectionForActiveNetwork(connectivityManager.getActiveNetwork());
        }

        @Override
        public void onCapabilitiesChanged(@NonNull Network network, @NonNull NetworkCapabilities networkCapabilities) {
            super.onCapabilitiesChanged(network, networkCapabilities);
        }
    };

    private ConnectivityManager connectivityManager = null;
    private boolean hasConnection = false;
    private TextView connectionBanner;

    private Repository repository;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        repository = new Repository();

        connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        Network currentNetwork = connectivityManager.getActiveNetwork();

        // 1 - Récupérer la TextView défini dans le fichier `activity_main.xml`

        // 2 - Compléter la méthode `checkConnectionForActiveNetwork`

        // 3 - Ajouter la callback `networkCallback` a notre objet `connectivityManager`

        // ---- Partie 3 ---- //
        fetchTodoList();
        fetchTodo("5");
        fetchUserList();
        fetchUser("3");
        fetchCommentList();
        fetchComment("12");
        // ---- Partie 3 ---- //

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 4 - Supprimer la callback `networkCallback` de notre objet `connectivityManager`
    }

    // 5 - Modifier le texte et le background de la TextView en utilisant les ressources strings et colors
    private void displayConnectionBanner() {
        // On lance le code sur le Main Thread pour mettre à jour l'affichage
        runOnUiThread(() -> {
            if (hasConnection) {
                // 5' - String = you_are_connected / Background color = connected_color
            } else {
                // 5" - String = you_are_not_connected / Background color = disconnected_color
            }
        });
    }

    private void checkConnectionForActiveNetwork(@Nullable Network network) {
        if (network != null) {

            NetworkCapabilities capabilities = connectivityManager.getNetworkCapabilities(network);

            if (capabilities != null) {
                // 2' - Modifier le boolean `hasConnection` si nous avons du transport Wifi OU Cellular
            } else {
                hasConnection = false;
            }
        } else {
            hasConnection = false;
        }

        displayConnectionBanner();
    }

    // ---- Partie 3 ---- //

    private void fetchTodoList() {
        repository.getTodoList(new TodoListCallback() {
            @Override
            public void onSuccess(List<Todo> todoList) {
                Log.d(TAG, "onSuccess: " + todoList);
            }

            @Override
            public void onFailure(String errorMsg) {
                Log.e(TAG, "onFailure: " + errorMsg);
            }
        });
    }

    private void fetchTodo(@NonNull String id) {
        repository.getTodo(id, new TodoCallback() {
            @Override
            public void onSuccess(Todo todo) {
                Log.d(TAG, "onSuccess: " + todo);
            }

            @Override
            public void onFailure(String errorMsg) {
                Log.e(TAG, "onFailure: " + errorMsg);
            }
        });
    }

    private void fetchUserList() {

    }

    private void fetchUser(@NonNull String id) {

    }

    private void fetchCommentList() {

    }

    private void fetchComment(@NonNull String id) {

    }
}

package com.example.tp_5_1_internet_kotlin

import android.net.ConnectivityManager
import android.net.ConnectivityManager.NetworkCallback
import android.net.Network
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tp_5_1_internet_kotlin.model.Todo
import com.example.tp_5_1_internet_kotlin.rest.Repository
import com.example.tp_5_1_internet_kotlin.rest.TodoCallback
import com.example.tp_5_1_internet_kotlin.rest.TodoListCallback

class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "MainActivity"
    }

    private val networkCallback: NetworkCallback = object : NetworkCallback() {
        override fun onAvailable(network: Network) {
            super.onAvailable(network)
            checkConnectionForActiveNetwork(connectivityManager!!.activeNetwork)
        }

        override fun onLost(network: Network) {
            super.onLost(network)
            checkConnectionForActiveNetwork(connectivityManager!!.activeNetwork)
        }
    }

    private var connectivityManager: ConnectivityManager? = null
    private var hasConnection = false
    private val connectionBanner: TextView? = null

    private lateinit var repository: Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        repository = Repository()

        connectivityManager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager?
        val currentNetwork = connectivityManager?.activeNetwork

        // 1 - Récupérer la TextView défini dans le fichier `activity_main.xml`

        // 2 - Compléter la méthode `checkConnectionForActiveNetwork`

        // 3 - Ajouter la callback `networkCallback` a notre objet `connectivityManager`

        // ---- Partie 3 ---- //
        fetchTodoList()
        fetchTodo("5")
        fetchUserList()
        fetchUser("3")
        fetchCommentList()
        fetchComment("12")
        // ---- Partie 3 ---- //
    }

    override fun onDestroy() {
        super.onDestroy()
        // 4 - Supprimer la callback `networkCallback` de notre objet `connectivityManager`
    }

    // 5 - Modifier le texte et le background de la TextView en utilisant les ressources strings et colors
    private fun displayConnectionBanner() {
        // On lance le code sur le Main Thread pour mettre à jour l'affichage
        runOnUiThread {
            if (hasConnection) {
                // 5' - String = you_are_connected / Background color = connected_color
            } else {
                // 5" - String = you_are_not_connected / Background color = disconnected_color
            }
        }
    }

    private fun checkConnectionForActiveNetwork(network: Network?) {
        if (network != null) {
            connectivityManager?.getNetworkCapabilities(network)?.let { networkCapabilities ->
                // 2' - Modifier le boolean `hasConnection` si nous avons du transport Wifi OU Cellular
            } ?: kotlin.run {
                hasConnection = false
            }
        } else {
            hasConnection = false
        }

        displayConnectionBanner()
    }

    // ---- Partie 3 ---- //
    private fun fetchTodoList() {
        repository.getTodoList(object : TodoListCallback {
            override fun onSuccess(todoList: List<Todo>) {
                Log.d(TAG, "onSuccess: $todoList")
            }

            override fun onFailure(errorMsg: String?) {
                Log.d(TAG, "onFailure: $errorMsg")
            }
        })
    }

    private fun fetchTodo(id: String) {
        repository.getTodo(id, object : TodoCallback {
            override fun onSuccess(todo: Todo) {
                Log.d(TAG, "onSuccess: $todo")
            }

            override fun onFailure(errorMsg: String?) {
                Log.d(TAG, "onFailure: $errorMsg")
            }
        })
    }

    private fun fetchUserList() {

    }

    private fun fetchUser(id: String) {

    }

    private fun fetchCommentList() {

    }

    private fun fetchComment(id: String) {

    }
}
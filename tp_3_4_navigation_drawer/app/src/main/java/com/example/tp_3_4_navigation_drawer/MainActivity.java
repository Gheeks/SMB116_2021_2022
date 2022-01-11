package com.example.tp_3_4_navigation_drawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private DrawerLayout drawer;
    private NavigationView navigation;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textview);

        initializeToolbar();
        initializeDrawer();
        initializeNavigation();
    }

    private void initializeToolbar() {
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("MainActivity !");
        setSupportActionBar(toolbar);
    }

    private void initializeDrawer() {
        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    private void initializeNavigation() {
        navigation = findViewById(R.id.navigation);
        navigation.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START))
            drawer.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_import) {
            textView.setText("Import");
        } else if (id == R.id.menu_gallery) {
            textView.setText("Gallery");
        } else if (id == R.id.menu_slideshow) {
            textView.setText("Slideshow");
        } else if (id == R.id.menu_tools) {
            textView.setText("Tools");
        } else if (id == R.id.menu_share) {
            textView.setText("Share");
        } else if (id == R.id.menu_send) {
            textView.setText("Send");
        }

        drawer.closeDrawers();

        return true;
    }
}
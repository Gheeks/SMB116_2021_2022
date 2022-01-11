package com.example.tp_3_3_menus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button alertButton = findViewById(R.id.btn_alert);
        alertButton.setOnClickListener(v -> displayAlertDialog());

        Button dateButton = findViewById(R.id.btn_date);
        dateButton.setOnClickListener(v -> displayDatePicker());
    }

    private void displayAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Alert");
        builder.setMessage("Click OK to continue, or Cancel to stop");
        builder.setPositiveButton("Ok", (dialog, which) -> {
            Toast.makeText(this, "OK button", Toast.LENGTH_LONG).show();
        });
        builder.setNeutralButton("Cancel", (dialog, which) -> {
            Toast.makeText(this, "Cancel button", Toast.LENGTH_LONG).show();
        });
        builder.show();
    }

    private void displayDatePicker() {
        DialogFragment fragment = new DatePickerFragment();
        fragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void showSelectedDate(int year, int month, int dayOfMonth) {
        Toast.makeText(this, dayOfMonth + "/" + month + "/" + year, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.settings) {
            Toast.makeText(this, "Item settings clicked", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
package com.example.lecture2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //current time
        EditText editTextTimeZone = findViewById(R.id.edit_text_4);
        editTextTimeZone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimeZone tz = TimeZone.getDefault();
                String currentTimeZone = tz.getDisplayName(false, TimeZone.SHORT)
                        + " " + new SimpleDateFormat("HH:mm:ss", Locale.getDefault())
                        .format(new Date());
                editTextTimeZone.setText(currentTimeZone);
            }
        });

        //button to next activity
        Button submitButton = findViewById(R.id.message_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                startActivity(intent);
            }
        });

        //back to the top
        FloatingActionButton fab = findViewById(R.id.fab);
        final ScrollView scrollView = findViewById(R.id.scrollview1);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollView.scrollTo(0, 0);
            }
        });

        //delete title
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    //menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
package com.example.lab1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        CheckBox checkBox1 = findViewById(R.id.checkBox1);
        CheckBox checkBox2 = findViewById(R.id.checkBox2);
        CheckBox checkBox3 = findViewById(R.id.checkBox3);
        CheckBox checkBox4 = findViewById(R.id.checkBox4);
        CheckBox checkBox5 = findViewById(R.id.checkBox5);
        CheckBox checkBox6 = findViewById(R.id.checkBox6);
        CheckBox checkBox7 = findViewById(R.id.checkBox7);
        CheckBox checkBox8 = findViewById(R.id.checkBox8);
        CheckBox checkBox9 = findViewById(R.id.checkBox9);

        //Go to next activity
        Button finishButton = findViewById(R.id.finished_button);
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int finalPrice = 0;

                if (checkBox1.isChecked()) finalPrice += 2;
                if (checkBox2.isChecked()) finalPrice += 3;
                if (checkBox3.isChecked()) finalPrice += 4;
                if (checkBox4.isChecked()) finalPrice += 6;
                if (checkBox5.isChecked()) finalPrice += 7;
                if (checkBox6.isChecked()) finalPrice += 7;
                if (checkBox7.isChecked()) finalPrice += 10;
                if (checkBox8.isChecked()) finalPrice += 10;
                if (checkBox9.isChecked()) finalPrice += 12;

                if (finalPrice == 0) {
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Error")
                            .setMessage("Please select at least one item.")
                            .setPositiveButton("OK", null)
                            .show();
                    return;
                }

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("finalPrice", String.valueOf(finalPrice));
                startActivity(intent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
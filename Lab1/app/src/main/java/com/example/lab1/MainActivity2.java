package com.example.lab1;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        //Getting all editTexts and RadioButtons
        EditText userName = findViewById(R.id.user_name);
        EditText userAddress = findViewById(R.id.user_address);
        EditText userDelivery = findViewById(R.id.user_delivery);
        RadioGroup paymentMethod = findViewById(R.id.payment_method_group);

        //Price receiving and displaying
        Intent intent = getIntent () ;
        String finalPrice = intent.getStringExtra("finalPrice");
        TextView priceDisplay = findViewById(R.id.totalPrice);
        priceDisplay.setText("Total: " + finalPrice + "€");

        //Return and send buttons
        Button sendButton = findViewById(R.id.send_button);
        Button returnButton = findViewById(R.id.return_button);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedId = paymentMethod.getCheckedRadioButtonId();

                if (userName.getText().toString().isEmpty() ||
                        userAddress.getText().toString().isEmpty() ||
                        userDelivery.getText().toString().isEmpty()) {
                    new AlertDialog.Builder(MainActivity2.this)
                            .setTitle("Error")
                            .setMessage("Please fill the informations.")
                            .setPositiveButton("OK", null)
                            .show();
                    return;
                }
                if (selectedId == -1) {
                    new AlertDialog.Builder(MainActivity2.this)
                            .setTitle("Error")
                            .setMessage("Please select a payment method.")
                            .setPositiveButton("OK", null)
                            .show();
                }
                else {
                    new AlertDialog.Builder(MainActivity2.this)
                            .setTitle("Order confirmed")
                            .setMessage("Your order is in preparation!")
                            .setPositiveButton("OK", null)
                            .show();
                }
            }
        });
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
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
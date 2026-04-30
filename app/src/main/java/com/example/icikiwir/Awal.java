package com.example.icikiwir;

import android.content.Intent; // Tambahkan import ini
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Awal extends AppCompatActivity {


    Button btnGoToLogin, btnGoToRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_awal);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        btnGoToLogin = findViewById(R.id.btnGoToLogin);
        btnGoToRegister = findViewById(R.id.btnGoToRegister);


        btnGoToLogin.setOnClickListener(v -> {
            Intent intent = new Intent(Awal.this, loginn.class);
            startActivity(intent);
        });


        btnGoToRegister.setOnClickListener(v -> {
            Intent intent = new Intent(Awal.this, MainActivity.class);
            startActivity(intent);
        });
    }
}

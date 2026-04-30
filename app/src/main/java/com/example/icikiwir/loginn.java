package com.example.icikiwir;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class loginn extends AppCompatActivity {

    EditText etEmailL, etPasswordL;
    Button btnLogin;
    BaseApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_loginn);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        etEmailL = findViewById(R.id.etEmailL);
        etPasswordL = findViewById(R.id.etPasswordL);
        btnLogin = findViewById(R.id.btnLogin);


        mApiService = Utilsapi.getAPIService();


        btnLogin.setOnClickListener(v -> {
            String email = etEmailL.getText().toString();
            String password = etPasswordL.getText().toString();

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(loginn.this, "Email dan Password harus diisi", Toast.LENGTH_SHORT).show();
            } else {
                performLogin(email, password);
            }
        });
    }

    private void performLogin(String email, String password) {
        mApiService.loginRequest(email, password).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    Toast.makeText(loginn.this, "Login Berhasil!", Toast.LENGTH_SHORT).show();


                    Intent intent = new Intent(loginn.this, home.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(loginn.this, "Email atau Password Salah", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(loginn.this, "Koneksi Bermasalah: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

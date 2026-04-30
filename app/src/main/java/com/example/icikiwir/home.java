package com.example.icikiwir;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class home extends AppCompatActivity {

    private RecyclerView rvProduk;
    private MenuAdapter adapter;
    private BaseApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        rvProduk = findViewById(R.id.rv_produk);
        rvProduk.setLayoutManager(new LinearLayoutManager(this));


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.16.139.25:81/koneksi_icikiwir/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(BaseApiService.class);



        tampilMenu();
    }

    private void tampilMenu() {
        apiService.getSemuaMenu().enqueue(new Callback<List<MenuModel>>() {
            @Override
            public void onResponse(Call<List<MenuModel>> call, Response<List<MenuModel>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<MenuModel> menuList = response.body();

                    Toast.makeText(home.this, "Data ditemukan: " + menuList.size(), Toast.LENGTH_SHORT).show();


                    adapter = new MenuAdapter(menuList);
                    rvProduk.setAdapter(adapter);

                    Log.d("RetrofitSuccess", "Jumlah data: " + menuList.size());
                } else {

                    Toast.makeText(home.this, "Gagal mengambil data. Code: " + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<MenuModel>> call, Throwable t) {

                Log.e("RetrofitError", t.getMessage());
                Toast.makeText(home.this, "Koneksi Bermasalah: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}

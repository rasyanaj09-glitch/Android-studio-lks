package com.example.icikiwir;

import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET; // Tambahkan ini
import retrofit2.http.POST;
import com.example.icikiwir.MenuModel;


public interface BaseApiService {

    @FormUrlEncoded
    @POST("register.php")
    Call<ResponseBody> registerRequest(
            @Field("FullName") String fullname,
            @Field("Email") String email,
            @Field("Password") String password
    );

    @FormUrlEncoded
    @POST("login.php")
    Call<ResponseBody> loginRequest(
            @Field("Email") String email,
            @Field("Password") String password
    );

    // TAMBAHKAN INI UNTUK MENGAMBIL DATA PRODUK
    @GET("get_produk.php")
    Call<List<MenuModel>> getSemuaMenu();

}

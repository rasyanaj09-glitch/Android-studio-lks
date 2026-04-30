package com.example.icikiwir;

public class Utilsapi {

    public static final String BASE_URL_API = "http://10.0.2.2:81/koneksi_icikiwir/";

    public static BaseApiService getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }
}

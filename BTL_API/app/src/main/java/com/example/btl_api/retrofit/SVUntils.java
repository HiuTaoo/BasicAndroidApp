package com.example.btl_api.retrofit;

public class SVUntils {
    public static final String BASE_URL = "http://192.168.1.143:3333";
    public static SV getService(){
        return retrofitClient.getClient(BASE_URL).create(SV.class);
    }
}

package com.example.retrofitwe;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AppService {
    @GET("/api/users/{userId}")
    Call<ResponseModel>getUser(@Path("userId")int userId);
}

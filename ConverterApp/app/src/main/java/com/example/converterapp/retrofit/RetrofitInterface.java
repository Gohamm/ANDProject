package com.example.converterapp.retrofit;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitInterface {
    @GET("v6/e09f28109605ab96b6c296b2/latest/{currency}")
    Call<RatesResponse> getRates(@Query("currency") String currency);



}

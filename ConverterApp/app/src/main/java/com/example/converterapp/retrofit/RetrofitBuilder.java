package com.example.converterapp.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {

    private static Retrofit.Builder retrofitBuilder =
            new Retrofit.Builder()
            .baseUrl("https://api.exchangerate-api.com/")
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();

    private static RetrofitInterface retrofitInterface = retrofit.create(RetrofitInterface.class);

    public static RetrofitInterface getRetrofitInterface() {
        return retrofitInterface;

    }


}

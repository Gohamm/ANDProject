package com.example.converterapp.Repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.converterapp.retrofit.RatesResponse;
import com.example.converterapp.retrofit.RetrofitBuilder;
import com.example.converterapp.retrofit.RetrofitInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CurrencyRepository {

   private static CurrencyRepository instance;
   private RetrofitInterface retrofitInterface;

   public static CurrencyRepository getInstance() {
       if(instance == null) {
           instance = new CurrencyRepository();
       }
       return instance;
   }

   public CurrencyRepository () {
       retrofitInterface = RetrofitBuilder.getRetrofitInterface();
   }

   public LiveData<RatesResponse> getCurrencyRates(String base) {

       final MutableLiveData<RatesResponse> liveData = new MutableLiveData<>();


        retrofitInterface.getRates(base).enqueue(new Callback<RatesResponse>() {
            @Override
            public void onResponse(Call<RatesResponse> call, Response<RatesResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    liveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<RatesResponse> call, Throwable t) {
                Log.i("Retrofit", "onFailure: something went wrong");
                liveData.setValue(null);
            }
        });
        return liveData;
    }
}

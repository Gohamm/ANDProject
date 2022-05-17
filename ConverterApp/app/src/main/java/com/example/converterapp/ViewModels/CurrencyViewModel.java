package com.example.converterapp.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.converterapp.retrofit.RatesResponse;
import com.example.converterapp.Repository.CurrencyRepository;

public class CurrencyViewModel extends ViewModel {
   private CurrencyRepository repository;
   private LiveData<RatesResponse> mutableLiveData;

   public void init () {
       repository = CurrencyRepository.getInstance();
   }

   public LiveData<RatesResponse> getCurrencyRates (String base) {
       mutableLiveData = repository.getCurrencyRates(base);
       return mutableLiveData;
   }

   public void convert (String convertTo, String convertFrom, String amount ) {


   }


}

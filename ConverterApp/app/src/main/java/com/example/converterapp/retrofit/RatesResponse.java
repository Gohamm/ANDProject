package com.example.converterapp.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

public class RatesResponse {

    @SerializedName("base_code")
    @Expose
    private String baseCode;

    @SerializedName("conversion_rates")
    @Expose
    private HashMap<String, Double> conversionRates;


    public String getBaseCode() {
        return baseCode;
    }



    public HashMap<String, Double> getConversionRates() {
        return conversionRates;
    }





}

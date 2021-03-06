package com.example.aman.shoocaltaskboth.InterfacesAndAdapters;

import com.example.aman.shoocaltaskboth.model.MyResult;
import com.example.aman.shoocaltaskboth.model.RequestData;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {
    @POST("democalltesting")
    Call<MyResult> sendRequest(@Header("Authorization") String credentials, @Body RequestData requestData);
}

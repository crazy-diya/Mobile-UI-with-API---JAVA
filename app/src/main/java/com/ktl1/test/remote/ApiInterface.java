package com.ktl1.test.remote;

import com.ktl1.test.model.DataModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("/rewards")
    Call<List<DataModel>> getData();
}

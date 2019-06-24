package com.pejuangif.mppljobheist.apihelper;

import com.pejuangif.mppljobheist.model.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface BaseApiService {

    @FormUrlEncoded
    @POST("users/login")
    Call<User> loginRequest(@Field("email") String email, @Field("password") String password);
}

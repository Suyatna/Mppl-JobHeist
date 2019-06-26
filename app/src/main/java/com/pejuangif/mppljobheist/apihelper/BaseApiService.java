package com.pejuangif.mppljobheist.apihelper;

import com.pejuangif.mppljobheist.model.JobListData;
import com.pejuangif.mppljobheist.model.JobLists;
import com.pejuangif.mppljobheist.model.Users;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface BaseApiService {

    @FormUrlEncoded
    @POST("users/login")
    Call<Users> loginRequest(@Field("email") String email, @Field("password") String password);

    @GET("jobs/")
    Call<JobListData> jobListRequest();
}

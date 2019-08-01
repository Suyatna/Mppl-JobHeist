package com.pejuangif.mppljobheist.apihelper;

import com.pejuangif.mppljobheist.model.JobListData;
import com.pejuangif.mppljobheist.model.Users;
import com.pejuangif.mppljobheist.model.PencariKerja;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface BaseApiService {

    @FormUrlEncoded
    @POST("users/login")
    Call<Users> loginRequest(@Field("email") String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("users/registerPencariKerja")
    Call<Users> registerPencariKerja(@Field("name") String name, @Field("email") String email, @Field("password") String password, @Field("pendidikan_terakhir") String pendidikan_terakhir, @Field("alamat") String alamat);

    @GET("jobs/")
    Call<JobListData> jobListRequest();
}

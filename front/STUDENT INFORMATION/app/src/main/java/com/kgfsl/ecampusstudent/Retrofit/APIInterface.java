package com.kgfsl.ecampusstudent.Retrofit;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by gokul on 03-11-2017.
 */

public interface APIInterface {

    @GET("/ecampus/login.php")
    Call doGetListResources();



}

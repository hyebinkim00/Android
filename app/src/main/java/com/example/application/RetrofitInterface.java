package com.example.application;


import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {

   /* @GET("/api/v1/weathers")
    Call <airInfo1> aDayInfo(@Query("sidoName") String param1, @Query("cityName") String param2);
*/


    @GET("v3/cd0294f4-e801-4801-bbc3-8747651f1587")
    Call <Model> DayInfo();

}

package com.example.codeassignment.data;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {


    private static Retrofit retrofit;

    private static final String BASE_URL = "https://api.github.com";


    /**
     * Initialize Retrofit instance, singleton on instance.
     *
     * @return The instance
     */
    public static ApiService getRetrofitInstance () {

        if (retrofit == null) {

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }

        return retrofit.create(ApiService.class);
    }
}

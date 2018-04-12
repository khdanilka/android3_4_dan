package ru.geekbrains.android3_4.model.api;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiHolder
{
    String API_BASE = "https://api.github.com/";

    private static  ApiHolder instance = new ApiHolder();

    public static ApiHolder getInstance()
    {
        if(instance == null)
        {
            instance = new ApiHolder();
        }
        return instance;
    }

    ApiDataSource api;

    private ApiHolder()
    {
        this.api = new Retrofit.Builder()
                .baseUrl(API_BASE)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()))
                .build()
                .create(ApiDataSource.class);
    }

    public ApiDataSource getApi()
    {
        return api;
    }
}

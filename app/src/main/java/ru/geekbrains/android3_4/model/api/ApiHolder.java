package ru.geekbrains.android3_4.model.api;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by stanislav on 3/12/2018.
 */

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
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiDataSource.class);
    }

    public ApiDataSource getApi()
    {
        return api;
    }
}

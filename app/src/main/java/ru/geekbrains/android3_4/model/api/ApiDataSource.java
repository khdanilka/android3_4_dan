package ru.geekbrains.android3_4.model.api;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import ru.geekbrains.android3_4.model.entity.User;

public interface ApiDataSource
{
    @GET("users/{user}")
    Observable<User> getUser(@Path("user") String user);
}

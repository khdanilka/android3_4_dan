package ru.geekbrains.android3_4.model.api;




import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import ru.geekbrains.android3_4.model.DataSource;
import ru.geekbrains.android3_4.model.entity.User;

public interface ApiDataSource extends DataSource
{
    @Override
    @GET("users/{user}")
    Observable<User> getUser(@Path("user") String user);
}

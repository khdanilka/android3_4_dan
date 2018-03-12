package ru.geekbrains.android3_4.model;

import io.reactivex.Observable;
import ru.geekbrains.android3_4.model.entity.User;

/**
 * Created by stanislav on 3/12/2018.
 */

public interface DataSource
{
    Observable<User> getUser(String user);
}

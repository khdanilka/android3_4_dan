package ru.geekbrains.android3_4.model;


import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import ru.geekbrains.android3_4.model.entity.Repository;
import ru.geekbrains.android3_4.model.entity.User;

/**
 * Created by stanislav on 3/12/2018.
 */

public class UserRepo extends Repo
{
    public Observable<User> getUser(String user)
    {
        return getApi().getUser(user).subscribeOn(Schedulers.io());
    }

    public Observable<List<Repository>> getRepos(String user)
    {
        return getApi().getRepos(user).subscribeOn(Schedulers.io());
    }
}

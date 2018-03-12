package ru.geekbrains.android3_4.model;

import ru.geekbrains.android3_4.model.api.ApiDataSource;
import ru.geekbrains.android3_4.model.api.ApiHolder;

/**
 * Created by stanislav on 3/12/2018.
 */

public class Repo
{
    protected ApiDataSource getApi()
    {
       return ApiHolder.getInstance().getApi();
    }
}

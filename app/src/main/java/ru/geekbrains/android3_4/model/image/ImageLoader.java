package ru.geekbrains.android3_4.model.image;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by stanislav on 3/12/2018.
 */

public interface ImageLoader<T>
{
    void loadInto(@Nullable String url, @NonNull T container);
}

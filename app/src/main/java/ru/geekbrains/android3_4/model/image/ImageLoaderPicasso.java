package ru.geekbrains.android3_4.model.image;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by stanislav on 3/12/2018.
 */

public class ImageLoaderPicasso implements ImageLoader<ImageView>
{
    @Override
    public void loadInto(@Nullable String url, @NonNull ImageView container)
    {
        Picasso.get().load(url).into(container);
    }
}

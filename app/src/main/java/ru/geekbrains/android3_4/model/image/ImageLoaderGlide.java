package ru.geekbrains.android3_4.model.image;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by stanislav on 3/12/2018.
 */

public class ImageLoaderGlide implements ImageLoader<ImageView>
{
    @Override
    public void loadInto(@Nullable String url, @NonNull ImageView container)
    {
       Glide.with(container.getContext()).load(url).into(container);
    }
}

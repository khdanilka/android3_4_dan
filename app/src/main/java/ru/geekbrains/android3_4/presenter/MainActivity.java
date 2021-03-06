package ru.geekbrains.android3_4.presenter;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import ru.geekbrains.android3_4.R;
import ru.geekbrains.android3_4.model.image.ImageLoader;
import ru.geekbrains.android3_4.model.image.ImageLoaderGlide;

public class MainActivity extends MvpAppCompatActivity implements MainViewInterface
{
    private static final String TAG = "MainActivity";

    @BindView(R.id.iv_avatar) ImageView avatarImageView;
    @BindView(R.id.tv_username) TextView usernameTextView;
    @BindView(R.id.tv_error) TextView errorTextView;
    @BindView(R.id.pb_loading) ProgressBar loadingProgressBar;
    @BindView(R.id.rv) RecyclerView recyclerView;

    ImageLoader<ImageView> imageLoader;
    Adapter adapter;

    @InjectPresenter
    MainPresenter presenter;

    @ProvidePresenter
    public MainPresenter provideMainPresenter()
    {
        String string = "hello";
        return new MainPresenter(AndroidSchedulers.mainThread());
    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        imageLoader = new ImageLoaderGlide();
        //presenter.loadInfo();
    }

    private void getByOkhttp()
    {
        Single.fromCallable(() ->
        {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://api.github.com/users/skhizhnyak")
                    .build();
            try
            {
                return client.newCall(request).execute().body().string();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
            return null;
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s ->Log.d(TAG, s), t -> Log.e(TAG, "error", t));
    }

    @Override
    public void loadImage(String avatarUrl)
    {
        loadingProgressBar.setVisibility(View.GONE);
        imageLoader.loadInto(avatarUrl, avatarImageView);
    }

    @Override
    public void setLoginText(String login)
    {
        usernameTextView.setText(login);
    }

    @Override
    public void showError(String message)
    {
        loadingProgressBar.setVisibility(View.GONE);
        errorTextView.setText(message);
    }

    @Override
    public void init() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new Adapter(presenter.getListFiles());
        recyclerView.setAdapter(adapter);
        presenter.loadInfo();

    }

    @Override
    public void updateList() {
        adapter.notifyDataSetChanged();
    }
}

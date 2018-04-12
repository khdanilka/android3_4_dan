package ru.geekbrains.android3_4.presenter;

import android.util.Log;

import io.reactivex.Scheduler;
import io.reactivex.functions.Consumer;
import ru.geekbrains.android3_4.model.UserRepo;
import ru.geekbrains.android3_4.model.entity.User;
import ru.geekbrains.android3_4.view.MainView;


public class MainPresenter
{
    private static final String TAG = "MainPresenter";

    MainView view;
    private Scheduler scheduler;
    UserRepo userRepo;

    public MainPresenter(MainView view, Scheduler scheduler)
    {
        this.view = view;
        this.scheduler = scheduler;
        userRepo = new UserRepo();
    }

    public void loadInfo()
    {
        userRepo.getUser("khdanilka")
                .observeOn(scheduler)
        .subscribe(new Consumer<User>() {
            @Override
            public void accept(User user) throws Exception {
                view.loadImage(user.getAvatarUrl());
                view.setLoginText(user.getLogin());
                Log.d(TAG,user.getRepos_url());
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.e(TAG, "Failed to get user", throwable);
                view.showError(throwable.getMessage());
                Log.d(TAG,throwable.getMessage());
            }
        });
    }
}

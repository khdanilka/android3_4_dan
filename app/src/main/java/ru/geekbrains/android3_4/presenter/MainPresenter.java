package ru.geekbrains.android3_4.presenter;

import android.util.Log;

import io.reactivex.Scheduler;
import ru.geekbrains.android3_4.model.UserRepo;
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
        userRepo.getUser("skhizhnyak")
                .observeOn(scheduler)
        .subscribe(user -> {
            view.loadImage(user.getAvatarUrl());
            view.setLoginText(user.getLogin());
        }, throwable -> {
            Log.e(TAG, "Failed to get user", throwable);
            view.showError(throwable.getMessage());
        });
    }
}

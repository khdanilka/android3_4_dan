package ru.geekbrains.android3_4.presenter;

import android.util.Log;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.functions.Consumer;
import ru.geekbrains.android3_4.model.UserRepo;
import ru.geekbrains.android3_4.model.entity.Repository;
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
        String name = "khdanilka";
        userRepo.getUser(name)
                .observeOn(scheduler)
        .subscribe(new Consumer<User>() {
            @Override
            public void accept(User user) throws Exception {
                view.loadImage(user.getAvatarUrl());
                view.setLoginText(user.getLogin());
                //Log.d(TAG,user.getRepos_url());
                loadRepo(name);
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

    public void loadRepo(String name){

        userRepo.getRepos(name)
                .observeOn(scheduler)
                .subscribe(new Consumer<List<Repository>>() {
                    @Override
                    public void accept(List<Repository> user) throws Exception {
                        //view.loadImage(user.getAvatarUrl());
                        //view.setLoginText(user.getLogin());
                        //Log.d(TAG,user.getRepos_url());
                        for(Repository r: user){
                            Log.d(TAG,String.valueOf(r.getId()) + ": " + r.getFull_name());
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e(TAG, "Failed to get user", throwable);
                        //view.showError(throwable.getMessage());
                        //Log.d(TAG,throwable.getMessage());
                    }
                });


    }



}

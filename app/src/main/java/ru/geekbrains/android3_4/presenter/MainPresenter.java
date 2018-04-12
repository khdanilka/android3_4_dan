package ru.geekbrains.android3_4.presenter;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.functions.Consumer;
import ru.geekbrains.android3_4.model.UserRepo;
import ru.geekbrains.android3_4.model.entity.Repository;
import ru.geekbrains.android3_4.model.entity.User;


@InjectViewState
public class MainPresenter extends MvpPresenter<MainViewInterface>
{
    private static final String TAG = "MainPresenter";


    class ListPresenter implements IListPresenter
    {
        List<String> strings = new ArrayList<>();
        @Override
        public void bindView(IListRowView view)
        {
            view.setText(strings.get(view.getPos()));
        }

        @Override
        public int getViewCount()
        {
            return strings.size();
        }

//        @Override
//        public void accept(String s) throws Exception {
//            Log.d(TAG,s);
//            //showCustomDialog();
//            //convertImage(s);
//
//        }
    }

    ListPresenter listPrestenter = new ListPresenter();


    @Override
    protected void onFirstViewAttach()
    {
        super.onFirstViewAttach();
        getViewState().init();
        List<String>  bufList = new ArrayList<>();
        listPrestenter.strings.addAll(bufList);
        getViewState().updateList();
    }

    public ListPresenter getListFiles() {
        return listPrestenter;
    }


    private Scheduler scheduler;
    UserRepo userRepo;

    public MainPresenter(Scheduler scheduler)
    {
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
                getViewState().loadImage(user.getAvatarUrl());
                getViewState().setLoginText(user.getLogin());
                loadRepo(name);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.e(TAG, "Failed to get user", throwable);
                getViewState().showError(throwable.getMessage());
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
                        listPrestenter.strings.clear();
                        for(Repository r: user){
                            listPrestenter.strings.add(String.valueOf(r.getId()) + ": " + r.getFull_name());
                        }
                        getViewState().updateList();
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

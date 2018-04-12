package ru.geekbrains.android3_4.presenter;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;



@StateStrategyType(value = AddToEndSingleStrategy.class)
interface MainViewInterface extends MvpView {

    void init();
    void updateList();
    void loadImage(String avatarUrl);
    void setLoginText(String login);
    void showError(String message);

}

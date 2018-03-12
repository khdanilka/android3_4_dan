package ru.geekbrains.android3_4.view;

/**
 * Created by stanislav on 3/12/2018.
 */

public interface MainView
{
    void loadImage(String avatarUrl);
    void setLoginText(String login);
    void showError(String message);
}

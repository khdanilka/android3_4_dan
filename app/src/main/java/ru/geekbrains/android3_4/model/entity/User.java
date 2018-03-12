package ru.geekbrains.android3_4.model.entity;

/**
 * Created by stanislav on 3/12/2018.
 */

public class User
{
    private String avatarUrl;
    private String login;

    public String getAvatarUrl()
    {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl)
    {
        this.avatarUrl = avatarUrl;
    }

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }
}

package ru.geekbrains.android3_4.model.entity;

/**
 * Created by stanislav on 3/12/2018.
 */

public class User
{
    private String avatarUrl;
    private String login;
    private String repos_url;

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


    public String getRepos_url() {
        return repos_url;
    }

    public void setRepos_url(String repos_url) {
        this.repos_url = repos_url;
    }
}

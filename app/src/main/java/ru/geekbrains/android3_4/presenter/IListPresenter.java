package ru.geekbrains.android3_4.presenter;

import io.reactivex.functions.Consumer;

public interface IListPresenter
{
    int pos = -1;
    void bindView(IListRowView view);
    int getViewCount();

}


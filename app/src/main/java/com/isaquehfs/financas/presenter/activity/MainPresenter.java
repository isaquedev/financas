package com.isaquehfs.financas.presenter.activity;

import com.isaquehfs.financas.contract.views.BaseContract;
import com.isaquehfs.financas.contract.views.activity.MainContract;

import io.reactivex.disposables.CompositeDisposable;

public class MainPresenter implements MainContract.Presenter {

    private static MainContract.Presenter mPresenter = new MainPresenter();

    private MainContract.View mView;

    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    public static MainContract.Presenter getInstance() {
        return mPresenter;
    }

    private MainPresenter() {

    }

    @Override
    public void setView(MainContract.View view) {
        mView = view;
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {
        mCompositeDisposable.clear();
    }
}

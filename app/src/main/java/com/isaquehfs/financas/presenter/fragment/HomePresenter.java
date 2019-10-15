package com.isaquehfs.financas.presenter.fragment;

import com.isaquehfs.financas.contract.views.fragment.HomeContract;

import io.reactivex.disposables.CompositeDisposable;

public class HomePresenter implements HomeContract.Presenter {

    private static HomeContract.Presenter mPresenter = new HomePresenter();

    private HomeContract.View mView;

    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    private HomePresenter() {

    }

    public static HomeContract.Presenter getInstance() {
        return mPresenter;
    }

    @Override
    public void setView(HomeContract.View view) {
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

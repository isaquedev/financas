package com.isaquehfs.financas.presenter.fragment;

import com.isaquehfs.financas.contract.views.fragment.LoginContract;

import io.reactivex.disposables.CompositeDisposable;

public class LoginPresenter implements LoginContract.Presenter {

    private static LoginContract.Presenter mPresenter = new LoginPresenter();

    private LoginContract.View mView;

    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    private LoginPresenter() {

    }

    public static LoginContract.Presenter getInstance() {
        return mPresenter;
    }

    @Override
    public void setView(LoginContract.View view) {
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

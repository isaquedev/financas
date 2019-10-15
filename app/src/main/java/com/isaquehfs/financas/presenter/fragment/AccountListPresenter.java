package com.isaquehfs.financas.presenter.fragment;

import com.isaquehfs.financas.contract.views.fragment.AccountListContract;

import io.reactivex.disposables.CompositeDisposable;

public class AccountListPresenter implements AccountListContract.Presenter {

    private static AccountListContract.Presenter mPresenter = new AccountListPresenter();

    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    private AccountListContract.View mView;

    private AccountListPresenter() {

    }

    public static AccountListContract.Presenter getInstance() {
        return mPresenter;
    }

    @Override
    public void setView(AccountListContract.View view) {
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

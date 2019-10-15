package com.isaquehfs.financas.presenter.fragment;

import com.isaquehfs.financas.contract.views.fragment.PackageListContract;

import io.reactivex.disposables.CompositeDisposable;

public class PackageListPresenter implements PackageListContract.Presenter {

    private static PackageListContract.Presenter mPresenter = new PackageListPresenter();

    private PackageListContract.View mView;

    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    private PackageListPresenter() {

    }

    public static PackageListContract.Presenter getInstance() {
        return mPresenter;
    }

    @Override
    public void setView(PackageListContract.View view) {
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

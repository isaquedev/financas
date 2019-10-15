package com.isaquehfs.financas.presenter.fragment;

import com.isaquehfs.financas.contract.views.fragment.CategoryListContract;

import io.reactivex.disposables.CompositeDisposable;

public class CategoryListPresenter implements CategoryListContract.Presenter {

    private static CategoryListContract.Presenter mPresenter = new CategoryListPresenter();

    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    private CategoryListContract.View mView;

    private CategoryListPresenter() {

    }

    public static CategoryListContract.Presenter getInstance() {
        return mPresenter;
    }

    @Override
    public void setView(CategoryListContract.View view) {
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

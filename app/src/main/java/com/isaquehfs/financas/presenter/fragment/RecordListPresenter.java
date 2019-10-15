package com.isaquehfs.financas.presenter.fragment;

import com.isaquehfs.financas.contract.views.fragment.RecordListContract;

import io.reactivex.disposables.CompositeDisposable;

public class RecordListPresenter implements RecordListContract.Presenter {

    private static RecordListContract.Presenter mPresenter = new RecordListPresenter();

    private RecordListContract.View mView;

    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    private RecordListPresenter() {

    }

    public static RecordListContract.Presenter getInstance() {
        return mPresenter;
    }

    @Override
    public void setView(RecordListContract.View view) {
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

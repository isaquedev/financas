package com.isaquehfs.financas.presenter.activity;

import com.isaquehfs.financas.contract.views.activity.RecordFormContract;

import io.reactivex.disposables.CompositeDisposable;

public class RecordFormPresenter implements RecordFormContract.Presenter {

    private static RecordFormContract.Presenter mPresenter = new RecordFormPresenter();

    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    private RecordFormContract.View mView;

    private RecordFormPresenter() {

    }

    public static RecordFormContract.Presenter getInstance() {
        return mPresenter;
    }

    @Override
    public void setView(RecordFormContract.View view) {
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

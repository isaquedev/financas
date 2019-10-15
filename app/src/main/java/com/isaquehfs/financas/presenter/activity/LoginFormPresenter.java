package com.isaquehfs.financas.presenter.activity;

import com.isaquehfs.financas.contract.repository.UserRepository;
import com.isaquehfs.financas.contract.views.BaseContract;
import com.isaquehfs.financas.contract.views.activity.LoginFormContract;
import com.isaquehfs.financas.contract.views.fragment.LoginContract;
import com.isaquehfs.financas.model.repository.UserRepositoryImpl;

import io.reactivex.disposables.CompositeDisposable;

public class LoginFormPresenter implements LoginFormContract.Presenter {

    private static LoginFormContract.Presenter mPresenter = new LoginFormPresenter();

    private LoginFormContract.View mView;

    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    private UserRepository mUserRepository = UserRepositoryImpl.getInstance();

    public static LoginFormContract.Presenter getInstance() {
        return mPresenter;
    }

    private LoginFormPresenter() {

    }

    @Override
    public void setView(LoginFormContract.View view) {
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

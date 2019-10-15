package com.isaquehfs.financas.view.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.isaquehfs.financas.R;
import com.isaquehfs.financas.contract.views.fragment.LoginContract;
import com.isaquehfs.financas.presenter.fragment.LoginPresenter;

import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class LoginFragment extends Fragment implements LoginContract.View {

    private LoginContract.Presenter mPresenter = LoginPresenter.getInstance();

    public LoginFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);

        mPresenter.setView(this);
        mPresenter.subscribe();

    }

    @Override
    public void onDestroyView() {
        mPresenter.unsubscribe();
        mPresenter.setView(null);
        super.onDestroyView();
    }

}

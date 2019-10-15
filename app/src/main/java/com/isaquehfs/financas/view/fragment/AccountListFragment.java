package com.isaquehfs.financas.view.fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.isaquehfs.financas.R;
import com.isaquehfs.financas.contract.views.fragment.AccountListContract;
import com.isaquehfs.financas.presenter.fragment.AccountListPresenter;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class AccountListFragment extends Fragment implements AccountListContract.View {

    private AccountListContract.Presenter mPresenter = AccountListPresenter.getInstance();

    public AccountListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account_list, container, false);
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

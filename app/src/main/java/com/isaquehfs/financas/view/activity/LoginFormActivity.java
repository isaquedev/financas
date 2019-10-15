package com.isaquehfs.financas.view.activity;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.isaquehfs.financas.R;
import com.isaquehfs.financas.contract.views.activity.LoginFormContract;
import com.isaquehfs.financas.presenter.activity.LoginFormPresenter;

import butterknife.ButterKnife;

public class LoginFormActivity extends AppCompatActivity implements LoginFormContract.View {

    private LoginFormContract.Presenter mPresenter = LoginFormPresenter.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);

        ButterKnife.bind(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());

        mPresenter.setView(this);
        mPresenter.subscribe();
    }

    @Override
    protected void onDestroy() {
        mPresenter.unsubscribe();
        mPresenter.setView(null);
        super.onDestroy();
    }
}

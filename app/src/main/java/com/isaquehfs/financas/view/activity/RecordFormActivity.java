package com.isaquehfs.financas.view.activity;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import com.isaquehfs.financas.R;
import com.isaquehfs.financas.contract.views.activity.RecordFormContract;
import com.isaquehfs.financas.presenter.activity.RecordFormPresenter;

import butterknife.ButterKnife;

public class RecordFormActivity extends AppCompatActivity implements RecordFormContract.View {

    private RecordFormContract.Presenter mPresenter = RecordFormPresenter.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_form);

        ButterKnife.bind(this);

        mPresenter.setView(this);
        mPresenter.subscribe();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());
    }

    @Override
    protected void onDestroy() {
        mPresenter.unsubscribe();
        mPresenter.setView(null);
        super.onDestroy();
    }
}

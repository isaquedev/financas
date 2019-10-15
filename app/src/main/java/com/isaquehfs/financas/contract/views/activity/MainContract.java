package com.isaquehfs.financas.contract.views.activity;

import com.isaquehfs.financas.contract.views.BaseContract;

public interface MainContract {

    interface View extends BaseContract.View<Presenter> {

    }

    interface Presenter extends BaseContract.Presenter<View> {

    }

}

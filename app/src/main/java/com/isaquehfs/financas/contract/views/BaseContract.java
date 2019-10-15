package com.isaquehfs.financas.contract.views;

public interface BaseContract {

    interface View<Presenter> {

    }

    interface Presenter<View> {

        void setView(View view);

        void subscribe();

        void unsubscribe();

    }

}

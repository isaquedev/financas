package com.isaquehfs.financas.dialogs;

import android.app.AlertDialog;

import com.isaquehfs.financas.contract.views.BaseContract;
import com.isaquehfs.financas.contract.views.dialogs.BaseDialog;
import com.isaquehfs.financas.contract.views.dialogs.DialogActions;

public class AccountDialog implements BaseDialog {

    private static BaseDialog mDialog = new AccountDialog();

    private DialogActions mView;

    private AlertDialog dialog;

    private AccountDialog() {

    }

    public static BaseDialog getInstance() {
        return mDialog;
    }

    @Override
    public void setView(DialogActions view) {
        mView = view;
    }

    @Override
    public void create() {

    }

    @Override
    public void dismiss() {
        dialog.dismiss();
    }
}

package com.example.mykfcapp.ui.screens.act_entry;

import com.example.mykfcapp.ui.sub_views.la_base.BaseMVP;

public interface ActEntryMVP
{
    interface MVPView extends BaseMVP<Presenter>
    {
        void showError();
        void showErrorEmpty();
        void showErrorEmptyField();

    }

    interface Presenter
    {
        void onRegistrationClicked();
        void onBtnEnterClicked(String userEmail, String password);
    }
}

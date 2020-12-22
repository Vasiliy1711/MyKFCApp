package com.example.mykfcapp.ui.screens.act_entry;

import com.example.mykfcapp.ui.sub_views.la_base.BaseMVP;

public interface ActEntryMVP
{
    interface MVPView extends BaseMVP<Presenter>
    {
        String getEmail();
        String getPassword();
    }

    interface Presenter
    {
        void onRegistrationClicked();
        void onBtnEnterClicked();
    }
}

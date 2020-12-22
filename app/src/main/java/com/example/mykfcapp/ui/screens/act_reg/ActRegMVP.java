package com.example.mykfcapp.ui.screens.act_reg;

import com.example.mykfcapp.ui.sub_views.la_base.BaseMVP;

public interface ActRegMVP
{
    interface MVPView extends BaseMVP<Presenter>
    {
        String getUserName();
        String getUserSurname();
        String getUserEmail();
        String getUserPassword1();
        String getUserPassword2();
    }

    interface Presenter
    {
        void onBtnRegClicked();
    }
}

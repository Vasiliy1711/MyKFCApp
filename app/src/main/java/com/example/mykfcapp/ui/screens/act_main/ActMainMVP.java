package com.example.mykfcapp.ui.screens.act_main;

import android.view.View;

import com.example.mykfcapp.enums.TypeTab;
import com.example.mykfcapp.ui.sub_views.la_base.BaseMVP;

import java.util.ArrayList;


public interface ActMainMVP
{
    interface MVPView extends BaseMVP<Presenter>
    {
        void setTabs(ArrayList<View> views);
        void changeBottomNavColor(TypeTab typeTab);
        void setVPItem(int position);
    }

    interface Presenter
    {
        void scrolledToTab(TypeTab typeTab);
        void onTabClicked(TypeTab typeTab);
    }
}

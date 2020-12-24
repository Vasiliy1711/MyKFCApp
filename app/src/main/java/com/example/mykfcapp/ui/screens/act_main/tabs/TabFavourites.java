package com.example.mykfcapp.ui.screens.act_main.tabs;

import android.content.Intent;

import com.example.mykfcapp.ui.screens.act_reg.ActReg;
import com.example.mykfcapp.models.ModelDocument;
import com.example.mykfcapp.ui.screens.act_main.ActMain;
import com.example.mykfcapp.ui.sub_views.la_favourites.FavMVP;

public class TabFavourites extends TabBase implements FavMVP.Presenter
{
    private FavMVP.MVPView mvpView;

    public TabFavourites(ActMain actMain, FavMVP.MVPView mvpView)
    {
        super(actMain);
        this.mvpView = mvpView;
        mvpView.registerPresenter(this);
        mvpView.bindFavourites(ModelDocument.getData());
    }

    @Override
    public void onItemClicked()
    {

    }
}

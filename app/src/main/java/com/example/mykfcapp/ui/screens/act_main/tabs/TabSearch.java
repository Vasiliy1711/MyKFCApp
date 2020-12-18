package com.example.mykfcapp.ui.screens.act_main.tabs;

import com.example.mykfcapp.models.ModelDocument;
import com.example.mykfcapp.ui.screens.act_main.ActMain;
import com.example.mykfcapp.ui.sub_views.la_search.SeaMVP;

public class TabSearch extends TabBase implements SeaMVP.Presenter
{
    private SeaMVP.MVPView mvpView;

    public TabSearch(ActMain actMain, SeaMVP.MVPView mvpView)
    {
        super(actMain);
        this.mvpView = mvpView;
        mvpView.registerPresenter(this);
        mvpView.bindSearch(ModelDocument.getData());
    }
}

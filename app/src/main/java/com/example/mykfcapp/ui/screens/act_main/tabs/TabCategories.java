package com.example.mykfcapp.ui.screens.act_main.tabs;

import com.example.mykfcapp.models.ModelCategory;
import com.example.mykfcapp.ui.screens.act_main.ActMain;
import com.example.mykfcapp.ui.sub_views.la_categories.CatMVP;

public class TabCategories extends TabBase implements CatMVP.Presenter
{
    private CatMVP.MVPView mvpView;

    public TabCategories(ActMain actMain, CatMVP.MVPView mvpView)
    {
        super(actMain);
        this.mvpView = mvpView;
        mvpView.registerPresenter(this);
        mvpView.bindCategories(ModelCategory.getData());
    }

    @Override
    public void onItemClicked()
    {

    }
}
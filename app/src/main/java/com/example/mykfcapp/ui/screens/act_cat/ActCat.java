package com.example.mykfcapp.ui.screens.act_cat;

import android.os.Bundle;

import com.example.mykfcapp.R;
import com.example.mykfcapp.models.ModelDocument;
import com.example.mykfcapp.ui.screens.act_base.ActBase;

public class ActCat extends ActBase implements ActCatMVP.Presenter
{
    private ActCatMVP.MVPView mvpView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mvpView = new ActCatMVPView(getLayoutInflater());
        mvpView.registerPresenter(this);
        setContentView(mvpView.getRootView());
        mvpView.bindItems(ModelDocument.getData());
    }

    @Override
    public void onItemClicked()
    {

    }
}
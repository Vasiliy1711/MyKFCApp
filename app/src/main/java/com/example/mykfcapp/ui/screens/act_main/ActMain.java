package com.example.mykfcapp.ui.screens.act_main;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.example.mykfcapp.enums.TypeTab;
import com.example.mykfcapp.models.ModelUser;
import com.example.mykfcapp.ui.screens.act_base.ActBase;
import com.example.mykfcapp.ui.screens.act_main.tabs.TabCategories;
import com.example.mykfcapp.ui.screens.act_main.tabs.TabFavourites;
import com.example.mykfcapp.ui.screens.act_main.tabs.TabProfile;
import com.example.mykfcapp.ui.screens.act_main.tabs.TabSearch;
import com.example.mykfcapp.ui.sub_views.la_categories.CatMVP;
import com.example.mykfcapp.ui.sub_views.la_categories.CatMVPView;
import com.example.mykfcapp.ui.sub_views.la_favourites.FavMVP;
import com.example.mykfcapp.ui.sub_views.la_favourites.FavMVPView;
import com.example.mykfcapp.ui.sub_views.la_profile.ProMVP;
import com.example.mykfcapp.ui.sub_views.la_profile.ProMVPView;
import com.example.mykfcapp.ui.sub_views.la_search.SeaMVP;
import com.example.mykfcapp.ui.sub_views.la_search.SeaMVPView;
import java.util.ArrayList;

public class ActMain extends ActBase implements ActMainMVP.Presenter
{
    private ActMainMVP.MVPView mvpView;
    private CatMVP.MVPView mvpViewCat;
    private FavMVP.MVPView mvpViewFav;
    private SeaMVP.MVPView mvpViewSearch;
    private ProMVP.MVPView mvpViewProfile;
    private TabCategories tabCategories;
    private TabFavourites tabFavourites;
    private TabSearch tabSearch;
    private TabProfile tabProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mvpView = new ActMainMVPView(getLayoutInflater());
        mvpView.registerPresenter(this);
        setContentView(mvpView.getRootView());
        initTabs();

    }

    private void initTabs()
    {
        mvpViewCat = new CatMVPView(getLayoutInflater());
        tabCategories = new TabCategories(this, mvpViewCat);

        mvpViewFav = new FavMVPView(getLayoutInflater());
        tabFavourites = new TabFavourites(this, mvpViewFav);

        mvpViewSearch = new SeaMVPView(getLayoutInflater());
        tabSearch = new TabSearch(this,mvpViewSearch);

        mvpViewProfile = new ProMVPView(getLayoutInflater());
        tabProfile = new TabProfile(this, mvpViewProfile);

        ArrayList<View> views = new ArrayList<>();
        views.add(mvpViewCat.getRootView());
        views.add(mvpViewFav.getRootView());
        views.add(mvpViewSearch.getRootView());
        views.add(mvpViewProfile.getRootView());

        mvpView.setTabs(views);
    }

    @Override
    public void scrolledToTab(TypeTab typeTab)
    {
        Log.e("TypeTab",typeTab.name());
        mvpView.changeBottomNavColor(typeTab);
    }

    @Override
    public void onTabClicked(TypeTab typeTab)
    {
       mvpView.setVPItem(typeTab.getTabPos());
    }
}



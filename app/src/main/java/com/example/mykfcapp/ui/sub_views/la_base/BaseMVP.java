package com.example.mykfcapp.ui.sub_views.la_base;

import android.view.View;

public interface BaseMVP<PresenterType>
{
    View getRootView();
    void registerPresenter(PresenterType presenter);
}

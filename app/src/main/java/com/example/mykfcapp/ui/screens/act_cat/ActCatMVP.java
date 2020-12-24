package com.example.mykfcapp.ui.screens.act_cat;

import com.example.mykfcapp.models.ModelDocument;
import com.example.mykfcapp.ui.sub_views.la_base.BaseMVP;

import java.util.ArrayList;

public interface ActCatMVP
{
    interface MVPView extends BaseMVP<Presenter>
    {
        void bindItems(ArrayList<ModelDocument> items);
    }

    interface Presenter
    {
        void onItemClicked();
    }
}

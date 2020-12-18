package com.example.mykfcapp.ui.sub_views.la_favourites;

import com.example.mykfcapp.models.ModelDocument;
import com.example.mykfcapp.ui.sub_views.la_base.BaseMVP;
import java.util.ArrayList;

public interface FavMVP
{
    interface MVPView extends BaseMVP<Presenter>
    {
        void bindFavourites(ArrayList<ModelDocument> favourites);
    }

    interface Presenter
    {
        void onItemClicked();
    }
}

package com.example.mykfcapp.ui.sub_views.la_search;

import com.example.mykfcapp.models.ModelDocument;
import com.example.mykfcapp.ui.sub_views.la_base.BaseMVP;
import java.util.ArrayList;

public interface SeaMVP
{
    interface MVPView extends BaseMVP<Presenter>
    {
        void bindSearch(ArrayList<ModelDocument> documents);
    }

    interface Presenter
    {

    }
}

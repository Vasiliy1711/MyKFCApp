package com.example.mykfcapp.ui.sub_views.la_categories;

import com.example.mykfcapp.models.ModelCategory;
import com.example.mykfcapp.ui.sub_views.la_base.BaseMVP;
import java.util.ArrayList;

public interface CatMVP
{
    interface MVPView extends BaseMVP<Presenter>
    {
        void bindCategories(ArrayList<ModelCategory> categories);
    }

    interface Presenter
    {
        void onItemClicked(ModelCategory category);
    }
}

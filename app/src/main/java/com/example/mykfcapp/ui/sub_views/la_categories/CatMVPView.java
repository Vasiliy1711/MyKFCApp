package com.example.mykfcapp.ui.sub_views.la_categories;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mykfcapp.R;
import com.example.mykfcapp.adapters.AdapterMC;
import com.example.mykfcapp.databinding.ActMainBinding;
import com.example.mykfcapp.databinding.LaCategoriesBinding;
import com.example.mykfcapp.models.ModelCategory;
import com.example.mykfcapp.ui.screens.act_cat.ActCatMVPView;
import com.example.mykfcapp.ui.sub_views.la_base.BaseMVPView;
import java.util.ArrayList;

public class CatMVPView extends BaseMVPView implements CatMVP.MVPView
{
    private CatMVP.Presenter presenter;
    private LaCategoriesBinding binding;
    private AdapterMC adapterMC;
    private int position;


    public CatMVPView(LayoutInflater inflater)
    {
        super(inflater);
        binding = DataBindingUtil.inflate(inflater, R.layout.la_categories, null,false);
        rootView = binding.getRoot();
        initRecCat();
    }

    private void initRecCat()
    {
        binding.recCategories.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        adapterMC = new AdapterMC();
        binding.recCategories.setAdapter(adapterMC);
        adapterMC.setOnModelCategoryClickListener(new AdapterMC.OnModelCategoryClickListener()
        {
            @Override
            public void onModelCategoryClicked(ModelCategory category)
            {
                presenter.onItemClicked(category);
            }
        });
    }

    @Override
    public View getRootView()
    {
        return rootView;
    }

    @Override
    public void registerPresenter(CatMVP.Presenter presenter)
    {
        this.presenter = presenter;
    }


    @Override
    public void bindCategories(ArrayList<ModelCategory> categories)
    {
        adapterMC.setCategories(categories);
    }
}

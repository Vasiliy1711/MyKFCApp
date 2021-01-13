package com.example.mykfcapp.ui.screens.act_cat;

import android.view.LayoutInflater;
import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.mykfcapp.R;
import com.example.mykfcapp.adapters.AdapterMD;
import com.example.mykfcapp.databinding.ActCatBinding;
import com.example.mykfcapp.models.ModelDocument;
import com.example.mykfcapp.ui.sub_views.la_base.BaseMVPView;

import java.util.ArrayList;

public class ActCatMVPView extends BaseMVPView implements ActCatMVP.MVPView
{
    private ActCatMVP.Presenter presenter;
    private ActCatBinding binding;
    private AdapterMD adapterMD;

    public ActCatMVPView(LayoutInflater inflater)
    {
        super(inflater);
        binding = DataBindingUtil.inflate(inflater, R.layout.act_cat, null, false);
        rootView = binding.getRoot();
        initViews();
    }

    private void initViews()
    {
        binding.recSearchActCat.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        adapterMD = new AdapterMD();
        binding.recSearchActCat.setAdapter(adapterMD);
        adapterMD.setOnModelDocumentClickListener(new AdapterMD.OnModelDocumentClickListener()
        {
            @Override
            public void onModelDocumentClicked(ModelDocument document)
            {
                presenter.onItemClicked();
            }
        });
    }

    @Override
    public View getRootView()
    {
        return rootView;
    }

    @Override
    public void registerPresenter(ActCatMVP.Presenter presenter)
    {
        this.presenter = presenter;
    }

    @Override
    public void bindItems(ArrayList<ModelDocument> items)
    {
        adapterMD.setDocuments(items);
    }

    @Override
    public void setCatName(int catName)
    {
        binding.catName.setText(catName);
    }
}

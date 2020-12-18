package com.example.mykfcapp.ui.sub_views.la_search;

import android.view.LayoutInflater;
import android.view.View;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.mykfcapp.R;
import com.example.mykfcapp.adapters.AdapterMD;
import com.example.mykfcapp.databinding.LaSearchBinding;
import com.example.mykfcapp.models.ModelDocument;
import com.example.mykfcapp.ui.sub_views.la_base.BaseMVPView;
import java.util.ArrayList;

public class SeaMVPView extends BaseMVPView implements SeaMVP.MVPView
{
    private SeaMVP.Presenter presenter;
    private LaSearchBinding binding;
    private AdapterMD adapterMD;

    public SeaMVPView(LayoutInflater inflater)
    {
        super(inflater);
        binding = DataBindingUtil.inflate(inflater, R.layout.la_search, null, false);
        rootView = binding.getRoot();
        initRecSearch();
    }

    private void initRecSearch()
    {
        binding. recSearch.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        adapterMD = new AdapterMD();
        binding.recSearch.setAdapter(adapterMD);
        adapterMD.setOnModelDocumentClickListener(new AdapterMD.OnModelDocumentClickListener()
        {
            @Override
            public void onModelDocumentClicked(ModelDocument document)
            {

            }
        });
    }

    @Override
    public View getRootView()
    {
        return rootView;
    }

    @Override
    public void registerPresenter(SeaMVP.Presenter presenter)
    {
        this.presenter = presenter;
    }

    @Override
    public void bindSearch(ArrayList<ModelDocument> documents)
    {
        adapterMD.setDocuments(documents);
    }
}

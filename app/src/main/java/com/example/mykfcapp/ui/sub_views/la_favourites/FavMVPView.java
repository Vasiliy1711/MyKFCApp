package com.example.mykfcapp.ui.sub_views.la_favourites;

import android.view.LayoutInflater;
import android.view.View;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mykfcapp.R;
import com.example.mykfcapp.adapters.AdapterMD;
import com.example.mykfcapp.databinding.ActMainBinding;
import com.example.mykfcapp.databinding.LaFavouritesBinding;
import com.example.mykfcapp.models.ModelDocument;
import com.example.mykfcapp.ui.sub_views.la_base.BaseMVPView;
import java.util.ArrayList;

public class FavMVPView extends BaseMVPView implements FavMVP.MVPView
{
    private FavMVP.Presenter presenter;
    private LaFavouritesBinding binding;
    private AdapterMD adapterMD;

    public FavMVPView(LayoutInflater inflater)
    {
        super(inflater);
        binding = DataBindingUtil.inflate(inflater, R.layout.la_favourites, null, false);
        rootView = binding.getRoot();
        initRecFav();
    }

    private void initRecFav()
    {
        binding.recFavourites.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        adapterMD = new AdapterMD();
        binding.recFavourites.setAdapter(adapterMD);
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
    public void registerPresenter(FavMVP.Presenter presenter)
    {
        this.presenter = presenter;
    }

    @Override
    public void bindFavourites(ArrayList<ModelDocument> favourites)
    {
        adapterMD.setDocuments(favourites);
    }
}

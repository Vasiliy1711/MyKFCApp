package com.example.mykfcapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.mykfcapp.adapters.AdapterMC;
import com.example.mykfcapp.adapters.AdapterMD;
import com.example.mykfcapp.adapters.AdapterVP;
import com.example.mykfcapp.databinding.ActMainBinding;
import com.example.mykfcapp.databinding.LaCategoriesBinding;
import com.example.mykfcapp.databinding.LaFavouritesBinding;
import com.example.mykfcapp.databinding.LaProfileBinding;
import com.example.mykfcapp.databinding.LaSearchBinding;
import com.example.mykfcapp.models.ModelCategory;
import com.example.mykfcapp.models.ModelDocument;

import java.util.ArrayList;

public class ActMain extends AppCompatActivity
{
    private RecyclerView recCategories;
    private RecyclerView recDocuments;
    private AdapterVP adapterVP;
    private AdapterMC adapterMC;
    private AdapterMD adapterMD;
    private ActMainBinding bnd_act_main;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        bnd_act_main = DataBindingUtil.setContentView(this, R.layout.act_main);
        initVPNew();
    }

    private void initVP()
    {
        adapterVP = new AdapterVP();
        bnd_act_main.vp.setAdapter(adapterVP);

        View la_categories = getLayoutInflater().inflate(R.layout.la_categories, null, false);
        View la_favourites = getLayoutInflater().inflate(R.layout.la_favourites, null, false);
        View la_search = getLayoutInflater().inflate(R.layout.la_search, null, false);
        View la_profile = getLayoutInflater().inflate(R.layout.la_profile, null, false);

        ArrayList<View> views = new ArrayList<>();
        views.add(la_categories);
        views.add(la_favourites);
        views.add(la_search);
        views.add(la_profile);

        adapterVP.setItems(views);
    }

    private void initVPNew()
    {
        adapterVP = new AdapterVP();
        bnd_act_main.vp.setAdapter(adapterVP);

        LaCategoriesBinding bnd_la_categories = DataBindingUtil.inflate(getLayoutInflater(),
                R.layout.la_categories, null, false);

        LaFavouritesBinding bnd_la_favourites = DataBindingUtil.inflate(getLayoutInflater(),
                R.layout.la_favourites, null, false);
        LaSearchBinding bnd_la_search = DataBindingUtil.inflate(getLayoutInflater(),
                R.layout.la_search, null, false);
        LaProfileBinding bnd_la_profile = DataBindingUtil.inflate(getLayoutInflater(),
                R.layout.la_profile, null, false);


        ArrayList<View> views = new ArrayList<>();
        views.add(bnd_la_categories.getRoot());
        views.add(bnd_la_favourites.getRoot());
        views.add(bnd_la_search.getRoot());
        views.add(bnd_la_profile.getRoot());

        adapterVP.setItems(views);

        recCategories = bnd_la_categories.getRoot().findViewById(R.id.recCategories);
        recCategories.setLayoutManager(new LinearLayoutManager(ActMain.this));
        adapterMC = new AdapterMC();
        adapterMC.setCategories(ModelCategory.getData());
        recCategories.setAdapter(adapterMC);

        recDocuments = bnd_la_favourites.getRoot().findViewById(R.id.recFavourites);
        recDocuments.setLayoutManager(new LinearLayoutManager(ActMain.this));
        adapterMD = new AdapterMD();
        adapterMD.setDocuments(ModelDocument.getData());
        recDocuments.setAdapter(adapterMD);
    }
}
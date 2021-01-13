package com.example.mykfcapp.ui.screens.act_cat;

import android.content.Intent;
import android.os.Bundle;

import com.example.mykfcapp.R;
import com.example.mykfcapp.models.ModelCategory;
import com.example.mykfcapp.models.ModelDocument;
import com.example.mykfcapp.ui.dialogs.DialogTest;
import com.example.mykfcapp.ui.screens.act_base.ActBase;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class ActCat extends ActBase implements ActCatMVP.Presenter
{
    private ActCatMVP.MVPView mvpView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mvpView = new ActCatMVPView(getLayoutInflater());
        mvpView.registerPresenter(this);
        setContentView(mvpView.getRootView());
        Intent intent = getIntent();
        if (intent.hasExtra("category"))
        {
            ModelCategory category = (ModelCategory) intent.getSerializableExtra("category");
            mvpView.setCatName(category.getCatName());
        }

        mvpView.bindItems(ModelDocument.getData());
    }

    @Override
    public void onItemClicked()
    {
        BottomSheetDialogFragment dialog = new DialogTest();
        dialog.show(getSupportFragmentManager(), null);
    }
}
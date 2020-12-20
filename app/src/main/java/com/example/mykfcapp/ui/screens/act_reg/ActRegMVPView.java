package com.example.mykfcapp.ui.screens.act_reg;

import android.view.LayoutInflater;
import android.view.View;

import androidx.databinding.DataBindingUtil;

import com.example.mykfcapp.R;
import com.example.mykfcapp.databinding.ActivityRegistrationBinding;
import com.example.mykfcapp.ui.sub_views.la_base.BaseMVPView;

public class ActRegMVPView extends BaseMVPView implements ActRegMVP.MVPView
{
    private ActRegMVP.Presenter presenter;
    private ActivityRegistrationBinding binding;

    public ActRegMVPView(LayoutInflater inflater)
    {
        super(inflater);
        binding = DataBindingUtil.inflate(inflater, R.layout.activity_registration, null,false);
        rootView = binding.getRoot();
    }

    @Override
    public View getRootView()
    {
        return rootView;
    }

    @Override
    public void registerPresenter(ActRegMVP.Presenter presenter)
    {
        this.presenter = presenter;
    }
}

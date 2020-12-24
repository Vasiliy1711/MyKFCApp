package com.example.mykfcapp.ui.screens.act_entry;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;

import com.example.mykfcapp.R;
import com.example.mykfcapp.databinding.ActivityEntryBinding;
import com.example.mykfcapp.ui.sub_views.la_base.BaseMVPView;

public class ActEntryMVPView extends BaseMVPView implements ActEntryMVP.MVPView
{
    private ActEntryMVP.Presenter presenter;
    private ActivityEntryBinding binding;

    public ActEntryMVPView(LayoutInflater inflater)
    {
        super(inflater);
        binding = DataBindingUtil.inflate(inflater, R.layout.activity_entry, null, false);
        rootView = binding.getRoot();
        initViews();
    }

    private void initViews()
    {
        binding.registration.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                presenter.onRegistrationClicked();
            }
        });

        binding.buttonEnter.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                presenter.onBtnEnterClicked();
            }
        });
    }


    @Override
    public View getRootView()
    {
        return rootView;
    }

    @Override
    public void registerPresenter(ActEntryMVP.Presenter presenter)
    {
        this.presenter = presenter;
    }


    @Override
    public String getEmail()
    {
        String email = binding.ediTextEmail.getText().toString().trim();
        return email;
    }

    @Override
    public String getPassword()
    {
        String password = binding.ediTextPassword.getText().toString().trim();
        return password;
    }
}

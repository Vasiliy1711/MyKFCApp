package com.example.mykfcapp.ui.screens.act_reg;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

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
        initViews();
    }

    private void initViews()
    {

        binding.buttonRegistration.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                presenter.onBtnRegClicked();
            }
        });

        binding.txtViewPrivacyPolicy.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                presenter.onPrivacyClicked();
            }
        });
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

    @Override
    public String getUserName()
    {
        String name = binding.ediTextName.getText().toString().trim();
        return name;
    }

    @Override
    public String getUserSurname()
    {
        String surname = binding.ediTextSurname.getText().toString().trim();
        return surname;
    }

    @Override
    public String getUserEmail()
    {
        String email = binding.editTxtEmail.getText().toString().trim();
        return email;
    }

    @Override
    public String getUserPassword1()
    {
        String password1 = binding.editTxtPassword.getText().toString().trim();
        return password1;
    }

    @Override
    public String getUserPassword2()
    {
        String password2 = binding.editTxtRepeatPassword.getText().toString().trim();
        return password2;
    }
}

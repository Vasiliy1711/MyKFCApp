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
    private String userEmail;
    private String userPassword;

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
                userEmail = binding.ediTextEmail.getText().toString().trim();
                userPassword = binding.ediTextPassword.getText().toString().trim();
                presenter.onBtnEnterClicked(userEmail, userPassword);
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
    public void showError()
    {
        Toast.makeText(rootView.getContext(), "Неверный email или пароль", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorEmpty()
    {
        Toast.makeText(rootView.getContext(), "Введите email и пароль", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorEmptyField()
    {
        Toast.makeText(rootView.getContext(), "Все поля должны быть заполнены", Toast.LENGTH_SHORT).show();
    }
}

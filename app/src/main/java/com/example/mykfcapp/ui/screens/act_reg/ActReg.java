package com.example.mykfcapp.ui.screens.act_reg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mykfcapp.R;
import com.example.mykfcapp.databinding.ActivityRegistrationBinding;

public class ActReg extends AppCompatActivity implements ActRegMVP.Presenter
{
    private ActRegMVP.MVPView mvpView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mvpView = new ActRegMVPView(getLayoutInflater());
        mvpView.registerPresenter(this);
        setContentView(R.layout.activity_registration);
    }
}
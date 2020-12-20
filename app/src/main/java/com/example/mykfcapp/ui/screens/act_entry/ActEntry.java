package com.example.mykfcapp.ui.screens.act_entry;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mykfcapp.data.UsersDatabase;
import com.example.mykfcapp.models.ModelUser;
import com.example.mykfcapp.ui.screens.act_main.ActMain;
import com.example.mykfcapp.ui.screens.act_reg.ActReg;

public class ActEntry extends AppCompatActivity implements ActEntryMVP.Presenter
{
    private ActEntryMVP.MVPView mvpView;
    private UsersDatabase database;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mvpView = new ActEntryMVPView(getLayoutInflater());
        mvpView.registerPresenter(this);
        setContentView(mvpView.getRootView());
        database = UsersDatabase.getInstance(this);
    }

    @Override
    public void onRegistrationClicked()
    {
        Intent intent = new Intent(this, ActReg.class);
        startActivity(intent);
    }

    @Override
    public void onBtnEnterClicked(String email, String password)
    {
        if (email.isEmpty() && password.isEmpty())
        {
            mvpView.showErrorEmpty();
        }
        else if (email.isEmpty() || password.isEmpty())
        {
            mvpView.showErrorEmptyField();
        }
        else
        {
            ModelUser foundUserByEmail = database.userDao().getUserByEmail(email);
            ModelUser foundUserByPassword = database.userDao().getUserByPassWord(password);
            if (foundUserByEmail != null && foundUserByPassword != null)
            {
                Intent intent = new Intent(ActEntry.this, ActMain.class);
                startActivity(intent);
            }
            mvpView.showError();
        }
    }
}

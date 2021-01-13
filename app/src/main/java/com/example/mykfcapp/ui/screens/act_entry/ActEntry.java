package com.example.mykfcapp.ui.screens.act_entry;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mykfcapp.data.UsersDatabase;
import com.example.mykfcapp.models.ModelUser;
import com.example.mykfcapp.ui.screens.ActTest;
import com.example.mykfcapp.ui.screens.act_base.ActBase;
import com.example.mykfcapp.ui.screens.act_main.ActMain;
import com.example.mykfcapp.ui.screens.act_reg.ActReg;
import com.example.mykfcapp.utils.ValidationData;
import com.example.mykfcapp.utils.ValidationManager;
import com.google.gson.Gson;

public class ActEntry extends ActBase implements ActEntryMVP.Presenter
{
    private ActEntryMVP.MVPView mvpView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        if (preferences.contains("user"))
        {
            Intent intent = new Intent(ActEntry.this, ActMain.class);
            String user = preferences.getString("user", strFUs);
            ModelUser permanentUser = gson.fromJson(user, ModelUser.class);
            intent.putExtra("user", permanentUser);
            startActivity(intent);
            finish();
            return;
        }
        mvpView = new ActEntryMVPView(getLayoutInflater());
        mvpView.registerPresenter(this);
        setContentView(mvpView.getRootView());
//        Intent intent = new Intent(this, ActTest.class);
//        startActivity(intent);

    }

    @Override
    public void onRegistrationClicked()
    {
        Intent intent = new Intent(ActEntry.this, ActReg.class);
        startActivity(intent);
    }

    @Override
    public void onBtnEnterClicked()
    {
        String email = mvpView.getEmail();
        String password = mvpView.getPassword();
        ModelUser foundUser = database.userDao().getUserByEmail(email, password);
        ValidationData data = ValidationManager.validateRegister(email, password, foundUser);
        if (!data.is_valid)
        {
            String message = data.getErrorMessage();
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            return;
        }


        strFUs = gson.toJson(foundUser);
        Log.e("USER", strFUs);
        preferences.edit().putString("user", strFUs).apply();

        Intent intent = new Intent(ActEntry.this, ActMain.class);
        intent.putExtra("user", foundUser);
        startActivity(intent);
    }
}

package com.example.mykfcapp.ui.screens.act_base;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mykfcapp.data.UsersDatabase;
import com.google.gson.Gson;

public class ActBase extends AppCompatActivity
{
    protected UsersDatabase database;
    protected SharedPreferences preferences;
    protected String strFUs;
    protected Gson gson;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        database = UsersDatabase.getInstance(this);
        preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        gson = new Gson();
    }
}

package com.example.mykfcapp.ui.screens.act_base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mykfcapp.data.UsersDatabase;

public class ActBase extends AppCompatActivity
{
    protected UsersDatabase database;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        database = UsersDatabase.getInstance(this);
    }
}

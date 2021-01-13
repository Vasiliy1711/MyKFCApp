package com.example.mykfcapp.ui.screens;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mykfcapp.R;

public class ActTest extends AppCompatActivity
{
    private TextView btnUnder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_test);
        initViews();
    }

    private void initViews()
    {
        btnUnder = findViewById(R.id.btnUnderstandably);
        btnUnder.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });
    }
}


//android:theme="@style/Theme.Transparent"
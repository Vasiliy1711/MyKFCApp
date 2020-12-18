package com.example.mykfcapp.ui.sub_views.la_base;

import android.view.LayoutInflater;
import android.view.View;

import com.example.mykfcapp.adapters.AdapterMC;
import com.example.mykfcapp.adapters.AdapterMD;
import com.example.mykfcapp.adapters.AdapterVP;

public class BaseMVPView
{
     protected View rootView;
     protected LayoutInflater inflater;

     public BaseMVPView(LayoutInflater inflater)
     {
          this.inflater = inflater;
     }

}

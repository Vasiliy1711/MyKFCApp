package com.example.mykfcapp.ui.screens.act_main.tabs;

import android.content.Intent;
import android.widget.Toast;
import com.example.mykfcapp.models.ModelUser;
import com.example.mykfcapp.ui.screens.act_entry.ActEntry;
import com.example.mykfcapp.ui.screens.act_main.ActMain;
import com.example.mykfcapp.ui.sub_views.la_profile.ProMVP;

public class TabProfile extends TabBase implements ProMVP.Presenter
{
    private ProMVP.MVPView mvpView;

    public TabProfile(ActMain actMain, ProMVP.MVPView mvpView)
    {
        super(actMain);
        this.mvpView = mvpView;
        mvpView.registerPresenter(this);
        Intent intent = actMain.getIntent();
        if (intent.hasExtra("user"))
        {
            ModelUser user = (ModelUser) intent.getSerializableExtra("user");
            mvpView.bindUser(user);
        }
    }

    @Override
    public void onExitButtonClicked()
    {
        Intent intent = new Intent(actMain, ActEntry.class);
        actMain.startActivity(intent);
    }

    @Override
    public void onPrivacyPolicyClicked()
    {
        Toast.makeText(actMain.getApplicationContext(), "Политика конфиденциальности", Toast.LENGTH_SHORT).show();
    }
}

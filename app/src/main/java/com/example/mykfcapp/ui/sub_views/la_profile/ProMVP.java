package com.example.mykfcapp.ui.sub_views.la_profile;

import com.example.mykfcapp.models.ModelUser;
import com.example.mykfcapp.ui.sub_views.la_base.BaseMVP;

public interface ProMVP
{
    interface MVPView extends BaseMVP<Presenter>
    {
        void bindUser(ModelUser user);
    }

    interface Presenter
    {
        void onExitButtonClicked();
        void onPrivacyPolicyClicked();
    }
}

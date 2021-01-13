package com.example.mykfcapp.ui.screens.act_reg;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.mykfcapp.R;
import com.example.mykfcapp.models.ModelUser;
import com.example.mykfcapp.ui.dialogs.DialogTest;
import com.example.mykfcapp.ui.screens.ActTest;
import com.example.mykfcapp.ui.screens.act_base.ActBase;
import com.example.mykfcapp.ui.screens.act_entry.ActEntry;
import com.example.mykfcapp.utils.ValidationData;
import com.example.mykfcapp.utils.ValidationManager;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class ActReg extends ActBase implements ActRegMVP.Presenter
{
    private ActRegMVP.MVPView mvpView;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mvpView = new ActRegMVPView(getLayoutInflater());
        mvpView.registerPresenter(this);
        setContentView(mvpView.getRootView());
    }

    @Override
    public void onBtnRegClicked()
    {
        String name = mvpView.getUserName();
        String surname = mvpView.getUserSurname();
        String email = mvpView.getUserEmail();
        String pass1 = mvpView.getUserPassword1();
        String pass2 = mvpView.getUserPassword2();
        ValidationData data = ValidationManager.validateRegister(name, surname, email, pass1, pass2);
        if (!data.is_valid)
        {
            String message = data.getErrorMessage();
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            return;
        }
        String userName = String.format("%s" + " " + "%s", surname, name);
        ModelUser newUser = new ModelUser(userName, email, pass1);
        Log.e("userName", userName);
        Log.e("userName", email);
        Log.e("userName", pass1);
        database.userDao().insertUser(newUser);
        Intent intent = new Intent(ActReg.this, ActEntry.class);
        startActivity(intent);
    }

    @Override
    public void onPrivacyClicked()
    {

        Intent intent = new Intent(this, ActTest.class);
        startActivity(intent);
//        BottomSheetDialogFragment dialog = new DialogTest();
//        dialog.show(getSupportFragmentManager(), null);

//        Dialog dialog = new Dialog(ActReg.this);
//        dialog.setContentView(R.layout.la_dialog);
//        dialog.show();
    }

}
package com.example.mykfcapp.ui.dialogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;

import com.example.mykfcapp.R;
import com.example.mykfcapp.databinding.LaDialogTestBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class DialogTest extends BottomSheetDialogFragment
{
    private LaDialogTestBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        binding = DataBindingUtil.inflate(inflater, R.layout.la_dialog_test, container, false);
        return binding.getRoot();
    }
}

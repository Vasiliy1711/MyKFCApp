package com.example.mykfcapp.ui.sub_views.la_profile;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.DataBindingUtil;

import com.example.mykfcapp.R;
import com.example.mykfcapp.databinding.LaProfileBinding;
import com.example.mykfcapp.models.ModelUser;
import com.example.mykfcapp.ui.sub_views.la_base.BaseMVPView;

public class ProMVPView extends BaseMVPView implements ProMVP.MVPView
{
    private ProMVP.Presenter presenter;
    private LaProfileBinding binding;

    public ProMVPView(LayoutInflater inflater)
    {
        super(inflater);
        binding = DataBindingUtil.inflate(inflater, R.layout.la_profile, null, false);
        rootView = binding.getRoot();
        initUser();
    }

    private void initUser()
    {
        binding.exitProfile.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                presenter.onExitButtonClicked();
            }
        });
        binding.txtPrivacyPolicy.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                presenter.onPrivacyPolicyClicked();
            }
        });
    }

    @Override
    public void bindUser(ModelUser user)
    {
        binding.imgProfile.setImageResource(user.getUserImg());;
        binding.userName.setText(user.getUserName());
        binding.userEmail.setText(user.getUserEmail());
        binding.imgProfile.setImageBitmap(getRoundedShape(((BitmapDrawable)binding.imgProfile.getDrawable()).getBitmap()));
    }

    public Bitmap getRoundedShape(Bitmap scaleBitmapImage) {
        int targetWidth = 50;
        int targetHeight = 50;
        Bitmap targetBitmap = Bitmap.createBitmap(targetWidth,
                targetHeight,Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(targetBitmap);
        Path path = new Path();
        path.addCircle(((float) targetWidth - 1) / 2,
                ((float) targetHeight - 1) / 2,
                (Math.min(((float) targetWidth),
                        ((float) targetHeight)) / 2),
                Path.Direction.CCW);

        canvas.clipPath(path);
        Bitmap sourceBitmap = scaleBitmapImage;
        canvas.drawBitmap(sourceBitmap,
                new Rect(0, 0, sourceBitmap.getWidth(),
                        sourceBitmap.getHeight()),
                new Rect(0, 0, targetWidth, targetHeight), null);
        return targetBitmap;
    }

    @Override
    public View getRootView()
    {
        return rootView;
    }

    @Override
    public void registerPresenter(ProMVP.Presenter presenter)
    {
        this.presenter = presenter;
    }
}

package com.example.mykfcapp.ui.screens.act_main;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;
import com.example.mykfcapp.R;
import com.example.mykfcapp.adapters.AdapterVP;
import com.example.mykfcapp.databinding.ActMainBinding;
import com.example.mykfcapp.enums.TypeTab;
import com.example.mykfcapp.ui.sub_views.la_base.BaseMVPView;
import java.util.ArrayList;

public class ActMainMVPView extends BaseMVPView implements ActMainMVP.MVPView
{
    private ActMainMVP.Presenter presenter;
    private ActMainBinding bnd_act_main;
    private AdapterVP adapterVP;

    public ActMainMVPView(LayoutInflater inflater)
    {
        super(inflater);
        bnd_act_main = DataBindingUtil.inflate(inflater, R.layout.act_main, null, false);
        rootView = bnd_act_main.getRoot();
        initViewPager();
        setBottomNavListeners();
    }

    private void initViewPager()
    {
        adapterVP = new AdapterVP();
        bnd_act_main.vp.setAdapter(adapterVP);
        bnd_act_main.vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels){}

            @Override
            public void onPageSelected(int position)
            {
                TypeTab typeTab = TypeTab.initFromPos(position);
                presenter.scrolledToTab(typeTab);
            }

            @Override
            public void onPageScrollStateChanged(int state){}
        });
    }


    @Override
    public View getRootView()
    {
        return rootView;
    }

    @Override
    public void registerPresenter(ActMainMVP.Presenter presenter)
    {
        this.presenter = presenter;
    }

    @Override
    public void setTabs(ArrayList<View> views)
    {
        adapterVP.setItems(views);
    }

    @Override
    public void changeBottomNavColor(final TypeTab typeTab)
    {
        int colorRed = rootView.getResources().getColor(R.color.color_red);
        int colorGray = rootView.getResources().getColor(R.color.gray4);
        LinearLayout laBottomNav = (LinearLayout)bnd_act_main.laBottomNav.getRoot();
        for (int i = 0; i < laBottomNav.getChildCount(); i++)
        {
            LinearLayout laBtn = (LinearLayout) laBottomNav.getChildAt(i);
            TextView tvIcon = (TextView) laBtn.getChildAt(0);
            TextView tvName = (TextView) laBtn.getChildAt(1);
            if (i == typeTab.getTabPos())
            {
                tvIcon.setTextColor(colorRed);
                tvName.setTextColor(colorRed);
            }else
            {
                tvIcon.setTextColor(colorGray);
                tvName.setTextColor(colorGray);
            }
        }
    }

    @Override
    public void setVPItem(int position)
    {
        bnd_act_main.vp.setCurrentItem(position);
    }

    private void setBottomNavListeners()
    {
        LinearLayout laBottomNav = (LinearLayout) bnd_act_main.laBottomNav.getRoot();
        for (int i = 0; i < laBottomNav.getChildCount(); i++)
        {
            LinearLayout laBtn = (LinearLayout) laBottomNav.getChildAt(i);
            final int finalI = i;
            laBtn.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    TypeTab typeTab = TypeTab.initFromPos(finalI);
                    presenter.onTabClicked(typeTab);
                }
            });
        }
    }
}

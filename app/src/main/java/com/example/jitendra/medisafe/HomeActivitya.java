package com.example.jitendra.medisafe;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;

import com.example.jitendra.medisafe.Tab_Navi_Fragment.Home;
import com.example.jitendra.medisafe.Tab_Navi_Fragment.Medication;
import com.example.jitendra.medisafe.Tab_Navi_Fragment.More;
import com.example.jitendra.medisafe.Tab_Navi_Fragment.Update;

import java.util.ArrayList;
import java.util.List;

public class HomeActivitya extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    android.app.ActionBar actionBar;


    private int tabicon[]={R.drawable.home,R.drawable.madici,R.drawable.update,R.drawable.list};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_activitya);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        actionBar=getActionBar();
        getSupportActionBar().setDisplayShowHomeEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        LayoutInflater mInflater = LayoutInflater.from(this);

        View mCustomView = mInflater.inflate(R.layout.addmedicationcustom, null);
        getSupportActionBar().setCustomView(mCustomView);
        getSupportActionBar().setDisplayShowCustomEnabled(true);


        viewPager=(ViewPager)findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        tabLayout=(TabLayout)findViewById(R.id.tabview);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcon();




    }

    private void setupTabIcon() {
        tabLayout.getTabAt(0).setIcon(tabicon[0]);
        tabLayout.getTabAt(1).setIcon(tabicon[1]);
        tabLayout.getTabAt(2).setIcon(tabicon[2]);
        tabLayout.getTabAt(3).setIcon(tabicon[3]);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.parseColor("#a8a8a8"), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        /*tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#1083e1"));
        tabLayout.setSelectedTabIndicatorHeight((int) (1 * getResources().getDisplayMetrics().density));
        tabLayout.setTabTextColors(Color.parseColor("#1083e1"), Color.parseColor("#1083e1"));*/
        tabLayout.getTabAt(0).getIcon().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(1).getIcon().setColorFilter(Color.parseColor("#a8a8a8"), PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(2).getIcon().setColorFilter(Color.parseColor("#a8a8a8"), PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(3).getIcon().setColorFilter(Color.parseColor("#a8a8a8"), PorterDuff.Mode.SRC_IN);

    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFrag(new Home(),getResources().getString(R.string.home));
        viewPagerAdapter.addFrag(new Medication(),getResources().getString(R.string.medi));
        viewPagerAdapter.addFrag(new Update(),getResources().getString(R.string.update));
        viewPagerAdapter.addFrag(new More(),getResources().getString(R.string.more));
        // viewPagerAdapter.addFrag(new Map_frag(), "More");
        viewPager.setAdapter(viewPagerAdapter);

    }




    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(android.support.v4.app.Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }

    }

}

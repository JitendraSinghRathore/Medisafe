package com.example.jitendra.medisafe;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.jitendra.medisafe.Tab_Navi_Fragment.Home;
import com.example.jitendra.medisafe.Tab_Navi_Fragment.Medication;
import com.example.jitendra.medisafe.Tab_Navi_Fragment.More;
import com.example.jitendra.medisafe.Tab_Navi_Fragment.Update;

public class HomeActivity extends AppCompatActivity {
    private ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final FragmentManager fragmentManager = getSupportFragmentManager();

        // define your fragments here


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
     //   navigation.getMenu().getItem(Integer.parseInt(null)).setChecked(true);
        //toolbar.setTitle("Shop");
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_shop:
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    Home home = new Home();
                    fragmentTransaction.add(R.id.framea, home);
                    fragmentTransaction.commit();
                    return true;
                case R.id.navigation_gifts:
                    FragmentManager fragmentManager1=getSupportFragmentManager();
                    android.support.v4.app.FragmentTransaction fragmentTransaction1=fragmentManager1.beginTransaction();
                    Medication medication=new Medication();
                    fragmentTransaction1.add(R.id.framea,medication);
                    fragmentTransaction1.commit();
                    return true;
                case R.id.navigation_cart:

                    FragmentManager fragmentManager2=getSupportFragmentManager();
                    android.support.v4.app.FragmentTransaction fragmentTransaction2=fragmentManager2.beginTransaction();
                    Update update=new Update();
                    fragmentTransaction2.add(R.id.framea,update);
                    fragmentTransaction2.commit();
                    return true;
                case R.id.navigation_profile:
                    FragmentManager fragmentManager3=getSupportFragmentManager();
                    android.support.v4.app.FragmentTransaction fragmentTransaction3=fragmentManager3.beginTransaction();
                    More more=new More();
                    fragmentTransaction3.add(R.id.framea,more);
                    return true;
            }
            return false;
        }
    };


}
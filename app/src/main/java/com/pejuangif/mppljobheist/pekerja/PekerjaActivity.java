package com.pejuangif.mppljobheist.pekerja;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import com.pejuangif.mppljobheist.R;

public class PekerjaActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private RelativeLayout layout;
    public ActionBar actionbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pekerja);
        actionbar = getSupportActionBar();


        loadFragment(new JobListFragment());
        // inisialisasi BottomNavigaionView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bn_main);
        // beri listener pada saat item/menu bottomnavigation terpilih
        bottomNavigationView.setOnNavigationItemSelectedListener(this);


    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()){
            case R.id.home_menu:
                fragment = new JobListFragment();
                break;
            case R.id.notif_menu:
                fragment = new NotifikasiPekerjaFragment();
                break;
            case R.id.riwayat_menu:
                fragment = new HistoryPekerjaFragment();
                break;
            case R.id.profil_menu:
                fragment = new ProfilePekerjaFragment();
                break;

        }
        return loadFragment(fragment);
    }

}

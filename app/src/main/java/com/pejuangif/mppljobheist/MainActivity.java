package com.pejuangif.mppljobheist;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import com.pejuangif.mppljobheist.model.Users;
import com.pejuangif.mppljobheist.pekerja.fragment.JobListPekerjaFragment;
import com.pejuangif.mppljobheist.pemberikerja.fragment.JobListPekerjaanFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    public static String EXTRA_ADMIN = "extra-admin";
    private RelativeLayout layout;
    public ActionBar actionbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionbar = getSupportActionBar();

        Users users = getIntent().getParcelableExtra(EXTRA_ADMIN);

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
                fragment = new NotifikasiFragment();
                break;
            case R.id.riwayat_menu:
                fragment = new HistoryFragment();
                break;
            case R.id.profil_menu:
                fragment = new ProfileBelumLoginFragment();
                break;

        }
        return loadFragment(fragment);
    }
}

package com.pejuangif.mppljobheist.pemberikerja;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import com.pejuangif.mppljobheist.R;
import com.pejuangif.mppljobheist.pemberikerja.fragment.JobListPekerjaanFragment;
import com.pejuangif.mppljobheist.pemberikerja.fragment.PostingPekerjaanFragment;
import com.pejuangif.mppljobheist.pemberikerja.fragment.ProfilePemberiKerjaFragment;
import com.pejuangif.mppljobheist.pemberikerja.fragment.ResponPekerjaanFragment;

public class PemberiKerjaActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    public static String EXTRA_PEMBERI_KERJA = "extra-pemberi-kerja";

    private RelativeLayout layout;
    public ActionBar actionbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pemberi_kerja);
        actionbar = getSupportActionBar();


        loadFragment(new JobListPekerjaanFragment());
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
                fragment = new JobListPekerjaanFragment();
                break;
            case R.id.notif_menu:
                fragment = new PostingPekerjaanFragment();
                break;
            case R.id.riwayat_menu:
                fragment = new ResponPekerjaanFragment();
                break;
            case R.id.profil_menu:
                fragment = new ProfilePemberiKerjaFragment();
                break;

        }
        return loadFragment(fragment);
    }

}

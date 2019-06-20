package com.pejuangif.mppljobheist;

import android.content.pm.ActivityInfo;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.pejuangif.mppljobheist.login_pencarikerja.LoginPencariKerjaFragment;

public class MainActivity extends AppCompatActivity {

    Fragment fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        Fragment fragment = new LoginPencariKerjaFragment();
        replaceFragment(fragment);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
    }

    void replaceFragment(Fragment fragment) {
        this.fragment = fragment;
        getSupportFragmentManager().beginTransaction().replace(R.id.rl_activity_main, fragment).commit();
    }
}

package com.pejuangif.mppljobheist.login;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.pejuangif.mppljobheist.R;
import com.pejuangif.mppljobheist.daftar.DaftarActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvLoginDaftar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        tvLoginDaftar = findViewById(R.id.tv_login_daftar);
        tvLoginDaftar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_login_daftar:
                Intent intent = new Intent(LoginActivity.this, DaftarActivity.class);
                startActivity(intent);
                break;
        }
    }
}

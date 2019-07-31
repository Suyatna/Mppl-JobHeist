package com.pejuangif.mppljobheist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.pejuangif.mppljobheist.pekerja.PekerjaActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(MainActivity.this, PekerjaActivity.class);
        startActivity(intent);
        finish();
    }
}

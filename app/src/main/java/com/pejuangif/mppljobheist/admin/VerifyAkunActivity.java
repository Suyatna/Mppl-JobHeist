package com.pejuangif.mppljobheist.admin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.pejuangif.mppljobheist.R;
import com.pejuangif.mppljobheist.pekerja.RegisterPekerjaActivity;
import com.pejuangif.mppljobheist.pemberikerja.RegisterPemberiKerjaActivity;

import java.util.Objects;

public class VerifyAkunActivity extends AppCompatActivity {
    Button btn_pkerja,btn_pmberikerja;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_akun);
        btn_pkerja = findViewById(R.id.btn_verify_pencarikerja);
        btn_pmberikerja = findViewById(R.id.btn_verify_pemberikerja);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Verify Akun");
    }

    @Override
    protected void onStart() {
        super.onStart();
        btn_pkerja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(VerifyAkunActivity.this, VerifyAkunPencariKerjaActivity.class);
                startActivity(intent);
            }
        });
        btn_pmberikerja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(VerifyAkunActivity.this, VerifyAkunPemberiKerjaActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

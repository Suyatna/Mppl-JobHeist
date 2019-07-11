package com.pejuangif.mppljobheist.pekerja;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.pejuangif.mppljobheist.R;
import com.pejuangif.mppljobheist.model.JobLists;

import java.util.Objects;

public class PostPekerjaanActivity extends AppCompatActivity {

    private ImageView ivFoto;
    private TextView tvJudul;
    private TextView tvDeskripsi;
    private TextView tvAlamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_pekerjaan);

        ivFoto = findViewById(R.id.iv_foto_post_pekerjaan);
        tvJudul = findViewById(R.id.tv_judul_post_pekerjaan);
        tvDeskripsi = findViewById(R.id.tv_deskripsi_post_pekerjaan);
        tvAlamat = findViewById(R.id.tv_alamat_post_pekerjaan);

        Intent intent = getIntent();
        JobLists jobLists = intent.getParcelableExtra("pekerjaan");

        Glide.with(this).load(jobLists.getImageurl()).into(ivFoto);
        tvJudul.setText(jobLists.getTitle());
        tvDeskripsi.setText(jobLists.getContent_desc());
        tvAlamat.setText(jobLists.getLocation());

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(jobLists.getTitle());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

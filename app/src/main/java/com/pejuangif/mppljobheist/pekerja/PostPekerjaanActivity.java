package com.pejuangif.mppljobheist.pekerja;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.pejuangif.mppljobheist.R;
import com.pejuangif.mppljobheist.model.JobLists;
import com.pejuangif.mppljobheist.model.Users;

import java.util.Objects;

public class PostPekerjaanActivity extends AppCompatActivity {
    private ImageView ivFoto;
    private TextView tvJudul;
    private TextView tvDeskripsi;
    private TextView tvAlamat;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_pekerjaan);

        ivFoto = findViewById(R.id.iv_foto_post_pekerjaan);
        tvJudul = findViewById(R.id.tv_judul_post_pekerjaan);
        tvDeskripsi = findViewById(R.id.tv_deskripsi_post_pekerjaan);
        tvAlamat = findViewById(R.id.tv_alamat_post_pekerjaan);
        btn = findViewById(R.id.btn_apply);

        Intent intent = getIntent();
        final JobLists jobLists = intent.getParcelableExtra("pekerjaan");
        final Users users = intent.getParcelableExtra("users");

        Glide.with(this).load(jobLists.getImageurl()).into(ivFoto);
        tvJudul.setText(jobLists.getTitle());
        tvDeskripsi.setText(jobLists.getContent_desc());
        tvAlamat.setText(jobLists.getLocation());

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    if (users.getLevelUsers().equals(null)) {
                        //
                    }
                    else {

                        Uri uri = Uri.parse(jobLists.getUri_form()); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                } catch (Exception e) {
                    e.printStackTrace();

                    Toast toast = Toast.makeText(getApplicationContext(),"You Not Login in This Session, Please Login", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
            }
        });

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

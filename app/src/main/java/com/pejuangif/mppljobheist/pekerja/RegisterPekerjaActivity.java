package com.pejuangif.mppljobheist.pekerja;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pejuangif.mppljobheist.R;
import com.pejuangif.mppljobheist.apihelper.BaseApiService;
import com.pejuangif.mppljobheist.apihelper.UtilsApi;
import com.pejuangif.mppljobheist.login.LoginActivity;
import com.pejuangif.mppljobheist.model.Users;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterPekerjaActivity extends AppCompatActivity {
    private Button daftar;
    private EditText email,nama,alamat,pendidikan;
    private EditText password;

    private Context context;
    private BaseApiService baseApiService;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_pekerja);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Daftar Pencari Kerja");
        daftar = findViewById(R.id.btn_daftar_pencarikerja);
        nama = findViewById(R.id.et_daftar_nama_lengkap);
        email= findViewById(R.id.et_daftar_email);
        password= findViewById(R.id.et_daftar_password);
        pendidikan= findViewById(R.id.et_daftar_pendidikan);
        alamat=findViewById(R.id.et_daftar_alamat);
        context = this;
        baseApiService = UtilsApi.getApiService();
        initComponents();

    }
    private void initComponents() {

        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestRegister();
            }
        });
    }
    private void requestRegister() {

        baseApiService.registerPencariKerja(nama.getText().toString() ,email.getText().toString(), password.getText().toString(),pendidikan.getText().toString(),alamat.getText().toString())
                .enqueue(new Callback<Users>() {
                    @Override
                    public void onResponse(Call<Users> call, Response<Users> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(context, "Registrasi Berhasil", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(context, LoginActivity.class);
                            startActivity(intent);

                        }


                    }


                    @Override
                    public void onFailure(Call<Users> call, Throwable t) {
                        Toast.makeText(context, "Koneksi Internet Bermasalah", Toast.LENGTH_SHORT).show();
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

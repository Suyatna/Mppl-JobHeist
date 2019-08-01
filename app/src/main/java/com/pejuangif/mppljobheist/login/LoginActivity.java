package com.pejuangif.mppljobheist.login;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.pejuangif.mppljobheist.R;
import com.pejuangif.mppljobheist.admin.AdminHomeActivity;
import com.pejuangif.mppljobheist.apihelper.BaseApiService;
import com.pejuangif.mppljobheist.apihelper.UtilsApi;
import com.pejuangif.mppljobheist.daftar.DaftarActivity;
import com.pejuangif.mppljobheist.model.PencariKerja;
import com.pejuangif.mppljobheist.model.Users;
import com.pejuangif.mppljobheist.pekerja.PekerjaActivity;
import com.pejuangif.mppljobheist.pemberikerja.PemberiKerjaActivity;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText email;
    private EditText password;
    private Button btnLogin;

    private Context context;
    private BaseApiService baseApiService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Objects.requireNonNull(getSupportActionBar()).hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        TextView tvLoginDaftar = findViewById(R.id.tv_login_daftar);
        tvLoginDaftar.setOnClickListener(this);

        email = findViewById(R.id.et_login_email);
        password = findViewById(R.id.et_login_password);
        btnLogin = findViewById(R.id.btn_login);

        context = this;
        baseApiService = UtilsApi.getApiService();
        initComponents();
    }

    private void initComponents() {

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestLogin();
            }
        });
    }

    private void requestLogin() {

        baseApiService.loginRequest(email.getText().toString(), password.getText().toString())
                .enqueue(new Callback<Users>() {
                    @Override
                    public void onResponse(Call<Users> call, Response<Users> response) {
                        if (response.isSuccessful()) {

                            Users usersData = response.body();
                            System.out.println(Objects.requireNonNull(usersData).getId());
                            System.out.println(usersData.getName());
                            System.out.println(usersData.getEmail());
                            System.out.println(usersData.getGenerate_token());

                            Users users = new Users();
                            users.setId(usersData.getId());
                            users.setName(usersData.getName());
                            users.setEmail(usersData.getEmail());
                            users.setGenerate_token(usersData.getGenerate_token());
                            users.setAlamat(usersData.getAlamat());
                            users.setAvatar(usersData.getAvatar());
                            users.setPendidikan_terakhir(usersData.getPendidikan_terakhir());
                            users.setCv(usersData.getCv());
                            users.setLevelUsers(usersData.getLevelUsers());

                            if (usersData.getLevelUsers().equals("admin")) {
                                Intent admin = new Intent(context, AdminHomeActivity.class);
                                admin.putExtra(AdminHomeActivity.EXTRA_ADMIN, users);
                                context.startActivity(admin);
                            }
                            else if (usersData.getLevelUsers().equals("pencari_kerja")) {
                                Intent pencari_kerja = new Intent(context, PekerjaActivity.class);
                                pencari_kerja.putExtra(PencariKerja.EXTRA_PENCARI_KERJA, users);
                                context.startActivity(pencari_kerja);
                            }
                            else if (usersData.getLevelUsers().equals("pemberi_kerja")) {
                                Intent pemberi_kerja = new Intent(context, PemberiKerjaActivity.class);
                                pemberi_kerja.putExtra(PemberiKerjaActivity.EXTRA_PEMBERI_KERJA, users);
                                context.startActivity(pemberi_kerja);
                            }
                        }
                        else
                            if (response.message().equals("Email tidak ditemukan"))
                            Toast.makeText(context, "Email/Password salah!", Toast.LENGTH_SHORT).show();
                    }


                    @Override
                    public void onFailure(Call<Users> call, Throwable t) {
                            Toast.makeText(context, "Koneksi Internet Bermasalah", Toast.LENGTH_SHORT).show();
                    }
                });
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

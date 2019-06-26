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
import com.pejuangif.mppljobheist.model.Users;
import com.pejuangif.mppljobheist.apihelper.UtilsApi;
import com.pejuangif.mppljobheist.daftar.DaftarActivity;

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

                            Intent intent = new Intent(context, AdminHomeActivity.class);
                            intent.putExtra(AdminHomeActivity.EXTRA_USERS, users);
                            startActivity(intent);
                        }
                        else
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

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
import com.pejuangif.mppljobheist.model.User;
import com.pejuangif.mppljobheist.apihelper.UtilsApi;
import com.pejuangif.mppljobheist.daftar.DaftarActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvLoginDaftar;
    EditText email, password;
    Button btnLogin;

    Context context;
    BaseApiService baseApiService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        tvLoginDaftar = findViewById(R.id.tv_login_daftar);
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
                .enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if (response.isSuccessful()) {

                            User userData = response.body();
                            System.out.println(userData.getId());
                            System.out.println(userData.getName());
                            System.out.println(userData.getEmail());
                            System.out.println(userData.getGenerate_token());

                            User user = new User();
                            user.setId(userData.getId());
                            user.setName(userData.getName());
                            user.setEmail(userData.getEmail());
                            user.setGenerate_token(userData.getGenerate_token());

                            Intent intent = new Intent(context, AdminHomeActivity.class);
                            intent.putExtra(AdminHomeActivity.EXTRA_USERS, user);
                            startActivity(intent);
                        }
                        else
                            Toast.makeText(context, "Email/Password salah!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
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

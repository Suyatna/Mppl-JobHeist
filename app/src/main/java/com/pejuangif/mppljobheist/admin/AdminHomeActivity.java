package com.pejuangif.mppljobheist.admin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.pejuangif.mppljobheist.R;
import com.pejuangif.mppljobheist.jobList.JobListActivity;
import com.pejuangif.mppljobheist.model.Users;

import java.util.Objects;

public class AdminHomeActivity extends AppCompatActivity implements View.OnClickListener {

    public static String EXTRA_ADMIN = "extra-admin";

    LinearLayout linearAdminHomeRiwayat;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        context = this;
        linearAdminHomeRiwayat = findViewById(R.id.linear_admin_home_riwayat);
        linearAdminHomeRiwayat.setOnClickListener(this);

        Users users = getIntent().getParcelableExtra(EXTRA_ADMIN);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(users.getName());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.linear_admin_home_riwayat:
                Intent intent = new Intent(context, JobListActivity.class);
                context.startActivity(intent);
                break;
        }
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

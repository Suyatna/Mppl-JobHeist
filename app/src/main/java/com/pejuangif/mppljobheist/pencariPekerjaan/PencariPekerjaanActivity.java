package com.pejuangif.mppljobheist.pencariPekerjaan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.pejuangif.mppljobheist.R;
import com.pejuangif.mppljobheist.apihelper.BaseApiService;
import com.pejuangif.mppljobheist.apihelper.RetrofilClient;
import com.pejuangif.mppljobheist.model.PencariPekerjaan;
import com.pejuangif.mppljobheist.model.PencariPekerjaanData;

import java.util.ArrayList;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PencariPekerjaanActivity extends AppCompatActivity {

    private BaseApiService baseApiService;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pencari_pekerjaan);

        mRecyclerView = findViewById(R.id.rv_activity_pencaripekerjaan);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        baseApiService = RetrofilClient.getClient().create(BaseApiService.class);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Lihat Daftar");

        mShowPencariPekerjaanList();
    }

    private void mShowPencariPekerjaanList() {

        Call<PencariPekerjaanData> pencariPekerjaanDataCall = baseApiService.pencariPekerjaanRequest();
        pencariPekerjaanDataCall.enqueue(new Callback<PencariPekerjaanData>() {
            @Override
            public void onResponse(Call<PencariPekerjaanData> call, Response<PencariPekerjaanData> response) {

                ArrayList<PencariPekerjaan> pencariPekerjaanArrayList = response.body().getPencariPekerjaanArray();
                mAdapter = new PencariPekerjaanAdapter(pencariPekerjaanArrayList, PencariPekerjaanActivity.this);
                mRecyclerView.setAdapter(mAdapter);

            }

            @Override
            public void onFailure(Call<PencariPekerjaanData> call, Throwable t) {

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
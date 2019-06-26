package com.pejuangif.mppljobheist.JobList;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;

import com.pejuangif.mppljobheist.R;
import com.pejuangif.mppljobheist.apihelper.BaseApiService;
import com.pejuangif.mppljobheist.apihelper.RetrofilClient;
import com.pejuangif.mppljobheist.model.JobListData;
import com.pejuangif.mppljobheist.model.JobLists;

import java.util.ArrayList;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JobListActivity extends AppCompatActivity {

    BaseApiService baseApiService;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static JobListActivity ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joblist);

        mRecyclerView = findViewById(R.id.rv_activity_joblist);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        baseApiService = RetrofilClient.getClient().create(BaseApiService.class);
        ma = this;

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Riwayar Pencari Kerja");

        mShowJobLists();
    }

    void mShowJobLists() {

        Call<JobListData> jobListDataCall = baseApiService.jobListRequest();
        jobListDataCall.enqueue(new Callback<JobListData>() {
            @Override
            public void onResponse(Call<JobListData> call, Response<JobListData> response) {
                ArrayList<JobLists> jobListsArrayList = response.body().getJobListsArray();
                mAdapter = new JobListAdapter(jobListsArrayList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<JobListData> call, Throwable t) {

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

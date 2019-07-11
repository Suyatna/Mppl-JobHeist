package com.pejuangif.mppljobheist.pekerja;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.pejuangif.mppljobheist.R;
import com.pejuangif.mppljobheist.apihelper.BaseApiService;
import com.pejuangif.mppljobheist.apihelper.RetrofilClient;
import com.pejuangif.mppljobheist.jobList.JobListActivity;
import com.pejuangif.mppljobheist.jobList.JobListAdapter;
import com.pejuangif.mppljobheist.model.JobListData;
import com.pejuangif.mppljobheist.model.JobLists;

import java.util.ArrayList;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JobListFragment extends Fragment {
    private BaseApiService baseApiService;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_joblist_pekerja,container,false);
        ((PekerjaActivity)getActivity()).actionbar.setTitle("List Pekerjaan");
        mRecyclerView = view.findViewById(R.id.rv_activity_joblist);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        baseApiService = RetrofilClient.getClient().create(BaseApiService.class);

        mShowJobLists();

        return view;
    }


    private void mShowJobLists() {

        Call<JobListData> jobListDataCall = baseApiService.jobListRequest();
        jobListDataCall.enqueue(new Callback<JobListData>() {
            @Override
            public void onResponse(Call<JobListData> call, Response<JobListData> response) {
                ArrayList<JobLists> jobListsArrayList = Objects.requireNonNull(response.body()).getJobListsArray();
                mAdapter = new JobListAdapter(jobListsArrayList, getContext());
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<JobListData> call, Throwable t) {

            }
        });
    }


}
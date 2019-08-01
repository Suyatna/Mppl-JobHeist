package com.pejuangif.mppljobheist.pemberikerja.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.pejuangif.mppljobheist.R;
import com.pejuangif.mppljobheist.apihelper.BaseApiService;
import com.pejuangif.mppljobheist.apihelper.RetrofilClient;
import com.pejuangif.mppljobheist.jobList.JobListAdapter;
import com.pejuangif.mppljobheist.model.JobListData;
import com.pejuangif.mppljobheist.model.JobLists;
import com.pejuangif.mppljobheist.pekerja.PekerjaActivity;

import java.util.ArrayList;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JobListPekerjaanFragment extends Fragment {
    private BaseApiService baseApiService;
    private SearchView searchView;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private SwipeRefreshLayout mySwipeRefreshLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_joblist,container,false);
        ((PekerjaActivity)getActivity()).actionbar.setTitle("List Pekerjaan");
        setHasOptionsMenu(true);

        mySwipeRefreshLayout= view.findViewById(R.id.swiperefresh);
        mRecyclerView = view.findViewById(R.id.rv_activity_joblist);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        baseApiService = RetrofilClient.getClient().create(BaseApiService.class);

        mShowJobLists();

        mySwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mShowJobLists();
                        mySwipeRefreshLayout.setRefreshing(false);

                    }
                }, 2000);

            }
        });
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        inflater.inflate(R.menu.menu_search,menu);
        MenuItem item=menu.findItem(R.id.action_search);
        searchView=new  SearchView(((PekerjaActivity) getActivity()).getSupportActionBar().getThemedContext());
        MenuItemCompat.setShowAsAction(item, MenuItemCompat.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW | MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);
        MenuItemCompat.setActionView(item, searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
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
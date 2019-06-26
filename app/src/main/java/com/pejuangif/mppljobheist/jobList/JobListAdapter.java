package com.pejuangif.mppljobheist.jobList;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pejuangif.mppljobheist.R;
import com.pejuangif.mppljobheist.model.JobLists;

import java.util.ArrayList;

public class JobListAdapter extends RecyclerView.Adapter<JobListAdapter.JobListHolder> {

    private final ArrayList<JobLists> mJobListArray;

    private ArrayList<JobLists> mGetScoutRegimentArray() {return  mJobListArray;}

    public JobListAdapter(ArrayList<JobLists> mJobListArray) {
        this.mJobListArray = mJobListArray;
    }

    @NonNull
    @Override
    public JobListHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_joblist, viewGroup, false);
        return new JobListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JobListHolder jobListHolder, int i) {
        final JobLists jobLists = mGetScoutRegimentArray().get(i);

        jobListHolder.tvTitle.setText(jobLists.getTitle());
        jobListHolder.tvAuthor.setText(jobLists.getAuthor());
    }

    @Override
    public int getItemCount() {
        return mJobListArray.size();
    }

    public class JobListHolder extends RecyclerView.ViewHolder {

        final TextView tvTitle;
        final TextView tvAuthor;


        JobListHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tv_item_joblist_title);
            tvAuthor = itemView.findViewById(R.id.tv_item_joblist_author);
        }
    }
}

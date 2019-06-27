package com.pejuangif.mppljobheist.pencariPekerjaan;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.pejuangif.mppljobheist.R;
import com.pejuangif.mppljobheist.model.PencariPekerjaan;

import java.util.ArrayList;

public class PencariPekerjaanAdapter extends RecyclerView.Adapter<PencariPekerjaanAdapter.PencariPekerjaanAdapterHolder> {

    private final ArrayList<PencariPekerjaan> pencariPekerjaanArrayList;
    private Context context;

    private ArrayList<PencariPekerjaan> mGetPencariPekerjaanList() { return pencariPekerjaanArrayList; }

    public PencariPekerjaanAdapter(ArrayList<PencariPekerjaan> pencariPekerjaanArrayList, Context context) {
        this.pencariPekerjaanArrayList = pencariPekerjaanArrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public PencariPekerjaanAdapter.PencariPekerjaanAdapterHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_pencarikerja, viewGroup, false);
        return new PencariPekerjaanAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PencariPekerjaanAdapter.PencariPekerjaanAdapterHolder pencariPekerjaanAdapterHolder, int i) {

        final PencariPekerjaan pencariPekerjaan = mGetPencariPekerjaanList().get(i);

        Glide.with(context).load(pencariPekerjaan.getAvatar()).into(pencariPekerjaanAdapterHolder.ivPhoto);
        pencariPekerjaanAdapterHolder.tvTitle.setText(pencariPekerjaan.getName());
    }

    @Override
    public int getItemCount() {
        return pencariPekerjaanArrayList.size();
    }

    public class PencariPekerjaanAdapterHolder extends RecyclerView.ViewHolder {

        final ImageView ivPhoto;
        final TextView tvTitle;

        public PencariPekerjaanAdapterHolder(@NonNull View itemView) {
            super(itemView);

            ivPhoto = itemView.findViewById(R.id.civ_item_pencarikerja_photo);
            tvTitle = itemView.findViewById(R.id.tv_item_pencarikerja_title);
        }
    }
}

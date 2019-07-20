package com.pejuangif.mppljobheist.pekerja.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pejuangif.mppljobheist.R;
import com.pejuangif.mppljobheist.pekerja.PekerjaActivity;

public class HistoryPekerjaFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history_pekerja,container,false);
        ((PekerjaActivity)getActivity()).actionbar.setTitle("Riwayat Lamaran");
        return view;
    }
}

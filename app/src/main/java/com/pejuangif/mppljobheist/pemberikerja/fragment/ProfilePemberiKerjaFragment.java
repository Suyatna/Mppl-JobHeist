package com.pejuangif.mppljobheist.pemberikerja.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.pejuangif.mppljobheist.R;
import com.pejuangif.mppljobheist.pekerja.EditProfilePekerjaActivity;
import com.pejuangif.mppljobheist.pekerja.PekerjaActivity;
import com.pejuangif.mppljobheist.pemberikerja.EditProfilePemberiKerjaActivity;

public class ProfilePemberiKerjaFragment extends Fragment implements View.OnClickListener {
    LinearLayout ubahprofil,bantuan,keluar,tentangaplikasi;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view=inflater.inflate(R.layout.fragment_profile_pemberi_kerja,container,false);
        ((PekerjaActivity)getActivity()).actionbar.setTitle("Profile");
        ubahprofil=view.findViewById(R.id.ubah_profile);
        bantuan=view.findViewById(R.id.help);
        keluar=view.findViewById(R.id.logout);
        tentangaplikasi=view.findViewById(R.id.about);
        ubahprofil.setOnClickListener(this);
        bantuan.setOnClickListener(this);
        keluar.setOnClickListener(this);
        tentangaplikasi.setOnClickListener(this);
        return view;

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ubah_profile:
                Intent intent=new Intent(getContext(), EditProfilePemberiKerjaActivity.class);
                startActivity(intent);
                break;
            case R.id.help:

                break;
            case R.id.logout:

                break;
            case R.id.about:

                break;
        }
    }
}

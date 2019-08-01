package com.pejuangif.mppljobheist.pekerja.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pejuangif.mppljobheist.MainActivity;
import com.pejuangif.mppljobheist.R;
import com.pejuangif.mppljobheist.apihelper.BaseApiService;
import com.pejuangif.mppljobheist.apihelper.UtilsApi;
import com.pejuangif.mppljobheist.login.LoginActivity;
import com.pejuangif.mppljobheist.model.Users;
import com.pejuangif.mppljobheist.pekerja.EditProfilePekerjaActivity;
import com.pejuangif.mppljobheist.pekerja.PekerjaActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfilePekerjaFragment extends Fragment implements View.OnClickListener {
    public static String EXTRA_ADMIN = "extra-admin";
    LinearLayout ubahprofil,bantuan,keluar,tentangaplikasi;
    private TextView tvname;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view=inflater.inflate(R.layout.fragment_profile_pekerja,container,false);
            Users users = ((PekerjaActivity)getActivity()).getIntent().getParcelableExtra(EXTRA_ADMIN);
            tvname= view.findViewById(R.id.tv_profile_name);
            ubahprofil=view.findViewById(R.id.ubah_profile);
            bantuan=view.findViewById(R.id.help);
            keluar=view.findViewById(R.id.logout);
            tentangaplikasi=view.findViewById(R.id.about);

            tvname.setText(users.getName());
            ubahprofil.setOnClickListener(this);
            bantuan.setOnClickListener(this);
            keluar.setOnClickListener(this);
            tentangaplikasi.setOnClickListener(this);
        ((PekerjaActivity)getActivity()).actionbar.setTitle("Profile");

        return view;

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.ubah_profile:
                intent=new Intent(getContext(), EditProfilePekerjaActivity.class);
                startActivity(intent);
                break;
            case R.id.help:

                break;
            case R.id.logout:
                intent=new Intent(getContext(), MainActivity.class);
                startActivity(intent);
                break;
            case R.id.about:

                break;
        }
    }
}

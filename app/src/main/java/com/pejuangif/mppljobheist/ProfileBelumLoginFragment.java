package com.pejuangif.mppljobheist;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.pejuangif.mppljobheist.login.LoginActivity;
import com.pejuangif.mppljobheist.pekerja.EditProfilePekerjaActivity;
import com.pejuangif.mppljobheist.pekerja.PekerjaActivity;

public class ProfileBelumLoginFragment extends Fragment implements View.OnClickListener {
    LinearLayout login;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view=inflater.inflate(R.layout.fragment_profile_belum_login,container,false);
        ((MainActivity)getActivity()).actionbar.setTitle("Profile");
        login = view.findViewById(R.id.login);
        login.setOnClickListener(this);
        return view;

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
                Intent intent=new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
        }
    }
}

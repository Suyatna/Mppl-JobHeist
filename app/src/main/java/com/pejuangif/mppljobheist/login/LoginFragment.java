package com.pejuangif.mppljobheist.login;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pejuangif.mppljobheist.R;
import com.pejuangif.mppljobheist.base.BaseFragment;

public class LoginFragment extends BaseFragment implements View.OnClickListener {

    TextView tvLoginDaftar;
    Fragment fragment = null;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.activity_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvLoginDaftar = view.findViewById(R.id.tv_login_daftar);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_login_daftar:
                break;
        }
    }

    void replaceFragment(Fragment fragment) {
        this.fragment = fragment;
        
    }
}

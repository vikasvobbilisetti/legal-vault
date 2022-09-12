package com.ziroh.legalvault.profile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ziroh.legalvault.R;


public class ProfilePasswordReset extends Fragment {

    TextView pass_reset_confirm_btn;
    ImageView pass_reset_cross_btn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile_password_reset, container, false);

        pass_reset_confirm_btn = view.findViewById(R.id.profile_reset_confirm);
        pass_reset_cross_btn = view.findViewById(R.id.profile_pass_reset_cross);

        pass_reset_confirm_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new Profile());
            }
        });

        pass_reset_cross_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new Profile());
            }
        });

        return view;
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = this.getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView,fragment);
        // Replacing in fragmentCOntainer View
        fragmentTransaction.commit();
    }
}
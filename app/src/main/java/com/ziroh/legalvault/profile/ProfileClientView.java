package com.ziroh.legalvault.profile;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.ziroh.legalvault.R;


public class ProfileClientView extends Fragment {
    TextView edit_btn_client,remove,changepass;
    TextView name_client,email_client,poc_client,email2_client;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile_client_view, container, false);

        remove =view.findViewById(R.id.profile_client_view_remove);
        changepass = view.findViewById(R.id.profile_client_view_CP);
        edit_btn_client = view.findViewById(R.id.edit_button_main);
        name_client = view.findViewById(R.id.name_client_view);
        email_client = view.findViewById(R.id.email_client_view);
        poc_client = view.findViewById(R.id.poc_client_view);
        email2_client = view.findViewById(R.id.email2_client_view);


        getParentFragmentManager().setFragmentResultListener("datafrom_edit_client", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {

                String data1 = result.getString("name_client_key");
                name_client.setText(data1);
                String data2 = result.getString("email_client_key");
                email_client.setText(data2);
                String data3 = result.getString("poc_client_key");
                poc_client.setText(data3);
                String data4 = result.getString("email2_client_key");
                email2_client.setText(data4);
            }
        });

        edit_btn_client.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainerView,new ProfileClientEdit());
                // Replacing in fragmentCOntainer View
                fragmentTransaction.commit();
            }
        });

        changepass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new ProfilePasswordReset());
            }
        });

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new ProfileRemove());
            }
        });

        return view;
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView,fragment).commit();
    }

}
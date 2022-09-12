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


public class Profile extends Fragment {
    ;
    TextView name_employee,position_employee,email_employee,depart_employee,edit_employee_btn,remove,changepass;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_profile, container, false);
        remove =view.findViewById(R.id.profile_employee_view_remove);
        changepass = view.findViewById(R.id.profile_employee_view_CP);
        edit_employee_btn = view.findViewById(R.id.edit_button_main);
        name_employee = view.findViewById(R.id.name_employee_view);
        position_employee = view.findViewById(R.id.position_employee_view);
        email_employee = view.findViewById(R.id.email_employee_view);
        depart_employee = view.findViewById(R.id.Depart_employee_view);

        getParentFragmentManager().setFragmentResultListener("datafrom_edit", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {

                String data1 = result.getString("name_employee_key");
                name_employee.setText(data1);
                String data2 = result.getString("profile_employee_key");
                position_employee.setText(data2);
                String data3 = result.getString("email_employee_key");
                email_employee.setText(data3);
                String data4 = result.getString("depart_employee_key");
                depart_employee.setText(data4);
            }
        });


        edit_employee_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainerView,new ProfileEdit());
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
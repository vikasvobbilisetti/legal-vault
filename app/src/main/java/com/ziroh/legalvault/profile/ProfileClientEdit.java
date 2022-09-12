package com.ziroh.legalvault.profile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.ziroh.legalvault.R;


public class ProfileClientEdit extends Fragment {
    EditText name_client,email_client,poc_client,email2_client;
    TextView save_client_btn,changepass,remove;
    String[] items = {"Client","Employee","Partner"};
    Spinner spinner;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile_client_edit, container, false);

        ArrayAdapter<String> adapterItems;
        remove =view.findViewById(R.id.profile_client_edit_remove);
        changepass = view.findViewById(R.id.profile_client_edit_CP);
        save_client_btn = view.findViewById(R.id.save_button_main);
        name_client = view.findViewById(R.id.name_edit_client);
        email_client = view.findViewById(R.id.email_edit_client);
        poc_client = view.findViewById(R.id.poc_edit_client);
        email2_client = view.findViewById(R.id.email2_edit_client);
        spinner = view.findViewById(R.id.spinner_client);

        adapterItems = new ArrayAdapter<String>(getActivity(), com.google.android.material.R.layout.support_simple_spinner_dropdown_item,items);
        adapterItems.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterItems);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        break;
                    case 1:
                        replaceFragment(new ProfileEdit());
                        break;
                    case 2:
                        replaceFragment(new ProfilePartnerEdit());
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        save_client_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();
                bundle.putString("name_client_key",name_client.getText().toString());
                bundle.putString("poc_client_key",poc_client.getText().toString());
                bundle.putString("email_client_key",email_client.getText().toString());
                bundle.putString("email2_client_key",email2_client.getText().toString());
                getParentFragmentManager().setFragmentResult("datafrom_edit_client",bundle);
//                edit_name_employee.setText("");
                replaceFragment(new ProfileClientView());

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
        FragmentTransaction fragmentTransaction = this.getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView,fragment).commit();
    }
}
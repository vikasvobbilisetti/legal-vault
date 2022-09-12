package com.ziroh.legalvault.profile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.ziroh.legalvault.R;


public class ProfilePartnerEdit extends Fragment {
    EditText name_employee,position_employee,email_employee,depart_employee;
    TextView save_employee_btn,remove,changepass;
    String[] items = {"Partner","Client","Employee"};
    Spinner spinner;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profile_partner_edit, container, false);

        ArrayAdapter<String> adapterItems;
//        AutoCompleteTextView autoCompleteTextView;
        remove =v.findViewById(R.id.profile_partner_edit_remove);
        changepass = v.findViewById(R.id.profile_partner_edit_CP);
        save_employee_btn = v.findViewById(R.id.save_button_main);
        name_employee = v.findViewById(R.id.name_edit_partner);
        position_employee = v.findViewById(R.id.position_edit_partner);
        email_employee = v.findViewById(R.id.email_edit_partner);
        depart_employee = v.findViewById(R.id.Depart_edit_partner);
        spinner = v.findViewById(R.id.spinner_partner);

        adapterItems = new ArrayAdapter<String>(getActivity(), androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item,items);
        adapterItems.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterItems);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0:
                        break;
                    case 1:
                        replaceFragment(new ProfileClientEdit());
                        break;
                    case 2:
                        replaceFragment(new ProfileEdit());
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        save_employee_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();
                bundle.putString("name_partner_key",name_employee.getText().toString());
                bundle.putString("profile_partner_key",position_employee.getText().toString());
                bundle.putString("email_partner_key",email_employee.getText().toString());
                bundle.putString("depart_partner_key",depart_employee.getText().toString());
                getParentFragmentManager().setFragmentResult("datafrom_partner",bundle);
//                edit_name_employee.setText("");


                getFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,new ProfilePartnerView()).commit();

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




        return v;
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = this.getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView,fragment).commit();
    }

}
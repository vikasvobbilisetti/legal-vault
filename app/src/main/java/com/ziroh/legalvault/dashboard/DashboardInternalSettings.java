package com.ziroh.legalvault.dashboard;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.ziroh.legalvault.R;
import com.ziroh.legalvault.adapters.SettingsEmployeeAdapter;
import com.ziroh.legalvault.adapters.SettingsPartnerAdapter;
import com.ziroh.legalvault.datastorage.SettingsEmployee;
import com.ziroh.legalvault.datastorage.SettingsPartner;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DashboardInternalSettings#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DashboardInternalSettings extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private RecyclerView employeeRecyclerView;
    private LinearLayoutManager linearLayoutManager;
    private SettingsEmployeeAdapter adapter;
    private SettingsPartnerAdapter partnerAdapter;
    public static int lengthOfList;
    private NavController navController;
    private List<SettingsEmployee> employeeList;
    private List<SettingsPartner> partnerList;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DashboardInternalSettings() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DashboardInternalSettings.
     */
    // TODO: Rename and change types and number of parameters
    public static DashboardInternalSettings newInstance(String param1, String param2) {
        DashboardInternalSettings fragment = new DashboardInternalSettings();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard_internal_settings, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view,savedInstanceState);

        Spinner spinner = view.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this.getContext(), R.array.settings, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        arrayAdapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        initiateEmployeeData();
        initiatePartnerData();

        initiateRecyclerView(view);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String spinnerItem = spinner.getSelectedItem().toString();
                if (spinnerItem.equals("Employees")) {
                    adapter = new SettingsEmployeeAdapter(employeeList);
                    employeeRecyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                } else {
                    partnerAdapter = new SettingsPartnerAdapter(partnerList);
                    employeeRecyclerView.setAdapter(partnerAdapter);
                    partnerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                initiateRecyclerView(view);
                adapter = new SettingsEmployeeAdapter(employeeList);
                employeeRecyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });

        TextView save = view.findViewById(R.id.settings_save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, new DashboardSettingsConfirmChanges()).commit();
            }
        });
    }

    private void initiatePartnerData() {

        partnerList = new ArrayList<>();
        partnerList.add(new SettingsPartner("Partner_1", "partner1@vault.com"));
        partnerList.add(new SettingsPartner("Partner_2", "partner2@vault.com"));
        partnerList.add(new SettingsPartner("Partner_3", "partner3@vault.com"));
        partnerList.add(new SettingsPartner("Partner_4", "partner4@vault.com"));
        partnerList.add(new SettingsPartner("Partner_5", "partner5@vault.com"));
        partnerList.add(new SettingsPartner("Partner_6", "partner6@vault.com"));

    }

    private void initiateEmployeeData() {

        employeeList = new ArrayList<>();
        employeeList.add(new SettingsEmployee("Employee_1", "employee1@vault.com"));
        employeeList.add(new SettingsEmployee("Employee_2", "employee2@vault.com"));
        employeeList.add(new SettingsEmployee("Employee_3", "employee3@vault.com"));
        employeeList.add(new SettingsEmployee("Employee_4", "employee4@vault.com"));
        employeeList.add(new SettingsEmployee("Employee_5", "employee5@vault.com"));
        employeeList.add(new SettingsEmployee("Employee_6", "employee6@vault.com"));

    }

    private void initiateRecyclerView(View view) {
        employeeRecyclerView = view.findViewById(R.id.settings_employee_recycler_view);
        linearLayoutManager = new LinearLayoutManager(this.getContext());
        linearLayoutManager.setOrientation(employeeRecyclerView.VERTICAL);
        employeeRecyclerView.setLayoutManager(linearLayoutManager);
    }

    public static int getLengthOfList() {
        return lengthOfList;
    }

    public void setLengthOfList(int lengthOfList) {
        this.lengthOfList = lengthOfList;
    }
}
package com.ziroh.legalvault.dashboard;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ziroh.legalvault.R;
import com.ziroh.legalvault.adapters.SettingsAdapter;
import com.ziroh.legalvault.datastorage.Settings;
import com.ziroh.legalvault.datastorage.SettingsList;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DashboardSettings#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DashboardSettings extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private RecyclerView settingsRecyclerView;
    private LinearLayoutManager linearLayoutManager;
    private SettingsAdapter adapter;
    public static int lengthOfList;
    private NavController navController;
    private SettingsList settingsList = new SettingsList();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DashboardSettings() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DashboardSettings.
     */
    // TODO: Rename and change types and number of parameters
    public static DashboardSettings newInstance(String param1, String param2) {
        DashboardSettings fragment = new DashboardSettings();
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
        return inflater.inflate(R.layout.fragment_dashboard_settings, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView add = view.findViewById(R.id.settings_add_symbol);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, new DashboardInternalSettings()).commit();
            }
        });
        initiateSettingsData();
        initiateRecyclerView(view);
    }

    private void initiateSettingsData() {
        settingsList.addSetting("Partner_1", "Partner");
        settingsList.addSetting("Partner_2", "Partner");
        settingsList.addSetting("Employee_1", "Employee");
        settingsList.addSetting("Employee_2", "Employee");
    }

    private void initiateRecyclerView(View view) {
        settingsRecyclerView = view.findViewById(R.id.settings_recycler);
        linearLayoutManager = new LinearLayoutManager(this.getContext());
        linearLayoutManager.setOrientation(settingsRecyclerView.VERTICAL);
        settingsRecyclerView.setLayoutManager(linearLayoutManager);
        adapter = new SettingsAdapter(SettingsList.getSettingsList());
        settingsRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
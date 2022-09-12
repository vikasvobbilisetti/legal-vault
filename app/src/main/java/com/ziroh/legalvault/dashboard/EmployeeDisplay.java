package com.ziroh.legalvault.dashboard;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ziroh.legalvault.R;
import com.ziroh.legalvault.datastorage.DashboardEmployeeAdapter;
import com.ziroh.legalvault.datastorage.DashboardTeamList;


public class EmployeeDisplay extends Fragment {
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private DashboardEmployeeAdapter adapter;
    private DashboardTeamList teamList = new DashboardTeamList();
    private ImageView squarebox;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_employee_display, container, false);

        initiateData();
        initiateRecyclerView(view);

        return view;
    }

    private void initiateRecyclerView(View view) {
        recyclerView = view.findViewById(R.id.recyclerView_dashboard);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(recyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new DashboardEmployeeAdapter(DashboardTeamList.getContactList());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void initiateData() {
        teamList.addTeam("Ashiq Shibin","AshiqShibin@gamil.com","Associate");
        teamList.addTeam("Harsha K","Harsha@gamil.com","System Admin");
        teamList.addTeam("Zamil","Zamil@gamil.com","Sys Manager");
        teamList.addTeam("Prathab B","Prathab@gamil.com","Associate");
        teamList.addTeam("Akash Raj","Akash@gamil.com","System Admin");
        teamList.addTeam("Prathisha","Prathisha@gamil.com","Sys Manager");
        teamList.addTeam("Nithin","aNithin@gamil.com","System Admin");
        teamList.addTeam("Vignesh Ram","Vignesh@gamil.com","Associate");
        teamList.addTeam("Mohammed","Mohammed@gamil.com","Sys Manager");
        teamList.addTeam("Dilip Kumar","Dilip@gamil.com","ios");
        teamList.addTeam("Faasil","Faasil@gamil.com","System Admin");
        teamList.addTeam("Nippun","Nippun3@gamil.com","Associate");
        teamList.addTeam("Rajeev","Rajeev@gamil.com","Sys Manager");
        teamList.addTeam("Lochana","Lochana@gamil.com","System Admin");
        teamList.addTeam("Nikith","Nikith@gamil.com","Associate");
        teamList.addTeam("Teja","Teja@gamil.com","Sys Manager");
        teamList.addTeam("Kavya","Kavya@gamil.com","System Admin");
        teamList.addTeam("Vishruth","Vishruth@gamil.com","Sys Manager");
        teamList.addTeam("Vikas","Vikas@gamil.com","Associate");
        teamList.addTeam("Uttam","Uttam@gamil.com","System Admin");
        teamList.addTeam("Kumar","Kumar@gamil.com","Associate");

    }
}
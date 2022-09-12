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


public class PartnerDisplay extends Fragment {
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
        View view = inflater.inflate(R.layout.fragment_partner_display, container, false);

        //initiateData();
        initiateRecyclerView(view);

        return view;
    }

    private void initiateRecyclerView(View view) {
        recyclerView = view.findViewById(R.id.recyclerView_partnerDashboard);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(recyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new DashboardEmployeeAdapter(DashboardTeamList.getContactList());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void initiateData() {
        teamList.addTeam("aaaaaa","apple123@gamil.com","ios");
        teamList.addTeam("bbbbbb","apple123@gamil.com","ios");
        teamList.addTeam("aaaaaa","apple123@gamil.com","ios");
        teamList.addTeam("abbbb","apple123@gamil.com","ios");
        teamList.addTeam("aaaaaa","apple123@gamil.com","ios");
        teamList.addTeam("cccccc","apple123@gamil.com","ios");
        teamList.addTeam("aaaaaa","apple123@gamil.com","ios");
        teamList.addTeam("aaaaaa","apple123@gamil.com","ios");
        teamList.addTeam("aaaaaa","apple123@gamil.com","ios");
        teamList.addTeam("aaaaaa","apple123@gamil.com","ios");
        teamList.addTeam("aaaaaa","apple123@gamil.com","ios");
        teamList.addTeam("aaaaaa","apple123@gamil.com","ios");
        teamList.addTeam("aaaeaa","apple123@gamil.com","ios");
        teamList.addTeam("aaaaaa","apple123@gamil.com","ios");
        teamList.addTeam("aaaaaa","apple123@gamil.com","ios");
        teamList.addTeam("aaaaaa","apple123@gamil.com","ios");
        teamList.addTeam("aaaaaa","apple123@gamil.com","ios");
        teamList.addTeam("aaaaaa","apple123@gamil.com","ios");
        teamList.addTeam("eaaaaa","apple123@gamil.com","ios");
        teamList.addTeam("aaaaaa","apple123@gamil.com","ios");
        teamList.addTeam("bbbbbb","apple123@gamil.com","ios");

    }
}
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


public class ClientDisplay extends Fragment {

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
        View view = inflater.inflate(R.layout.fragment_client_display, container, false);

        initiateData();
        initiateRecyclerView(view);

        return view;
    }

    private void initiateRecyclerView(View view) {
        recyclerView = view.findViewById(R.id.recyclerView_clientDashboard);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(recyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new DashboardEmployeeAdapter(DashboardTeamList.getContactList());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void initiateData() {
        teamList.addTeam("aaaaaa","apple123@gamil.com","Harsha");
        teamList.addTeam("bbbbbb","apple123@gamil.com","Pavithra");
        teamList.addTeam("aaaaaa","apple123@gamil.com","Nithin");
        teamList.addTeam("abbbb","apple123@gamil.com","Vignesh");
        teamList.addTeam("aaaaaa","apple123@gamil.com","Harsha");
        teamList.addTeam("cccccc","apple123@gamil.com","Syed");
        teamList.addTeam("aaaaaa","apple123@gamil.com","Dileep");
        teamList.addTeam("aaaaaa","apple123@gamil.com","Fazil");
        teamList.addTeam("aaaaaa","apple123@gamil.com","Kumar");
        teamList.addTeam("aaaaaa","apple123@gamil.com","Prathisa");
        teamList.addTeam("aaaaaa","apple123@gamil.com","Prathisa");
        teamList.addTeam("aaaaaa","apple123@gamil.com","Varun");
        teamList.addTeam("aaaeaa","apple123@gamil.com","Swaroopa");
        teamList.addTeam("aaaaaa","apple123@gamil.com","Vihan");
        teamList.addTeam("aaaaaa","apple123@gamil.com","Srinivas");
        teamList.addTeam("aaaaaa","apple123@gamil.com","Rohit");
        teamList.addTeam("aaaaaa","apple123@gamil.com","tedart");
        teamList.addTeam("aaaaaa","apple123@gamil.com","Ladhakur");
        teamList.addTeam("eaaaaa","apple123@gamil.com","Woodwinds");
        teamList.addTeam("aaaaaa","apple123@gamil.com","Jashwanth");
        teamList.addTeam("bbbbbb","apple123@gamil.com","NIkhil");

    }
}
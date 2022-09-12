package com.ziroh.legalvault.dashboard;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.ziroh.legalvault.R;
import com.ziroh.legalvault.adapters.ManageTeamAdapter;
import com.ziroh.legalvault.datastorage.ManageTeamList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DashboardManageTeam#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DashboardManageTeam extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private ManageTeamAdapter adapter;
    private ManageTeamList teamList = new ManageTeamList();
    private ImageView team_dot;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DashboardManageTeam() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DashboardManageTeam.
     */
    // TODO: Rename and change types and number of parameters
    public static DashboardManageTeam newInstance(String param1, String param2) {
        DashboardManageTeam fragment = new DashboardManageTeam();
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

    @RequiresApi(api = Build.VERSION_CODES.N)

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard_manage_team, container, false);

        initiateData();
        initiateRecyclerView(view);

        EditText search=(EditText) view.findViewById(R.id.search);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void afterTextChanged(Editable editable) {
                adapter.getFilter().filter(editable);
            }
        });

        return view;
    }

    private void initiateRecyclerView(View view) {
        recyclerView = view.findViewById(R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(recyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new ManageTeamAdapter(ManageTeamList.getTeamList());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void initiateData() {
        teamList.addTeam("Ashiq Shibin","AshiqShibin@gamil.com");
        teamList.addTeam("Harsha K","Harsha@gamil.com");
        teamList.addTeam("Zamil","Zamil@gamil.com");
        teamList.addTeam("Prathab B","Prathab@gamil.com");
        teamList.addTeam("Akash Raj","Akash@gamil.com");
        teamList.addTeam("Prathisha","Prathisha@gamil.com");
        teamList.addTeam("Nithin","aNithin@gamil.com");
        teamList.addTeam("Vignesh Ram","Vignesh@gamil.com");
        teamList.addTeam("Mohammed","Mohammed@gamil.com");
        teamList.addTeam("Dilip Kumar","Dilip@gamil.com");
        teamList.addTeam("Faasil","Faasil@gamil.com");
        teamList.addTeam("Nippun","Nippun3@gamil.com");
        teamList.addTeam("Rajeev","Rajeev@gamil.com");
        teamList.addTeam("Lochana","Lochana@gamil.com");
        teamList.addTeam("Nikith","Nikith@gamil.com");
        teamList.addTeam("Teja","Teja@gamil.com");
        teamList.addTeam("Kavya","Kavya@gamil.com");
        teamList.addTeam("Visruth","Visruth@gamil.com");
        teamList.addTeam("Vikas","Vikas@gamil.com");
        teamList.addTeam("Uttam","Uttam@gamil.com");
        teamList.addTeam("Kumar","Kumar@gamil.com");

    }
}
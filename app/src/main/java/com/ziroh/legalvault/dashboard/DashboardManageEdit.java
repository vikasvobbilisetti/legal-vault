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
import com.ziroh.legalvault.adapters.ManageContactAdapter;
import com.ziroh.legalvault.datastorage.ManageContactList;
import com.ziroh.legalvault.datastorage.ManageContactList2;

public class DashboardManageEdit extends Fragment {

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerView recyclerView1;
    private LinearLayoutManager linearLayoutManager1;
    private ManageContactAdapter adapter;
    private ManageContactAdapter adapter2;
    private ManageContactList contactList=new ManageContactList();
    private ManageContactList2 contactList2=new ManageContactList2();
    private ImageView contact_dot;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard_manage_edit, container, false);

        initiateData();
        initiateRecyclerView(view);

        return view;
    }

    private void initiateRecyclerView(View view) {
        recyclerView = view.findViewById(R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(recyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView1 = view.findViewById(R.id.recyclerView2);
        linearLayoutManager1 = new LinearLayoutManager(getActivity());
        linearLayoutManager1.setOrientation(recyclerView1.VERTICAL);
        recyclerView1.setLayoutManager(linearLayoutManager1);
        adapter = new ManageContactAdapter(ManageContactList.getContactList());
        adapter2 = new ManageContactAdapter(ManageContactList2.getContactList());
        recyclerView.setAdapter(adapter);
        recyclerView1.setAdapter(adapter2);
        adapter.notifyDataSetChanged();
        adapter2.notifyDataSetChanged();
    }

    private void initiateData() {
        contactList.addContact("aaaaaa","apple123@gamil.com");
        contactList.addContact("bbbbbb","apple123@gamil.com");
        contactList.addContact("aaaaaa","apple123@gamil.com");
        contactList.addContact("abbbb","apple123@gamil.com");
        contactList.addContact("aaaaaa","apple123@gamil.com");
        contactList.addContact("bbbbbb","apple123@gamil.com");
        contactList.addContact("aaaaaa","apple123@gamil.com");
        contactList.addContact("abbbb","apple123@gamil.com");
        contactList.addContact("aaaaaa","apple123@gamil.com");
        contactList.addContact("bbbbbb","apple123@gamil.com");
        contactList.addContact("aaaaaa","apple123@gamil.com");
        contactList.addContact("abbbb","apple123@gamil.com");

        contactList2.addContact("aaaaaa","apple123@gamil.com");
        contactList2.addContact("bbbbbb","apple123@gamil.com");
        contactList2.addContact("aaaaaa","apple123@gamil.com");
        contactList2.addContact("abbbb","apple123@gamil.com");
        contactList2.addContact("aaaaaa","apple123@gamil.com");
        contactList2.addContact("bbbbbb","apple123@gamil.com");
        contactList2.addContact("aaaaaa","apple123@gamil.com");
        contactList2.addContact("abbbb","apple123@gamil.com");
        contactList2.addContact("aaaaaa","apple123@gamil.com");
        contactList2.addContact("bbbbbb","apple123@gamil.com");
        contactList2.addContact("aaaaaa","apple123@gamil.com");
        contactList2.addContact("abbbb","apple123@gamil.com");

    }
}
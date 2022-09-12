package com.ziroh.legalvault.dashboard;

import static com.ziroh.legalvault.dashboard.DashboardCreateTeam.admin_input;
import static com.ziroh.legalvault.dashboard.DashboardCreateTeam.email_input;
import static com.ziroh.legalvault.dashboard.DashboardCreateTeam.name_input;
import static com.ziroh.legalvault.dashboard.DashboardCreateTeam.temp_team;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.ziroh.legalvault.R;
import com.ziroh.legalvault.adapters.info_adapter;
import com.ziroh.legalvault.adapters.suggestion_adapter;
import com.ziroh.legalvault.datastorage.EmployeeList;
import com.ziroh.legalvault.datastorage.Team;
import com.ziroh.legalvault.datastorage.Team_List;


public class CreateTeamMembers extends Fragment {
    public String mem_name;
    public String t_name;
    public String id;
    public String admin;

    public static EditText name_input1;
    public static EditText email_input1;
    public static EditText admin_input1;
    public static EditText Member_input1;

    private RecyclerView admin_info_recycler;
    private RecyclerView admin_suggestion_recycler;
    private RecyclerView members_info_recycler;
    private RecyclerView members_suggestion_recycler;

    private LinearLayoutManager admin_info_linearLayoutManager;
    private LinearLayoutManager member_info_linearLayoutManager;
    private LinearLayoutManager member_suggestion_linearLayoutManager;

    private info_adapter admin_info_adapter;
    private info_adapter member_info_adapter;
    private suggestion_adapter member_suggestion_adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_team_members, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        name_input1 = (EditText) view.findViewById(R.id.name_input);
        email_input1 = (EditText) view.findViewById(R.id.email_input);
        admin_input1 = (EditText) view.findViewById(R.id.admin_input);
        Member_input1 = (EditText) view.findViewById(R.id.member_input);

        ImageView member_add = (ImageView) view.findViewById(R.id.member_add);

        CardView admin_suggestion_card = (CardView) view.findViewById(R.id.admins_suggestion_cardview);
        CardView members_suggestion_card = (CardView) view.findViewById(R.id.members_suggestion_cardview);

        admin_info_recycler = (RecyclerView) view.findViewById(R.id.admins_info_recycler1);
        admin_suggestion_recycler = (RecyclerView) view.findViewById(R.id.admins_suggestion_recycler);
        members_info_recycler = (RecyclerView) view.findViewById(R.id.members_recycler_view);
        members_suggestion_recycler = (RecyclerView) view.findViewById(R.id.members_suggestion_recycler);

        TextView admin_no_details = (TextView) view.findViewById(R.id.admin_no_details2);
        TextView member_no_details = (TextView) view.findViewById(R.id.member_no_details);

        TextView create = (TextView) view.findViewById(R.id.create);

        t_name = name_input.getText().toString();
        id = email_input.getText().toString();
        admin = admin_input.getText().toString();

        name_input.setText(t_name);
        email_input.setText(id);
        admin_input.setText(admin);

        name_input1.setText(t_name);
        email_input1.setText(id);
        admin_input1.setText(admin);

        admin_info_view(admin_suggestion_card, admin_info_recycler, admin_suggestion_recycler, admin_no_details);
        member_view(view, members_info_recycler, member_no_details);
        init_admin_info_recycler(view);
        init_member_suggestion_recycler(view);

        admin_input1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new DashboardCreateTeam());
            }
        });

        name_input1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new DashboardCreateTeam());
            }
        });

        email_input1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new DashboardCreateTeam());
            }
        });

        member_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp_team.setTeam_Name(name_input.getText().toString());
                temp_team.setSubmitter_Email_Id(email_input.getText().toString());
                temp_team.add_admin(admin_input.getText().toString());
                temp_team.add_member(Member_input1.getText().toString());
                member_view(view, members_info_recycler, member_no_details);
                init_member_suggestion_recycler(view);
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Team_List.addTeam(temp_team);
                System.out.println(Team_List.num_teams);
                name_input1.setText("");
                email_input1.setText("");
                admin_input1.setText("");
                Member_input1.setText("");
                temp_team = new Team();
                init_admin_info_recycler(view);
                init_member_info_recycler(view);
                replaceFragment(new DashboardCreateTeam());
            }
        });
    }


    private void replaceFragment(Fragment fragment){

        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,fragment).commit();
    }

    private void admin_info_view(CardView admin_suggestion, RecyclerView info, RecyclerView suggestion, TextView no_det){

        if (temp_team.admin_count>0) {
            admin_suggestion.setVisibility(View.INVISIBLE);
            info.setVisibility(View.VISIBLE);
            suggestion.setVisibility(View.INVISIBLE);
            no_det.setVisibility(View.INVISIBLE);
        } else {
            admin_suggestion.setVisibility(View.INVISIBLE);
            info.setVisibility(View.INVISIBLE);
            suggestion.setVisibility(View.INVISIBLE);
            no_det.setVisibility(View.VISIBLE);
        }

    }

    private void member_view(View view, RecyclerView info, TextView no_det) {

        if (temp_team.member_count > 0) {
            info.setVisibility(View.VISIBLE);
            no_det.setVisibility(View.INVISIBLE);
            init_member_info_recycler(view);
        }
        else {
            info.setVisibility(View.INVISIBLE);
            no_det.setVisibility(View.VISIBLE);
            init_member_info_recycler(view);
        }
        System.out.println("Number of teams members are: " + temp_team.member_count);

    }

    private void init_member_suggestion_recycler(View view) {
        member_suggestion_linearLayoutManager = new LinearLayoutManager(this.getContext());
        member_suggestion_linearLayoutManager.setOrientation(members_suggestion_recycler.VERTICAL);
        members_suggestion_recycler.setLayoutManager(member_suggestion_linearLayoutManager);
        member_suggestion_adapter = new suggestion_adapter(EmployeeList.getEmployeeList());
        members_suggestion_recycler.setAdapter(member_suggestion_adapter);
        member_suggestion_adapter.notifyDataSetChanged();
    }

    private void init_member_info_recycler(View view) {
        member_info_linearLayoutManager = new LinearLayoutManager(this.getContext());
        member_info_linearLayoutManager.setOrientation(members_info_recycler.VERTICAL);
        members_info_recycler.setLayoutManager(member_info_linearLayoutManager);
        member_info_adapter = new info_adapter(temp_team.getTeam_Member());
        members_info_recycler.setAdapter(member_info_adapter);
        member_info_adapter.notifyDataSetChanged();
    }

    private void init_admin_info_recycler(View view) {
        admin_info_linearLayoutManager = new LinearLayoutManager(this.getContext());
        admin_info_linearLayoutManager.setOrientation(admin_info_recycler.VERTICAL);
        admin_info_recycler.setLayoutManager(admin_info_linearLayoutManager);
        admin_info_adapter = new info_adapter(temp_team.getTeam_Admin());
        admin_info_recycler.setAdapter(admin_info_adapter);
        admin_info_adapter.notifyDataSetChanged();
    }

}
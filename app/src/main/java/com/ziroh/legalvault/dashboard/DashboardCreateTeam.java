package com.ziroh.legalvault.dashboard;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
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
import com.ziroh.legalvault.profile.ProfilePartnerEdit;


public class DashboardCreateTeam extends Fragment {

    private NavController navController;

    public static Team temp_team = new Team();
    public String Team_Name;
    public String Email_Id;
    public String Admin_Name;
    public String Member_Name;

    public static EditText name_input;
    public static EditText email_input;
    public static EditText admin_input;
    public static EditText Member_input;

    private RecyclerView admin_info_recycler;
    private RecyclerView admin_suggestion_recycler;
    private RecyclerView member_info_recycler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard_create_team, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        initiateData(view);
        name_input = (EditText) view.findViewById(R.id.name_input);
        email_input = (EditText) view.findViewById(R.id.email_input);
        admin_input = (EditText) view.findViewById(R.id.admin_input);
        Member_input = (EditText) view.findViewById(R.id.member_input);

        ImageView admin_add = (ImageView) view.findViewById(R.id.admin_add);
        ImageView member_add = (ImageView) view.findViewById(R.id.team_member_add);
        TextView admin_no_details = (TextView) view.findViewById(R.id.admin_no_details);
        TextView member_no_details = (TextView) view.findViewById(R.id.member_no_details);
        CardView admin_suggestion_card = (CardView) view.findViewById(R.id.admins_suggestion_cardview);
        admin_suggestion_recycler = (RecyclerView) view.findViewById(R.id.admins_suggestion_recycler);
        admin_info_recycler = (RecyclerView) view.findViewById(R.id.admin_recycler);
        member_info_recycler = (RecyclerView) view.findViewById(R.id.member_recycler);

        TextView create = (TextView) view.findViewById(R.id.create);

        try {
            name_input.setText(CreateTeamMembers.name_input1.getText().toString());
            email_input.setText(CreateTeamMembers.email_input1.getText().toString());
            admin_input.setText(CreateTeamMembers.admin_input1.getText().toString());
            Member_input.setText(CreateTeamMembers.Member_input1.getText().toString());
        }

        catch (Exception e) { }

        finally {

            Team_Name = name_input.getText().toString();
            Email_Id = email_input.getText().toString();
            Admin_Name = admin_input.getText().toString();

            admin_info_view(view, admin_suggestion_card, admin_info_recycler, admin_suggestion_recycler, admin_no_details);
            member_view(member_info_recycler, member_no_details);
            init_admin_suggestion_info_recycler(view);

            name_input.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    admin_info_view(view, admin_suggestion_card, admin_info_recycler, admin_suggestion_recycler,admin_no_details);
                }
            });

            email_input.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    admin_info_view(view, admin_suggestion_card, admin_info_recycler, admin_suggestion_recycler, admin_no_details);
                }
            });

            admin_input.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    admin_suggestion_view(admin_suggestion_card, admin_info_recycler, admin_suggestion_recycler, admin_no_details);
                }
            });

            admin_add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Team_Name = name_input.getText().toString();
                    Email_Id = email_input.getText().toString();
                    Admin_Name = admin_input.getText().toString();
                    temp_team.setTeam_Name(Team_Name);
                    temp_team.setSubmitter_Email_Id(Email_Id);
                    temp_team.add_admin(Admin_Name);
                    init_admin_info_recycler(view);
                }
            });

            Member_input.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Navigate to the next view
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,new CreateTeamMembers()).commit();
                }
            });

            member_add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!temp_team.getTeam_Member().contains(Member_input.getText().toString())){
                        Team_Name = name_input.getText().toString();
                        Email_Id = email_input.getText().toString();
                        Member_Name = Member_input.getText().toString();
                        temp_team.setTeam_Name(Team_Name);
                        temp_team.setSubmitter_Email_Id(Email_Id);
                        temp_team.add_member(Member_Name);
                        init_member_info_recycler(view);
                    }
                }
            });

            create.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Team_List.addTeam(temp_team);
                    System.out.println(Team_List.num_teams);
                    name_input.setText("");
                    email_input.setText("");
                    admin_input.setText("");
                    Member_input.setText("");
                    Team_Name = null;
                    Admin_Name = null;
                    Email_Id = null;
                    temp_team = new Team();
                    init_admin_suggestion_info_recycler(view);
                }
            });

        }
    }

    private void admin_info_view(View view, CardView admin_suggestion, RecyclerView info, RecyclerView suggestion, TextView no_det){

        if (temp_team.admin_count>0) {
            admin_suggestion.setVisibility(View.INVISIBLE);
            info.setVisibility(View.VISIBLE);
            suggestion.setVisibility(View.INVISIBLE);
            no_det.setVisibility(View.INVISIBLE);
            init_admin_info_recycler(view);
        } else {
            admin_suggestion.setVisibility(View.INVISIBLE);
            info.setVisibility(View.INVISIBLE);
            suggestion.setVisibility(View.INVISIBLE);
            no_det.setVisibility(View.VISIBLE);
        }

    }

    private void init_admin_info_recycler(View view) {
        LinearLayoutManager layoutManager =new LinearLayoutManager(this.getContext());
        layoutManager.setOrientation(admin_info_recycler.VERTICAL);
        admin_info_recycler.setLayoutManager(layoutManager);
        info_adapter info_adapter1 = new info_adapter(temp_team.getTeam_Admin());
        admin_info_recycler.setAdapter(info_adapter1);
        info_adapter1.notifyDataSetChanged();
    }

    private void init_admin_suggestion_info_recycler(View view) {
        LinearLayoutManager admin_suggestion_linearLayoutManager = new LinearLayoutManager(this.getContext());
        admin_suggestion_linearLayoutManager.setOrientation(admin_suggestion_recycler.VERTICAL);
        admin_suggestion_recycler.setLayoutManager(admin_suggestion_linearLayoutManager);
        suggestion_adapter admin_suggestion_adapter = new suggestion_adapter(EmployeeList.getEmployeeList());
        admin_suggestion_recycler.setAdapter(admin_suggestion_adapter);
        admin_suggestion_adapter.notifyDataSetChanged();
    }

    private void init_member_info_recycler(View view) {
        LinearLayoutManager layoutManager =new LinearLayoutManager(this.getContext());
        layoutManager.setOrientation(member_info_recycler.VERTICAL);
        member_info_recycler.setLayoutManager(layoutManager);
        info_adapter info_adapter2 = new info_adapter(temp_team.getTeam_Member());
        member_info_recycler.setAdapter(info_adapter2);
        info_adapter2.notifyDataSetChanged();
    }

    private void admin_suggestion_view(CardView admin_suggestion, RecyclerView info, RecyclerView suggestion, TextView no_det){
        admin_suggestion.setVisibility(View.VISIBLE);
        info.setVisibility(View.INVISIBLE);
        suggestion.setVisibility(View.VISIBLE);
        no_det.setVisibility(View.INVISIBLE);
    }

    private void member_view(RecyclerView info, TextView no_det) {
        if (temp_team.member_count > 0) {
            info.setVisibility(View.VISIBLE);
            no_det.setVisibility(View.INVISIBLE);
        }
        else {
            info.setVisibility(View.INVISIBLE);
            no_det.setVisibility(View.VISIBLE);
        }
    }

    private void initiateData(View view) {

        EmployeeList.addEmployee("Ashiq Shibin", "ashiq@straus.com");
        EmployeeList.addEmployee("Ashiq Shibin", "ashiq@straus.com");
        EmployeeList.addEmployee("Ashiq Shibin", "ashiq@straus.com");
        EmployeeList.addEmployee("Ashiq Shibin", "ashiq@straus.com");
        EmployeeList.addEmployee("Ashiq Shibin", "ashiq@straus.com");
        EmployeeList.addEmployee("Ashiq Shibin", "ashiq@straus.com");
        EmployeeList.addEmployee("Ashiq Shibin", "ashiq@straus.com");
        EmployeeList.addEmployee("Ashiq Shibin", "ashiq@straus.com");
        EmployeeList.addEmployee("Ashiq Shibin", "ashiq@straus.com");
        EmployeeList.addEmployee("Ashiq Shibin", "ashiq@straus.com");
        EmployeeList.addEmployee("Ashiq Shibin", "ashiq@straus.com");
        EmployeeList.addEmployee("Ashiq Shibin", "ashiq@straus.com");
        EmployeeList.addEmployee("Ashiq Shibin", "ashiq@straus.com");
        EmployeeList.addEmployee("Ashiq Shibin", "ashiq@straus.com");

    }

}
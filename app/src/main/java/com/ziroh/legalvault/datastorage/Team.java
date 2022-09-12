package com.ziroh.legalvault.datastorage;

import java.util.ArrayList;
import java.util.List;

public class Team {

    public String Team_Name;
    public String Submitter_Email_Id;
    public List<String> Team_Admin = new ArrayList<String>();
    public List<String> Team_Member = new ArrayList<String>();
    public int admin_count = 0;
    public int member_count = 0;

    public Team() {
        this.Team_Name = null;
        this.Submitter_Email_Id = null;
    }

    public Team(String team_Name, String submitter_Email_Id) {
        Team_Name = team_Name;
        Submitter_Email_Id = submitter_Email_Id;
    }


    public String getTeam_Name() {
        return Team_Name;
    }

    public void setTeam_Name(String team_Name) {
        Team_Name = team_Name;
    }

    public String getSubmitter_Email_Id() {
        return Submitter_Email_Id;
    }

    public void setSubmitter_Email_Id(String submitter_Email_Id) {
        Submitter_Email_Id = submitter_Email_Id;
    }

    public List<String> getTeam_Admin() {
        return Team_Admin;
    }

    public void add_admin(String admin){
        Team_Admin.add(admin);
        admin_count = admin_count + 1;
    }

    public void add_member(String member){
        Team_Member.add(member);
        member_count = member_count + 1;
    }

    public void setTeam_Admin(List<String> team_Admin) {
        Team_Admin = team_Admin;
    }

    public List<String> getTeam_Member() {
        return Team_Member;
    }

    public void setTeam_Member(List<String> team_Member) {
        Team_Member = team_Member;
    }
}

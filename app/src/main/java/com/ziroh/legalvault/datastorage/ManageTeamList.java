package com.ziroh.legalvault.datastorage;

import com.ziroh.legalvault.R;

import java.util.ArrayList;
import java.util.List;

public class ManageTeamList {

    public static List<ManageTeam> teamList = new ArrayList<>();

    public static void addTeam(String name, String email) {
        teamList.add(new ManageTeam(name, email, R.drawable.dashboard_manage_dots));
    }

    public static int getNumberOfTeam() {
        return teamList.size();
    }

    public static List<ManageTeam> getTeamList() {
        return teamList;
    }

}

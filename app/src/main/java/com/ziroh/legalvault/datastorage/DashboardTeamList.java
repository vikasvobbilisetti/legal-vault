package com.ziroh.legalvault.datastorage;

import com.ziroh.legalvault.R;

import java.util.ArrayList;
import java.util.List;

public class DashboardTeamList {

    public static List<Dashboard_employee_team> contactList = new ArrayList<>();

    public static void addTeam(String name, String email,String position) {
        contactList.add(new Dashboard_employee_team(name, email,position, R.drawable.square));
    }

    public static int getNumberOfContact() {
        return contactList.size();
    }

    public static List<Dashboard_employee_team> getContactList() {
        return contactList;
    }


}

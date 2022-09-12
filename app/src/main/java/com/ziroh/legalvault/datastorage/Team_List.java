package com.ziroh.legalvault.datastorage;

import java.util.ArrayList;
import java.util.List;

public class Team_List {

    public static List<com.ziroh.legalvault.datastorage.Team> Teams = new ArrayList<com.ziroh.legalvault.datastorage.Team>();
    public static int num_teams = 0;

    public static void addTeam(com.ziroh.legalvault.datastorage.Team team) {
        Teams.add(team);
        num_teams = num_teams + 1;
    }

    public static List<com.ziroh.legalvault.datastorage.Team> get_Teams(){
        return Teams;
    }

    public List<String> get_all_teams() {
        List<String> temp = new ArrayList<String>();
        for(com.ziroh.legalvault.datastorage.Team team : Teams) {
            temp.add(team.Team_Name);
        }
        return temp;
    }

    public int get_num_teams(){
        return Teams.size();
    }

}

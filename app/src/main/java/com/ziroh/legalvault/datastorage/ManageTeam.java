package com.ziroh.legalvault.datastorage;

public class ManageTeam {

    private String team_name;
    private String team_email;
    private int team_dot;

    public ManageTeam(String team_name, String team_email, int team_dot) {
        this.team_name = team_name;
        this.team_email = team_email;
        this.team_dot = team_dot;
    }

    public String getName() {
        return team_name;
    }

    public void setName(String name) {
        this.team_name = name;
    }

    public String getEmail_id() {
        return team_email;
    }

    public void setEmail_id(String email_id) {
        this.team_email = email_id;
    }

    public int getDelete() {
        return team_dot;
    }

    public void setDelete(int delete) {
        this.team_dot = delete;
    }

}

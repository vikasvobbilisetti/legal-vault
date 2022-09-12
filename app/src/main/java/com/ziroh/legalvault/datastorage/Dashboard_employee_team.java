package com.ziroh.legalvault.datastorage;

public class Dashboard_employee_team {

    private String employee_name;
    private String employee_email,employee_position;
    private int square_View;

    public Dashboard_employee_team(String employee_name, String employee_email, String employee_position, int square_View) {
        this.employee_name = employee_name;
        this.employee_email = employee_email;
        this.employee_position = employee_position;
        this.square_View = square_View;
    }

    public String getName() {
        return employee_name;
    }

    public void setName(String name) {
        this.employee_name = name;
    }

    public String getposition() {
        return employee_position;
    }

    public void setposition(String position) {
        this.employee_position = position;
    }

    public String getEmail_id() {
        return employee_email;
    }

    public void setEmail_id(String email_id) {
        this.employee_email = email_id;
    }

    public int getbox() {
        return square_View;
    }

    public void setbox(int box) {
        this.square_View = box;
    }
}

package com.ziroh.legalvault.datastorage;

public class ManageContact_G_S {

    private String contact_name;
    private String contact_email;
    private int contact_dot;

    public ManageContact_G_S(String contact_name, String contact_email, int contact_dot) {
        this.contact_name = contact_name;
        this.contact_email = contact_email;
        this.contact_dot = contact_dot;
    }

    public String getName() {
        return contact_name;
    }

    public void setName(String name) {
        this.contact_name = name;
    }

    public String getEmail_id() {
        return contact_email;
    }

    public void setEmail_id(String email_id) {
        this.contact_email = email_id;
    }

    public int getDelete() {
        return contact_dot;
    }

    public void setDelete(int delete) {
        this.contact_dot = delete;
    }

}

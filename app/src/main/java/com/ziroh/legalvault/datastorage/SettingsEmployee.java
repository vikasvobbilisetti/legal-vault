package com.ziroh.legalvault.datastorage;

public class SettingsEmployee {
    private String settingsEmployeeName;
    private String settingsEmployeeEmail;

    public SettingsEmployee(String name, String email) {
        this.settingsEmployeeName = name;
        this.settingsEmployeeEmail = email;
    }

    public String getSettingsEmployeeName() {
        return settingsEmployeeName;
    }

    public void setSettingsEmployeeName(String settingsEmployeeName) {
        this.settingsEmployeeName = settingsEmployeeName;
    }

    public String getSettingsEmployeeEmail() {
        return settingsEmployeeEmail;
    }

    public void setSettingsEmployeeEmail(String settingsEmployeeEmail) {
        this.settingsEmployeeEmail = settingsEmployeeEmail;
    }
}

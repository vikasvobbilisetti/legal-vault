package com.ziroh.legalvault.datastorage;

public class SettingsPartner {
    private String settingsPartnerName;
    private String settingsPartnerEmail;

    public SettingsPartner(String name, String email) {
        this.settingsPartnerName = name;
        this.settingsPartnerEmail = email;
    }

    public String getSettingsPartnerName() {
        return settingsPartnerName;
    }

    public void setSettingsPartnerName(String settingsPartnerName) {
        this.settingsPartnerName = settingsPartnerName;
    }

    public String getSettingsPartnerEmail() {
        return settingsPartnerEmail;
    }

    public void setSettingsPartnerEmail(String settingsPartnerEmail) {
        this.settingsPartnerEmail = settingsPartnerEmail;
    }
}

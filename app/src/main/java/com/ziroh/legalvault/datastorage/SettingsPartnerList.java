package com.ziroh.legalvault.datastorage;

import java.util.ArrayList;
import java.util.List;

public class SettingsPartnerList {

    public static List<SettingsPartner> settingsPartnerList = new ArrayList<>();

    public static void addSettingsEmployee(String name, String email) {
        settingsPartnerList.add(new SettingsPartner(name, email));
    }

    public static int getNumberOfSettingsPartner() {
        return settingsPartnerList.size();
    }

    public static List<SettingsPartner> getSettingsPartnerList() {
        return settingsPartnerList;
    }

}

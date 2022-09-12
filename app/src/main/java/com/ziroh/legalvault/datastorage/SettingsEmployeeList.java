package com.ziroh.legalvault.datastorage;

import java.util.ArrayList;
import java.util.List;

public class SettingsEmployeeList {

    public static List<SettingsEmployee> settingsEmployeeList = new ArrayList<>();

    public static void addSettingsEmployee(String name, String email) {
        settingsEmployeeList.add(new SettingsEmployee(name, email));
    }

    public static int getNumberOfSettingsEmployee() {
        return settingsEmployeeList.size();
    }

    public static List<SettingsEmployee> getSettingsEmployeeList() {
        return settingsEmployeeList;
    }
}

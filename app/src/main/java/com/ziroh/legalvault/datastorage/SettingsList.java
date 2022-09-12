package com.ziroh.legalvault.datastorage;

import com.ziroh.legalvault.R;

import java.util.ArrayList;
import java.util.List;

public class SettingsList {

    public static List<Settings> settingsList = new ArrayList<>();

    public static void addSetting(String name, String email) {
        settingsList.add(new Settings(R.drawable.ic_baseline_account_box_24, name, email, R.drawable.delete_vector));
    }

    public static int getNumberOfSetting() {
        return settingsList.size();
    }

    public static List<Settings> getSettingsList() {
        return settingsList;
    }
}

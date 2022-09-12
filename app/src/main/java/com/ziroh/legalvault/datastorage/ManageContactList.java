package com.ziroh.legalvault.datastorage;

import com.ziroh.legalvault.R;

import java.util.ArrayList;
import java.util.List;

public class ManageContactList {

    public static List<ManageContact_G_S> contactList = new ArrayList<>();

    public static void addContact(String name, String email) {
        contactList.add(new ManageContact_G_S(name, email, R.drawable.delete_vector));
    }

    public static int getNumberOfContact() {
        return contactList.size();
    }

    public static List<ManageContact_G_S> getContactList() {
        return contactList;
    }

}

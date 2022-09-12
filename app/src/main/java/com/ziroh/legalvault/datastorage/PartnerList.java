package com.ziroh.legalvault.datastorage;

import com.ziroh.legalvault.R;

import java.util.ArrayList;
import java.util.List;

public class PartnerList {
    public static List<Partner> partnerList = new ArrayList<>();;

    public static void addPartner(String name, String email) {
        partnerList.add(new Partner(name, email, R.drawable.delete_symbol));
    }

    public static int getNumberOfPartners() {
        return partnerList.size();
    }

    public static List<Partner> getPartnerList() {
        return partnerList;
    }
}

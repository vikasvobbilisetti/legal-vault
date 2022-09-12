package com.ziroh.legalvault.datastorage;

public class Partner {
    private String partnerName;
    private String partnerEmailID;
    private int partnerDeleteSymbol;

    public Partner(String name, String email_id, int delete) {
        this.partnerName = name;
        this.partnerEmailID = email_id;
        this.partnerDeleteSymbol = delete;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public String getPartnerEmailID() {
        return partnerEmailID;
    }

    public void setPartnerEmailID(String partnerEmailID) {
        this.partnerEmailID = partnerEmailID;
    }

    public int getPartnerDeleteSymbol() {
        return partnerDeleteSymbol;
    }

    public void setPartnerDeleteSymbol(int partnerDeleteSymbol) {
        this.partnerDeleteSymbol = partnerDeleteSymbol;
    }
}

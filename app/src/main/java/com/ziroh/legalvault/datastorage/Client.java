package com.ziroh.legalvault.datastorage;

public class Client {
    private String clientName;
    private String clientEmailID;
    private int clientDeleteSymbol;

    public Client(String name, String email_id, int delete) {
        this.clientName = name;
        this.clientEmailID = email_id;
        this.clientDeleteSymbol = delete;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientEmailID() {
        return clientEmailID;
    }

    public void setClientEmailID(String clientEmailID) {
        this.clientEmailID = clientEmailID;
    }

    public int getClientDeleteSymbol() {
        return clientDeleteSymbol;
    }

    public void setClientDeleteSymbol(int clientDeleteSymbol) {
        this.clientDeleteSymbol = clientDeleteSymbol;
    }
}

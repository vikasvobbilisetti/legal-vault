package com.ziroh.legalvault.datastorage;

import com.ziroh.legalvault.R;

import java.util.ArrayList;
import java.util.List;

public class ClientList {
    public static List<Client> clientList = new ArrayList<>();;

    public static void addClient(String name, String email) {
        clientList.add(new Client(name, email, R.drawable.delete_symbol));
    }

    public static void removeClient(int position) {
        clientList.remove(position);
    }

    public static int getNumberOfClients() {
        return clientList.size();
    }

    public static List<Client> getClientList() {
        return clientList;
    }
}

package com.example.gamingcafe.model;

import com.example.gamingcafe.util.ClientLevel;

import java.time.LocalDate;

public class Client extends User implements Discount {
    private boolean member;
    private ClientLevel clientLevel;
    private String gamerTag;

    /* ------------------------------ KONSTRUKTORI ------------------------------ */

    public Client(Integer id, LocalDate birthday, String firstName, String lastName, String email, String password, Boolean member, ClientLevel clientLevel, String gamerTag) {
        super(id, birthday, firstName, lastName, email, password);
        this.member = member;
        this.clientLevel = clientLevel;
        this.gamerTag = gamerTag;
    }

    /* ------------------------------ SETTERI ------------------------------ */


    public void setMember(Boolean member) {
        this.member = member;
    }

    public void setClientLevel(ClientLevel clientLevel) {
        this.clientLevel = clientLevel;
    }

    public void setGamerTag(String gamerTag) { this.gamerTag = gamerTag; }

    /* ------------------------------ GETTERI ------------------------------ */

    public Boolean getMember() {
        return member;
    }

    public ClientLevel getClientLevel() {
        return clientLevel;
    }

    public String getGamerTag() { return gamerTag; }

    /* ------------------------------ METODE ------------------------------ */

    // TODO: Implement necessary methods


    @Override
    public void calculateDiscount() {}
}

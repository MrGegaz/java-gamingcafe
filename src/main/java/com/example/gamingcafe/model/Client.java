package com.example.gamingcafe.model;

import com.example.gamingcafe.util.ClientLevel;

import java.util.Date;

public class Client extends User {
    private Date birthday;
    private Boolean member;
    private ClientLevel clientLevel;
    private String gamerTag;

    /* ------------------------------ KONSTRUKTORI ------------------------------ */

    public Client(Integer id, Integer age, String firstName, String lastName, String email, String password, Date birthday, Boolean member, ClientLevel clientLevel,  String gamerTag) {
        super(id, age, firstName, lastName, email, password);
        this.birthday = birthday;
        this.member = member;
        this.clientLevel = clientLevel;
        this.gamerTag = gamerTag;
    }

    /* ------------------------------ SETTERI ------------------------------ */

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setMember(Boolean member) {
        this.member = member;
    }

    public void setClientLevel(ClientLevel clientLevel) {
        this.clientLevel = clientLevel;
    }

    public void setGamerTag(String gamerTag) { this.gamerTag = gamerTag; }

    /* ------------------------------ GETTERI ------------------------------ */

    public Date getBirthday() {
        return birthday;
    }

    public Boolean getMember() {
        return member;
    }

    public ClientLevel getClientLevel() {
        return clientLevel;
    }

    public String getGamerTag() { return gamerTag; }

    /* ------------------------------ METODE ------------------------------ */

    // TODO: Implement necessary methods
}

package com.example.gamingcafe.model;

import java.util.Date;

public class Client extends User {
    private Date birthday;
    private Boolean member;
    private Integer level;
    private String gamerTag;

    /* ------------------------------ KONSTRUKTORI ------------------------------ */

    public Client(Integer id, Integer age, String firstName, String lastName, String email, String password, Date birthday, Boolean member, Integer level,  String gamerTag) {
        super(id, age, firstName, lastName, email, password);
        this.birthday = birthday;
        this.member = member;
        this.level = level;
        this.gamerTag = gamerTag;
    }

    /* ------------------------------ SETTERI ------------------------------ */

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setMember(Boolean member) {
        this.member = member;
    }

    public void setLevel(Integer level) { this.level = level; }

    public void setGamerTag(String gamerTag) { this.gamerTag = gamerTag; }

    /* ------------------------------ GETTERI ------------------------------ */

    public Date getBirthday() {
        return birthday;
    }

    public Boolean getMember() {
        return member;
    }

    public Integer getLevel() { return level; }

    public String getGamerTag() { return gamerTag; }

    /* ------------------------------ METODE ------------------------------ */

    // TODO: Implement necessary methods
}

package com.example.gamingcafe.model;

import java.time.LocalDate;
import java.util.UUID;

public abstract class User {
    private UUID id;
    private LocalDate birthday;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    /* ------------------------------ KONSTRUKTORI ------------------------------ */

    public User(UUID id, LocalDate birthday, String firstName, String lastName, String email, String password) {
        this.id = id;
        this.birthday = birthday;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    /* ------------------------------ SETTERI ------------------------------ */

    public void setId(UUID id) {
        this.id = id;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /* ------------------------------ GETTERI ------------------------------ */

    public UUID getId() {
        return id;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    /* ------------------------------ METODE ------------------------------ */

    @Override
    public String toString() {
        return "User [id=" + id + ", age=" + birthday + ", firstName=" + firstName
                + ", lastName=" + lastName + ", email=" + email + ", password="
                + password + "]";
    }
}

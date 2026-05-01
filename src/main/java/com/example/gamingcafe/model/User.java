package com.example.gamingcafe.model;

public abstract class User {
    private Integer id;
    private Integer age;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;

    /* ------------------------------ KONSTRUKTORI ------------------------------ */

    public User(Integer id, Integer age, String firstName, String lastName, String email, String password, String role) {
        this.id = id;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    /* ------------------------------ SETTERI ------------------------------ */

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public void setRole(String role) {
        this.role = role;
    }

    /* ------------------------------ GETTERI ------------------------------ */

    public Integer getId() {
        return id;
    }

    public Integer getAge() {
        return age;
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

    public String getRole() {
        return role;
    }

    /* ------------------------------ METODE ------------------------------ */

    @Override
    public String toString() {
        return "User [id=" + id + ", age=" + age + ", firstName=" + firstName
                + ", lastName=" + lastName + ", email=" + email + ", password="
                + password + ", role=" + role + "]";
    }
}

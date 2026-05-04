package com.example.gamingcafe.model;

import com.example.gamingcafe.util.StaffRole;

import java.util.Date;

public class Staff extends User {
    private StaffRole staffRole;
    private Double salary;

    // TODO: Finish this Staff class

    /* ------------------------------ KONSTRUKTORI ------------------------------ */

    public Staff(Integer id, Date birthday, String firstName, String lastName, String email, String password, StaffRole staffRole, Double salary) {
        super(id, birthday, firstName, lastName, email, password);
        this.staffRole = staffRole;
        this.salary = salary;
    }
    /* ------------------------------ SETTERI ------------------------------ */

    public void setStaffRole(StaffRole staffRole) {
        this.staffRole = staffRole;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    /* ------------------------------ GETTERI ------------------------------ */

    public StaffRole getStaffRole() {
        return staffRole;
    }

    public Double getSalary() {
        return salary;
    }

    /* ------------------------------ METODE ------------------------------ */

    // TODO: Implement necessary methods
}

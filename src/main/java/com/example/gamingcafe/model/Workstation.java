package com.example.gamingcafe.model;

import java.util.List;
import java.util.UUID;

public abstract class Workstation implements Maintainable {
    private UUID id;
    private String name;
    private Double pricePerHour;
    private Boolean isOccupied;
    private User currentUser;
    private List<String> games;

    /* ------------------------------ KONSTRUKTORI ------------------------------ */

    public Workstation(UUID id, String name, Double pricePerHour, Boolean isOccupied, User currentUser,  List<String> games) {
        this.id = id;
        this.name = name;
        this.pricePerHour = pricePerHour;
        this.isOccupied = isOccupied;
        this.currentUser = currentUser;
        this.games = games;
    }

    /* ------------------------------ SETTERI ------------------------------ */

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPricePerHour(Double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public void setOccupied(Boolean occupied) {
        isOccupied = occupied;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public void setGames(List<String> games) {
        this.games = games;
    }

    /* ------------------------------ GETTERI ------------------------------ */

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPricePerHour() {
        return pricePerHour;
    }

    public Boolean getOccupied() {
        return isOccupied;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public List<String> getGames() {
        return games;
    }

    /* ------------------------------ METODE ------------------------------ */

    // TODO: Implement method for workstation reservation. Create an interface for that?
}

package com.example.gamingcafe.model;

public abstract class Workstation {
    private Integer id;
    private String name;
    private Float pricePerHour;
    private Boolean isOccupied;
    private String[] games;

    /* ------------------------------ KONSTRUKTORI ------------------------------ */

    public Workstation(Integer id, String name, Float pricePerHour, Boolean isOccupied,  String[] games) {
        this.id = id;
        this.name = name;
        this.pricePerHour = pricePerHour;
        this.isOccupied = isOccupied;
        this.games = games;
    }

    /* ------------------------------ SETTERI ------------------------------ */

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPricePerHour(Float pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public void setOccupied(Boolean occupied) {
        isOccupied = occupied;
    }

    public void setGames(String[] games) {
        this.games = games;
    }

    /* ------------------------------ GETTERI ------------------------------ */

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Float getPricePerHour() {
        return pricePerHour;
    }

    public Boolean getOccupied() {
        return isOccupied;
    }

    public String[] getGames() {
        return games;
    }

    /* ------------------------------ METODE ------------------------------ */

    // TODO: Implement method for workstation reservation. Create an interface for that?
}

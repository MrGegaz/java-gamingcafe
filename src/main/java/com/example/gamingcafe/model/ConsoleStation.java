package com.example.gamingcafe.model;

import java.util.List;
import java.util.UUID;

public class ConsoleStation extends Workstation {
    private String consoleType;
    private Integer controllersCount;


    /* ------------------------------ KONSTRUKTORI ------------------------------ */

    public ConsoleStation(UUID id, String name, Double pricePerHour, Boolean isOccupied, User currentUser, List<String> games, String consoleType, Integer controllersCount) {
        super(id, name, pricePerHour, isOccupied, currentUser, games);
        this.consoleType = consoleType;
        this.controllersCount = controllersCount;
    }

    /* ------------------------------ SETTERI ------------------------------ */

    public void setConsoleType(String consoleType) {
        this.consoleType = consoleType;
    }

    public void setControlersCount(Integer controllersCount) {
        this.controllersCount = controllersCount;
    }

    /* ------------------------------ GETTERI ------------------------------ */

    public String getConsoleType() {
        return consoleType;
    }

    public Integer getControlersCount() {
        return controllersCount;
    }

    /* ------------------------------ METODE ------------------------------ */

    // TODO: Implement method for workstation reservation. Abstract class Workstation

    @Override
    public void performCleaning() {

    }

    @Override
    public void performMaintenance() {

    }
}

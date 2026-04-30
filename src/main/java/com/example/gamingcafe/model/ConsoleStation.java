package com.example.gamingcafe.model;

public class ConsoleStation extends Workstation {
    String consoleType;
    Integer controlersCount;


    /* ------------------------------ KONSTRUKTORI ------------------------------ */

    public ConsoleStation(Integer id, String name, Float pricePerHour, Boolean isOccupied, String[] games, String consoleType, Integer controlersNumber) {
        super(id, name, pricePerHour, isOccupied, games);
        this.consoleType = consoleType;
        this.controlersCount = controlersNumber;
    }

    /* ------------------------------ SETTERI ------------------------------ */

    public void setConsoleType(String consoleType) {
        this.consoleType = consoleType;
    }

    public void setControlersCount(Integer controlersCount) {
        this.controlersCount = controlersCount;
    }

    /* ------------------------------ GETTERI ------------------------------ */

    public String getConsoleType() {
        return consoleType;
    }

    public Integer getControlersCount() {
        return controlersCount;
    }

    /* ------------------------------ METODE ------------------------------ */

    // TODO: Implement method for workstation reservation. Abstract class Workstation
}

package com.example.gamingcafe.model;

public class VRStation extends Workstation{
    Integer headsetCount;

    /* ------------------------------ KONSTRUKTORI ------------------------------ */

    public VRStation(Integer id, String name, Float pricePerHour, Boolean isOccupied, String[] games, Integer headsetCount) {
        super(id, name, pricePerHour, isOccupied, games);
        this.headsetCount = headsetCount;
    }

    /* ------------------------------ SETTERI ------------------------------ */

    public void setHeadsetCount(Integer headsetCount) {
        this.headsetCount = headsetCount;
    }

    /* ------------------------------ GETTERI ------------------------------ */

    public Integer getHeadsetCount() {
        return headsetCount;
    }

    /* ------------------------------ METODE ------------------------------ */

    // TODO: Implement method for workstation reservation. Abstract class Workstation
}

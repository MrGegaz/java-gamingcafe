package com.example.gamingcafe.model;

import java.util.List;

public class VRStation extends Workstation{
    private Integer headsetCount;

    /* ------------------------------ KONSTRUKTORI ------------------------------ */

    public VRStation(Integer id, String name, Double pricePerHour, Boolean isOccupied, User currentUser, List<String> games, Integer headsetCount) {
        super(id, name, pricePerHour, isOccupied, currentUser, games);
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

    @Override
    public void performCleaning() {

    }

    @Override
    public void performMaintenacne() {

    }
}

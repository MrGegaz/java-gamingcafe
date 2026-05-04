package com.example.gamingcafe.model;

import java.util.List;
import java.util.UUID;

public class DesktopStation extends Workstation {
    private String gpu;
    private String cpu;
    private String ram;

    /* ------------------------------ KONSTRUKTORI ------------------------------ */

    public DesktopStation(UUID id, String name, Double pricePerHour, Boolean isOccupied, User currentUser, List<String> games, String gpu, String cpu, String ram) {
        super(id, name, pricePerHour, isOccupied, currentUser, games);
        this.gpu = gpu;
        this.cpu = cpu;
        this.ram = ram;
    }

    /* ------------------------------ SETTERI ------------------------------ */

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    /* ------------------------------ GETTERI ------------------------------ */

    public String getGpu() {
        return gpu;
    }

    public String getCpu() {
        return cpu;
    }

    public String getRam() {
        return ram;
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

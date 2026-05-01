package com.example.gamingcafe.model;

public class DesktopStation extends Workstation {
    private String gpu;
    private String cpu;
    private String ram;

    /* ------------------------------ KONSTRUKTORI ------------------------------ */

    public DesktopStation(Integer id, String name, Float pricePerHour, Boolean isOccupied, String[] games, String gpu, String cpu, String ram) {
        super(id, name, pricePerHour, isOccupied, games);
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
}

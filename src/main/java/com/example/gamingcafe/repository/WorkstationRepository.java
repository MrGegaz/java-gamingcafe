package com.example.gamingcafe.repository;

import com.example.gamingcafe.model.Workstation;

import java.util.List;

public interface WorkstationRepository {
    void saveWorkstation(Workstation workstation);
    void updateWorkstation(Workstation workstation);
    void deleteWorkstation(Workstation workstation);
    Workstation getWorkstation(String username);
    List<Workstation> findAllWorkstations();

    // TODO: Add more as needed
}

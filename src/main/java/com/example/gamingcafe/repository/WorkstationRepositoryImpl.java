package com.example.gamingcafe.repository;

import com.example.gamingcafe.model.Workstation;

import java.util.List;

public class WorkstationRepositoryImpl implements WorkstationRepository {

    @Override
    public void saveWorkstation(Workstation workstation) {
        // TODO:
        // 1. connection from Singleton (DatabaseManager)
        // 2. Make SQL query (ex. INSERT INTO...)
        // 3. Execute
    }

    @Override
    public void updateWorkstation(Workstation workstation) {

    }

    @Override
    public void deleteWorkstation(Workstation workstation) {

    }

    @Override
    public Workstation getWorkstation(String username) {
        return null;
    }

    @Override
    public List<Workstation> findAllWorkstations() {
        return List.of();
    }
}

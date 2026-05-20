package com.example.gamingcafe.repository;

import com.example.gamingcafe.model.*;
import com.example.gamingcafe.util.DatabaseManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.UUID;

public class WorkstationRepositoryImpl implements WorkstationRepository {

    @Override
    public void saveWorkstation(Workstation workstation) {
        String sql = """
                INSERT INTO workstations
                    (id, name, type, price_per_hour, is_occupied, current_user_id,
                     gpu, cpu, ram, console_type, controllers_count, headset_count)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;

        try (PreparedStatement stmt = DatabaseManager.getInstance().getConnection().prepareStatement(sql)) {
            stmt.setObject(1, UUID.randomUUID());
            stmt.setString(2, workstation.getName());
            stmt.setString(3, resolveType(workstation));
            stmt.setDouble(4, workstation.getPricePerHour());
            stmt.setBoolean(5, workstation.getOccupied());
            setCurrentUser(stmt, 6, workstation.getCurrentUser());

            // Set type specific columns to null
            stmt.setNull(7,  Types.VARCHAR);
            stmt.setNull(8,  Types.VARCHAR);
            stmt.setNull(9,  Types.VARCHAR);
            stmt.setNull(10, Types.VARCHAR);
            stmt.setNull(11, Types.INTEGER);
            stmt.setNull(12, Types.INTEGER);

            // Set only what the type has
            switch (workstation) {
                case DesktopStation d -> {
                    stmt.setString(7, d.getGpu());
                    stmt.setString(8, d.getCpu());
                    stmt.setString(9, d.getRam());
                }
                case ConsoleStation c -> {
                    stmt.setString(10, c.getConsoleType());
                    stmt.setInt(11, c.getControlersCount());
                }
                case VRStation v -> stmt.setInt(12, v.getHeadsetCount());
                default -> {}
            }

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to save workstation: " + e.getMessage());
        }
    }

    @Override
    public void updateWorkstation(Workstation workstation) {
        String sql = """
                UPDATE workstations SET
                    name = ?, type = ?, price_per_hour = ?, is_occupied = ?, current_user_id = ?,
                    gpu = ?, cpu = ?, ram = ?, console_type = ?, controllers_count = ?, headset_count = ?
                WHERE id = ?
                """;

        try (PreparedStatement stmt = DatabaseManager.getInstance().getConnection().prepareStatement(sql)) {
            stmt.setString(1, workstation.getName());
            stmt.setString(2, resolveType(workstation));
            stmt.setDouble(3, workstation.getPricePerHour());
            stmt.setBoolean(4, workstation.getOccupied());
            setCurrentUser(stmt, 5, workstation.getCurrentUser());

            // Set type specific columns to null
            stmt.setNull(6,  Types.VARCHAR);
            stmt.setNull(7,  Types.VARCHAR);
            stmt.setNull(8,  Types.VARCHAR);
            stmt.setNull(9,  Types.VARCHAR);
            stmt.setNull(10, Types.INTEGER);
            stmt.setNull(11, Types.INTEGER);

            // Set only what the type has
            switch (workstation) {
                case DesktopStation d -> {
                    stmt.setString(6, d.getGpu());
                    stmt.setString(7, d.getCpu());
                    stmt.setString(8, d.getRam());
                }
                case ConsoleStation c -> {
                    stmt.setString(9, c.getConsoleType());
                    stmt.setInt(10, c.getControlersCount());
                }
                case VRStation v -> stmt.setInt(11, v.getHeadsetCount());
                default -> {
                }
            }

            stmt.setObject(12, workstation.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to update workstation: " + e.getMessage());
        }
    }

    @Override
    public void deleteWorkstation(Workstation workstation) {
        String sql = "DELETE FROM workstations WHERE id = ?";

        try (PreparedStatement stmt = DatabaseManager.getInstance().getConnection().prepareStatement(sql)) {
            stmt.setObject(1, workstation.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to delete workstation: " + e.getMessage());
        }
    }

    @Override
    public Workstation getWorkstation(String name) {
        String sql = "SELECT * FROM workstations WHERE name = ?";

        try (PreparedStatement stmt = DatabaseManager.getInstance().getConnection().prepareStatement(sql)) {
            stmt.setString(1, name);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapToWorkstation(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to fetch workstation: " + e.getMessage());
        }
        return null;
    }

    @Override
    public ObservableList<Workstation> findAllWorkstations() {
        ObservableList<Workstation> result = FXCollections.observableArrayList();
        String sql = "SELECT * FROM workstations";

        try (PreparedStatement stmt = DatabaseManager.getInstance().getConnection().prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                result.add(mapToWorkstation(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to fetch workstations: " + e.getMessage());
        }
        return result;
    }

    /* ------------------------------ HELPERS ------------------------------ */

    private String resolveType(Workstation workstation) {
        return switch (workstation) {
            case DesktopStation desktop -> "DESKTOP";
            case ConsoleStation console -> "CONSOLE";
            case VRStation vrstation -> "VR";
            default -> throw new IllegalArgumentException("Unknown workstation type");
        };
    }

    private void setCurrentUser(PreparedStatement stmt, int paramIndex, User user) throws SQLException {
        if (user != null) {
            stmt.setObject(paramIndex, user.getId());
        } else {
            stmt.setNull(paramIndex, Types.OTHER);
        }
    }

    private Workstation mapToWorkstation(ResultSet rs) throws SQLException {
        UUID id = UUID.fromString(rs.getString("id"));
        String name = rs.getString("name");
        Double price = rs.getDouble("price_per_hour");
        Boolean occupied = rs.getBoolean("is_occupied");

        return switch (rs.getString("type")) {
            case "DESKTOP" -> new DesktopStation(id, name, price, occupied, null,
                    List.of(), rs.getString("gpu"), rs.getString("cpu"), rs.getString("ram"));
            case "CONSOLE" -> new ConsoleStation(id, name, price, occupied, null,
                    List.of(), rs.getString("console_type"), rs.getInt("controllers_count"));
            case "VR"      -> new VRStation(id, name, price, occupied, null,
                    List.of(), rs.getInt("headset_count"));
            default -> throw new IllegalStateException("Unknown type: " + rs.getString("type"));
        };
    }
}

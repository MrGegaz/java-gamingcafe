package com.example.gamingcafe.repository;

import com.example.gamingcafe.model.Client;
import com.example.gamingcafe.model.ClientLevel;
import com.example.gamingcafe.model.Staff;
import com.example.gamingcafe.model.StaffRole;
import com.example.gamingcafe.model.User;
import com.example.gamingcafe.util.DatabaseManager;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserRepositoryImpl implements UserRepository {

    @Override
    public void saveUser(User user) {
        String sql = """
                INSERT INTO users
                    (id, user_type, first_name, last_name, email, password, birthday,
                     gamer_tag, is_member, client_level, staff_role, salary)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;

        try (PreparedStatement stmt = DatabaseManager.getInstance().getConnection().prepareStatement(sql)) {
            stmt.setObject(1, user.getId());
            stmt.setString(2, resolveType(user));
            stmt.setString(3, user.getFirstName());
            stmt.setString(4, user.getLastName());
            stmt.setString(5, user.getEmail());
            stmt.setString(6, user.getPassword());
            stmt.setObject(7, user.getBirthday());

            stmt.setNull(8, Types.VARCHAR);
            stmt.setNull(9, Types.BOOLEAN);
            stmt.setNull(10, Types.VARCHAR);
            stmt.setNull(11, Types.VARCHAR);
            stmt.setNull(12, Types.NUMERIC);

            switch (user) {
                case Client client -> {
                    stmt.setString(8, client.getGamerTag());
                    stmt.setObject(9, client.getMember());
                    stmt.setString(10, client.getClientLevel().name());
                }
                case Staff staff -> {
                    stmt.setString(11, staff.getStaffRole().name());
                    stmt.setDouble(12, staff.getSalary());
                }
                default -> {}
            }

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to save user: " + e.getMessage());
        }
    }

    @Override
    public void updateUser(User user) {
        String sql = """
                UPDATE users SET
                    user_type = ?, first_name = ?, last_name = ?, email = ?, password = ?, birthday = ?,
                    gamer_tag = ?, is_member = ?, client_level = ?, staff_role = ?, salary = ?
                WHERE id = ?
                """;

        try (PreparedStatement stmt = DatabaseManager.getInstance().getConnection().prepareStatement(sql)) {
            stmt.setString(1, resolveType(user));
            stmt.setString(2, user.getFirstName());
            stmt.setString(3, user.getLastName());
            stmt.setString(4, user.getEmail());
            stmt.setString(5, user.getPassword());
            stmt.setObject(6, user.getBirthday());

            stmt.setNull(7, Types.VARCHAR);
            stmt.setNull(8, Types.BOOLEAN);
            stmt.setNull(9, Types.VARCHAR);
            stmt.setNull(10, Types.VARCHAR);
            stmt.setNull(11, Types.NUMERIC);

            switch (user) {
                case Client client -> {
                    stmt.setString(7, client.getGamerTag());
                    stmt.setObject(8, client.getMember());
                    stmt.setString(9, client.getClientLevel().name());
                }
                case Staff staff -> {
                    stmt.setString(10, staff.getStaffRole().name());
                    stmt.setDouble(11, staff.getSalary());
                }
                default -> {}
            }

            stmt.setObject(12, user.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to update user: " + e.getMessage());
        }
    }

    @Override
    public void deleteUser(User user) {
        String sql = "DELETE FROM users WHERE id = ?";

        try (PreparedStatement stmt = DatabaseManager.getInstance().getConnection().prepareStatement(sql)) {
            stmt.setObject(1, user.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to delete user: " + e.getMessage());
        }
    }

    @Override
    public User getUser(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";

        try (PreparedStatement stmt = DatabaseManager.getInstance().getConnection().prepareStatement(sql)) {
            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapToUser(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to fetch user: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<User> findAllUsers() {
        String sql = "SELECT * FROM users";
        List<User> users = new ArrayList<>();

        try (PreparedStatement stmt = DatabaseManager.getInstance().getConnection().prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                users.add(mapToUser(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to fetch users: " + e.getMessage());
        }
        return users;
    }

    /* ------------------------------ HELPERS ------------------------------ */

    private String resolveType(User user) {
        return switch (user) {
            case Client c -> "CLIENT";
            case Staff s -> "STAFF";
            default -> throw new IllegalArgumentException("Unknown user type");
        };
    }

    private User mapToUser(ResultSet rs) throws SQLException {
        UUID id = UUID.fromString(rs.getString("id"));
        Date sqlDate = rs.getDate("birthday");
        LocalDate birthday = sqlDate != null ? sqlDate.toLocalDate() : null;
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        String email = rs.getString("email");
        String password = rs.getString("password");

        return switch (rs.getString("user_type")) {
            case "CLIENT" -> new Client(
                    id, birthday, firstName, lastName, email, password,
                    rs.getBoolean("is_member"),
                    ClientLevel.valueOf(rs.getString("client_level")),
                    rs.getString("gamer_tag")
            );
            case "STAFF" -> new Staff(
                    id, birthday, firstName, lastName, email, password,
                    StaffRole.valueOf(rs.getString("staff_role")),
                    rs.getDouble("salary")
            );
            default -> throw new IllegalStateException("Unknown type: " + rs.getString("user_type"));
        };
    }
}
package org.keyin.user;

import org.keyin.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Hello! I am the UserDAO class. I am responsible for handling all the database operations related to the User entity.
// I have a method called createNewUser that takes a User object as an argument and inserts it into the database.
// I have a method called getAllUsers that retrieves all the users from the database and prints them to the console.
// I have a method called getUserByUsername that retrieves a user from the database based on the username provided.
// I am a friend of the User class and I work closely with the DatabaseConnection class to establish a connection to the database.
// I am a good example of the Data Access Object (DAO) design pattern.

public class UserDAO {

    public void createNewUser(User user) {
        String sql = "INSERT INTO public.users(\n" +
                "\t username, email, password, role, sector)\n" +
                "\tVALUES (?, ?, ?, ?, ?);";

        try(Connection connection = DatabaseConnection.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getRole());
            preparedStatement.setString(5, user.getSector());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    public void getAllUsers() throws SQLException {
        ResultSet rs = null;
        String sql = "SELECT * FROM users";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            rs = pstmt.executeQuery();
            System.out.println("Users in the database");
            while (rs.next()) {
                int user_id = rs.getInt("user_id");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String role = rs.getString("role");
                String sector = rs.getString("sector");

                System.out.println("-------------------------------");
                System.out.println();
                System.out.println("Username: " + username);
                System.out.println("Email: " + email);
                System.out.println("Password: " + password);
                System.out.println("Role: " + role);
                System.out.println("Sector: " + sector);
                System.out.println();
                System.out.println("------------------------------------");

            }

        };
    }

    public User getUserByUsername(String username) throws SQLException {
        String sql = "SELECT * FROM users WHERE username = ?";
        try(Connection conn = DatabaseConnection.getConnection()){
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, username);
            try (ResultSet rs = preparedStatement.executeQuery()){
                if (rs.next()) {
                    return new User(
                            rs.getInt("user_id"),
                            rs.getString("username"),
                            rs.getString("email"),
                            rs.getString("password"),
                            rs.getString("role"),
                            rs.getString("sector")

                    );
                }
            }
        }
        return null;
    }






}

package com.besant.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.besant.model.User;
import com.besant.utils.DatabaseConnection;

public class UserDAO {

    public static Connection getConnection() throws SQLException {
        // Database connection logic (Assuming you already have a DatabaseConnection class)
        return DatabaseConnection.getConnection();
    }

    // Method to retrieve all users
    public List<User> getAllUsers() throws SQLException {
        List<User> userList = new ArrayList<>();
        String query = "SELECT * FROM user_db.users;";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");

                // Create User object and add it to the list
                User user = new User(id, username, email, password);
                userList.add(user);
               System.out.println(user);
            }
        }
        return userList;
    }
}

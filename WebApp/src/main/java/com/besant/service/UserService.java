package com.besant.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.besant.model.User;
import com.besant.utils.DatabaseConnection;

public class UserService {
	private static final String INSERT_USER_SQL = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";

	public void registerUser(HttpServletRequest request) {
		try (Connection connection = DatabaseConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)) {
			preparedStatement.setString(1, request.getParameter("username"));
			preparedStatement.setString(2, request.getParameter("email"));
			preparedStatement.setString(3, request.getParameter("password"));

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteUserById(int userId) {
		String sql = "DELETE FROM  user_db.users WHERE id = ?";
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, userId);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public User getUserById(int userId) {
		User user = null;
		try {
			Connection connection = DatabaseConnection.getConnection();
			String sql = "SELECT * FROM users WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, userId);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				user = new User();
				user.setId(resultSet.getInt("id"));
				user.setUsername(resultSet.getString("username"));
				user.setEmail(resultSet.getString("email"));
				user.setPassword(resultSet.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public void updateUser(User user) {
		try {
			Connection connection = DatabaseConnection.getConnection();
			String sql = "UPDATE users SET username = ?, email = ?, password = ? WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getPassword());
			statement.setInt(4, user.getId());

			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
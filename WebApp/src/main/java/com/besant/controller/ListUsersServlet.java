package com.besant.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besant.model.User;
import com.besant.utils.DatabaseConnection;

@WebServlet("/listUsers")
public class ListUsersServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<User> userList = new ArrayList<>(); // Create a list to hold user data

		try (Connection connection = DatabaseConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user_db.users");
				ResultSet resultSet = preparedStatement.executeQuery()) {

			// Retrieve user data and add it to the list
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String username = resultSet.getString("username");
				String email = resultSet.getString("email");
				String password = resultSet.getString("password");

				// Print the user data to the console
				System.out.println(
						"ID: " + id + ", Username: " + username + ", Email: " + email + ", Password: " + password);

				// Create a new User object and add it to the list
				User user = new User(id, username, email, password);
				userList.add(user);
			}

			// Set the user list as a request attribute
			request.setAttribute("userList", userList);
			request.getRequestDispatcher("/user-list.jsp").forward(request, response);

		} catch (SQLException e) {
			// Log the exception and set an error message attribute
			e.printStackTrace(); // Optionally log to a logging framework
			request.setAttribute("errorMessage", "Unable to retrieve user data. Please try again later.");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}
}
package com.besant.controller;

import com.besant.model.User;
import com.besant.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

	@WebServlet("/UpdateUserServlet")
	public class UpdateUserServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// Retrieve user details from the request
			int userId = Integer.parseInt(request.getParameter("userId"));
			String username = request.getParameter("username");
			String email = request.getParameter("email");
			String password = request.getParameter("password");

			// Create a User object with updated data
			User user = new User();
			user.setId(userId);
			user.setUsername(username);
			user.setEmail(email);
			user.setPassword(password);

			// Update the user in the database using UserDao
			UserService userDao = new UserService();
			userDao.updateUser(user);

			// Redirect back to the user list page
			response.sendRedirect("home.jsp");
		}
	}
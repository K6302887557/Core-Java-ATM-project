package com.besant.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besant.model.User;
import com.besant.service.UserService;

@WebServlet("/register")
public class UserController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6426147165489493984L;
	private UserService userService = new UserService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		userService.registerUser(request);
		request.getRequestDispatcher("register-success.jsp").forward(request, response);
	}
}
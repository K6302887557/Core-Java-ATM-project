package com.besant.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besant.model.User;
import com.besant.service.UserService;
@WebServlet("/EditUserServlet")
public class EditUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService userService = new UserService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get user ID from the request
        String userId = request.getParameter("userId");

        // Get the user details from the database using UserDao

        User user = userService.getUserById(Integer.parseInt(userId));

        // Set user details as a request attribute
        request.setAttribute("user", user);

        // Forward the request to the editUser.jsp page
        request.getRequestDispatcher("editUser.jsp").forward(request, response);
    }
}
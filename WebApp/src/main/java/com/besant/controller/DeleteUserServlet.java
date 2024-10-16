package com.besant.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besant.service.UserService;
@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userIdStr = request.getParameter("userId");

        if (userIdStr != null) {
            try {
                int userId = Integer.parseInt(userIdStr);
                System.out.println("id : "+ userId);
                // Call the service to delete the user
                userService.deleteUserById(userId);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        // Redirect back to the user list
        response.sendRedirect("home.jsp");
	
    }
}

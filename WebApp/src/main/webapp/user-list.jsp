<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.besant.model.User" %>  <!-- Change this to the correct package -->
<html>
<head>
    <title>User List</title>
</head>
<body>
<h2>User List</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Username</th>
        <th>Email</th>
        <th>Password</th>
        <th>Action</th> <!-- Add a new header for actions -->
    </tr>
    <%
        // Retrieve the user list from the request attribute
        List<User> userList = (List<User>) request.getAttribute("userList");
        if (userList != null) {
            // Loop through the user list and display the data
            for (User user : userList) {
    %>
                <tr>
                    <td><%= user.getId() %></td>
                    <td><%= user.getUsername() %></td>
                    <td><%= user.getEmail() %></td>
                    <td><%= user.getPassword() %></td>
                    <td>
                      <!-- Edit User Form/Link -->
                        <form action="EditUserServlet" method="get" style="display:inline;">
                            <input type="hidden" name="userId" value="<%= user.getId() %>"/>
                            <input type="submit" value="Edit"/>
                        </form>
                        
                        <form action="DeleteUserServlet" method="post">
                            <input type="hidden" name="userId" value="<%= user.getId() %>"/>
                            <input type="submit" value="Delete"/>
                        </form>
                    </td>
                </tr>
    <%
            }
        } else {
    %>
            <tr>
                <td colspan="5">No users found.</td> <!-- Adjust column count -->
            </tr>
    <%
        }
    %>
</table>
</body>
</html>

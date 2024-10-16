<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.besant.model.User" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
    <h2>Edit User</h2>
    <%
        // Retrieve the user object from the request attribute
        User user = (User) request.getAttribute("user");
    %>
    <form action="UpdateUserServlet" method="post">
        <input type="hidden" name="userId" value="<%= user.getId() %>"/>

        <label for="username">Username:</label>
        <input type="text" id="username" name="username" value="<%= user.getUsername() %>"/><br/>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="<%= user.getEmail() %>"/><br/>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" value="<%= user.getPassword() %>"/><br/>

        <input type="submit" value="Update User"/>
    </form>
</body>
</html>

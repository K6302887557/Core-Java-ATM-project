<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            padding: 50px;
        }
        a {
            display: inline-block;
            margin: 20px;
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s;
        }
        a:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h1>Welcome to the User Management System</h1>p
    <p>Select an option below:</p>
    <a href="http://localhost:8080/WebApp/listUsers">View Users</a>
    <a href="http://localhost:8080/WebApp/register.jsp">Register User</a>
</body>
</html>

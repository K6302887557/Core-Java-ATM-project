<!-- Page Directive - information about page -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Example with Scripting Elements & Implicit Objects</title>
</head>
<body bgcolor='white'>

	<!-- include directive - used to add content from another jsp page  -->
<!--  	-->

	<!--  welcome page -->
	<h1>Hello JSP!</h1>

    <!-- Declaration Tag - this tag is used to declare statements -->
    <%! 
        public int subtract(int x, int y) {
            return x - y;
        }
    %>

<h3>Applet Example:</h3>
<applet code="HelloWorldApplet.class" width="300" height="300">
    Your browser does not support Java Applets. 	
</applet>
    <%
        int i = Integer.parseInt(request.getParameter("num1"));
        int j = Integer.parseInt(request.getParameter("num2"));
        int sum = i + j;
        int diff = subtract(i, j); 
        session.setAttribute("sum", sum);
        application.setAttribute("message", "This is a global application message.");
    %>
    <h2>Sum of <%= i %> and <%= j %> is: <%= sum %></h2>
    <h2>Difference (i - j): <%= diff %></h2>
    <h3>Stored in Session: Sum = <%= session.getAttribute("sum") %></h3>
    <h3>Application Message: <%= application.getAttribute("message") %></h3>
    <% 

    %>
    <button onclick="window.location.href='https://www.google.com'">Go to Google</button>
    
    
    <h3>Servlet Name: <%= config.getServletName() %></h3>
    <h4>Current Page Context: <%= pageContext.getServletContext().getContextPath() %></h4>
    <h4>Current Page Object: <%= page.getClass().getName() %></h4>

    <% 
    %>

    <h4>Code Ended</h4>

</body>
</html>
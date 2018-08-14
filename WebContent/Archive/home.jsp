<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>

<%
String user = null;

//allow access only if session exists
if( (user = (String)session.getAttribute("User") ) == null)
	response.sendRedirect("index.jsp");
%>
	
	<h2>Hi <%=user%>!</h2> <br>
	<strong>Welcome to VIEW Page ...</strong> <br><br><br>

	<form action="ViewServlet" method="get">
		<strong>To view all user details, please click 'View'</strong>
		<input type="submit" value="View">
	</form>


	<br><br><br>
	<form action="LogoutServlet" method="post">
		<input type="submit" value="Logout" >
	</form>


</body>
</html>
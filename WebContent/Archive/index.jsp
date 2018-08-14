<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>First Project</title>
</head>
<body>

	<form action="LoginServlet" method="POST">
	
	<strong>Username </strong>:
	<br><input type="text" name="username"><br>
	<strong>Password</strong>:
	<br><input type="password" name="password"><br><br>
	<input type="submit" value="Login"><br>
	
	</form>
	
	<br>If you are not registered user, please <a href="registration.jsp">register</a>.
</body>
</html>
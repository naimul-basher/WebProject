<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration</title>

<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>

<script type="text/javascript" src = "validation.js"></script>

</head>
<body>
	<form id = "myform" action = "RegistrationServlet" method = "POST">
	
	<strong>First Name</strong>:
	<br><input type="text" name="firstname"><br>
	<strong>Last Name</strong>:
	<br><input type="text" name="lastname"><br>
	<strong>Username</strong>:
	<br><input type="text" name="username"><br>
	<strong>Address</strong>:
	<br><input type="text" name="address"><br>
	<strong>Email ID</strong>:
	<br><input type="text" name="email"><br>
	<strong>Phone</strong>:
	<br><input type="text" name="phone"><br>
	<strong>Password</strong>:
	<br><input type="password" name="password"><br><br>
	<input type="submit" value="Register">
	
	</form>
	
	<br>If you are a registered user, please <a href="index.jsp">login</a>.
</body>
</html>
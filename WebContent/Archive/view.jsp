<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="javax.servlet.jsp.jstl.core.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.Web.dto.ViewDTO"%>
<%@page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Page</title>
</head>
<body>

<%
String user = null;

//allow access only if session exists
if( (String)session.getAttribute("User") == null)
	response.sendRedirect("index.jsp");
%>

	<div align="left">
	    <table border="1" cellpadding="5">
	    	<caption><h2>List of users</h2></caption>
	            <tr>
	                <th>First Name</th>
	                <th>Last Name</th>
	                <th>User Name</th>
	                <th>Address</th>
	                <th>Email</th>
	                <th>Phone</th>
	            </tr>
				<%for( ViewDTO viewUser: (ArrayList<ViewDTO>)request.getAttribute("ViewData") ) {%>
	            <tr>
					<td>	<%=viewUser.getFirstName()%>		</td>
					<td>	<%=viewUser.getLastName()%>		</td>
					<td>	<%=viewUser.getUsername()%>		</td>
					<td>	<%=viewUser.getAddress()%>		</td>
					<td>	<%=viewUser.getEmail()%>		</td>
					<td>	<%=viewUser.getPhone()%>		</td>
	            </tr>
	        	<%}%>
	    </table>
	
	</div>

<%--	
	<div align="center">
	    <table border="1" cellpadding="5">
	    	<caption><h2>List of users</h2></caption>
	            <tr>
	                <th>First Name</th>
	                <th>Last Name</th>
	                <th>User Name</th>
	                <th>Address</th>
	                <th>Email</th>
	                <th>Phone</th>
	            </tr>
	        <c:forEach items="${ViewData}" var="record">
	            <tr>
					<td>	<c:out value="${record.getFirstName() }" />		</td>
	                <td>	<c:out value="${record.getLastName() }" />		</td>
	                <td>	<c:out value="${record.getUsername() }"/>		</td>
	                <td>	<c:out value="${record.getAddress() }"/>		</td>
	                <td>	<c:out value="${record.getEmail() }"/>			</td>
	                <td>	<c:out value="${record.getPhone() }"/>			</td>
	            </tr>
	        </c:forEach>
	    </table>
	
	</div>
--%>
	<br><br><br><br>
	<br>Back to <a href="home.jsp">Home</a>.
	

</body>
</html>
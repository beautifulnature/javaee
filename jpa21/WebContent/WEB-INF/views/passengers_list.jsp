<%@
	page import="java.util.*, com.airline.models.*"
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Passengers List</title>
<link rel="stylesheet" href="resources/css/style.css" />
</head>

<body>
	<h1>Passengers List</h1>
	<table>
	<tr>
		<th>Id</th>
		<th>First name</th>
		<th>Last name</th>
		<th>DOB</th>
		<th>Gender</th>
	</tr>
	<% 
	
	List<Passenger> pList = (List<Passenger>) request.getAttribute("passengers_list");
	for(Integer i = 0; i < pList.size(); i++) { %>
		<tr>
			<th><%= pList.get(i).getId() %></th>
			<td><%= pList.get(i).getFirstName() %></td>
			<td><%= pList.get(i).getLastName() %></td>
			<td><%= pList.get(i).getDob() %></td>
			<td><%= pList.get(i).getGender() %></td>
		</tr>			
		<tr><td colspan="5">No flight tickets yet</td></tr>
	<% 	} %>
		
	</table>
</body>
</html>
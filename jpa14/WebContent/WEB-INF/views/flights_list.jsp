<%@
	page import="java.util.*, com.airline.models.*"
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flight List</title>
<link rel="stylesheet" href="resources/css/style.css" />
</head>
<body>
	<h1>Flight List</h1>
	<table>
	<tr>
		<th>From</th>
		<th>To</th>
		<th>Time</th>
		<th>Price</th>
		<th>Airplane</th>
		<th>Seating</th>
		<th>Number of pilots</th>
		<th>Pilot names</th>
	</tr>
	<% 
	
	List<Flight> fList = (List<Flight>) request.getAttribute("flight_list");
	for(Integer i = 0; i < fList.size(); i++) { %>
		<tr>
			<td><%= fList.get(i).getFlightOrigin() %></td>
			<td><%= fList.get(i).getFlightDestination() %></td>
			<td><%= fList.get(i).getFlightTime() %></td>
			<td><%= fList.get(i).getPrice() %></td>
			
			<td> <%= fList.get(i).getAirplaneDetail().getModelName()  %></td>
			<td> <%= fList.get(i).getAirplaneDetail().getSeatingCapacity()  %></td>
			<td>
				<%
				  if(fList.get(i).getPilots()!=null) { 
				%>
					<%= fList.get(i).getPilots().size() %> pilots	  
				<% } else { %>
					No pilots
				<% } %>
			</td>
			<td>
				<%
				  if(fList.get(i).getPilots()!=null) { 
					  List<Pilot> pList = (List<Pilot>) fList.get(i).getPilots();
					  String pilots = "";
					  for(Pilot p : pList) {
						  pilots += p.getFirstName() + " " + p.getLastName() + "<br>";
					  }
				%>
					<%= pilots %>
				<% } %>
			</td>
		</tr>		
	<% 	} %>
		
	</table>
</body>
</html>
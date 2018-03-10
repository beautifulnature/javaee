<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Add New Passenger</title>
	<link rel="stylesheet" type="text/css" href="resources/css/style.css"/>	
</head>

<body>
	<div class="container">
	<h1>Add a passenger</h1>
	<%
	if(request.getAttribute("errors")!=null) {
	%>	
		<fieldset>
			<legend>Errors</legend>
			<ul>
			<% if(request.getAttribute("firstname_error")!=null) { %>
				<li>First name error</li>
			<%} %>	
			
			<% if(request.getAttribute("lastname_error")!=null) { %>
				<li>Last name error</li>
			<%} %>	
			
			<% if(request.getAttribute("date_format_error")!=null) { %>
				<li>DOB invalid</li>
			<% } %>
			
			</ul>
		</fieldset>
	<% } %>
	<fieldset>
	
		<legend>Passenger details</legend>
	
	<form action="AddPassenger" method="post">
		<div class="inputfield">
			 <label for="first-name" class="inputLabel">First name:</label>
			 <input name="first-name" type="text" value="<%=request.getAttribute("first-name")%>">
		</div>	 
		<div class="inputfield">
			 <label for="last-name" class="inputLabel">Last name:</label>
			 <input name="last-name" type="text" value="<%= request.getAttribute("last-name")%>">
		</div>	 
		<div class="inputfield">
			 <label for="dob" class="inputLabel">Date of birth:</label>
			 <input name="dob" type="text" value="<%=request.getAttribute("dob")%>">
		</div>	 
		<div class="inputfield">
			 <label for="dob" class="inputLabel">Gender:</label>
			 <select name="gender">
			 	<option value="male">Male</option>
			 	<option value="female">Female</option>
			 </select>
		</div>	 
	</fieldset>
	<div class="inputfield">
		<input id="submitBtn" type="submit" value="Add new passenger">
	</div>
	</form>
</div>

</body>
</html>
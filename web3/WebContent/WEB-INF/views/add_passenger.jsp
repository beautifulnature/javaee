<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Add New Passenger</title>
</head>
<body>
	<div class="container">
	<div class="title">Add a passenger</div>
	<legend>Passenger details</legend>
	<fieldset>
	<form action="AddPassenger" method="post">
		<div class="inputfield">
			 <label for="first-name" class="inputLabel">First name:</label>
			 <input name="first-name" type="text">
		</div>	 
		<div class="inputfield">
			 <label for="last-name" class="inputLabel">Last name:</label>
			 <input name="last-name" type="text">
		</div>	 
		<div class="inputfield">
			 <label for="dob" class="inputLabel">Date of birth:</label>
			 <input name="dob" type="text">
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

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Appointment</title>
<link type="text/css" rel="stylesheet" href="doctor_appointment.css">
<link rel="icon" href="favicon.ico">
</head>
<body>
	<div id="wrapper">
		<h2>Appointment Form</h2>

	</div>
	
	<form action="AppointmentControllerServlet" method="GET">
	<%-- input type="hidden" name="command" value="ADD" /--%>

		<label>Name :</label>
		<input type="text" name="name"  /> <br><br>
		<label>Age :</label>
		<input type="number" name="age" min="1" max="100"  /> <br><br>
		
		<label for="birthday">DOB :</label>
		<input type="date" name="DOB"> <br><br>
		
		Blood Group :
		<select name="group" id="group">
		<option value="A+">A+</option>
		<option value="A-">A-</option>
		<option value="B+">B+</option>
		<option value="B-">B-</option>
		<option value="AB+">AB+</option>
		<option value="AB-">AB-</option>
		<option value="O+">O+</option>
		<option value="O-">O-</option>
		
		
		</select>
		<br><br>
		<label>Address : </label>
		<textarea rows="4" cols="50" name="address"></textarea><br><br><br><br><br>
		<label>Mobile :</label>
		<input type="number" name="mobile">
		<br><br>
		<label>Email :</label>
		<input type="email" name="email"><br><br>
		<label>Date of Appointment :</label>
		<input type="date" name="dateOfAppointment">
		<br><br>
		
		
		
		<br><br><br><br>
  <input type="submit" value="Submit">
  
  
		
		


	</form><br><br>
	
	<form action="AppointmentControllerServlet" id="report" method="post" enctype="multipart/form-data">
		<label>Report</label>
		<input type="file" name="file" id="reportfile"><br>
		<input type="submit" value="upload" id="reportfile">
		</form>
	
	
</body>
</html>
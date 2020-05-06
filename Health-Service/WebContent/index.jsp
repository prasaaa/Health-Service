
<%@page import="com.Hospital_DB"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!--     
    /*hos_id int AI PK 
			hos_name varchar(45) 
			hos_address varchar(100) 
			hos_phone varchar(20) 
			hos_email varchar(45)*/ -->
    
<%--     <%
//Insert hospital---------------------------------
if (request.getParameter("hos_id") != null)
 {
			 Hospital_DB hos_Obj = new Hospital_DB();
			 String stsMsg = hos_Obj.insertHospital(request.getParameter("hos_name"),
			 request.getParameter("hos_address"),
			 request.getParameter("hos_phone"),
			 request.getParameter("hos_email"));
			 session.setAttribute("statusMsg", stsMsg);
		 }
//Delete hospital----------------------------------
if (request.getParameter("hos_id") != null)
	 {
	Hospital_DB hos_Obj = new Hospital_DB();
	 String stsMsg = hos_Obj.deleteHospital(request.getParameter("hos_id"));
	 session.setAttribute("statusMsg", stsMsg);
	 }
%> --%>

<%//Save---------------------------------
if (request.getParameter("hos_id") != null)
{
	Hospital_DB hos_Obj = new Hospital_DB();
 String stsMsg = "";
//Insert--------------------------
if (request.getParameter("hideHospitalSave") == "")
 {
	stsMsg = hos_Obj.insertHospital(request.getParameter("hos_name"),
				 request.getParameter("hos_address"),
			 	 request.getParameter("hos_phone"),
			 	 request.getParameter("hos_email"));
 }
else//Update----------------------
 {
	if(request.getParameter("hideHospitalSave") == ""){
		
	
	 stsMsg = hos_Obj.updateHospital(request.getParameter("hos_name"),
	 request.getParameter("hos_address"),
	 request.getParameter("hos_phone"),
	 request.getParameter("hos_email"),
	 request.getParameter("hos_id"));
	}
 }
 session.setAttribute("statusMsg", stsMsg);
}
//Delete-----------------------------
if (request.getParameter("hidHospitalDelete") != null)
{
	Hospital_DB hos_Obj = new Hospital_DB();
 	String stsMsg =
		 hos_Obj.deleteHospital(request.getParameter("hidHospitalDelete"));
 session.setAttribute("statusMsg", stsMsg);
}
    
    
    
    
    %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Home - HelthCare Online Hospital Management System-</title>
    <meta name="description" content="The main purpose of this project is to implementing a web application for the Appointment and payment  management">
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css?h=d32d592ad598132614dde0237ba89ee0">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.12.0/css/all.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/fonts/fontawesome5-overrides.min.css?h=18313f04cea0e078412a028c5361bd4e">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.css">
    <link rel="stylesheet" href="assets/css/styles.min.css?h=c3469e853992726e868d89155c347074">

<link rel="stylesheet" href="Views/bootstrap.min.css">

</head>

<body>
<script src="Components/jquery-3.3.1.min.js"></script>
<script src="Components/hospital.js"></script>


<div class="container">
  <div class="row">
  	<div class="col-8">
    	<h3 class="m-3">Hospital Registration</h3>
    <div class="col-sm">
      <!-- hos_id int AI PK 
hos_name varchar(45) 
hos_address varchar(100) 
hos_phone varchar(20) 
hos_email varchar(45) -->
			  
		      <form id="form_hospital" name="form_hospital">
			  <div class="form-group">  
					<label>Hospital Name :</label>
			    		<input type="text" class="form-control" id="hos_name" name="hos_name" placeholder="Hospital Name">
			  </div>
			  <div class="form-group">  
					<label>Hospital Address :</label>
			    		<input type="text" class="form-control" id="hos_address" name="hos_address" placeholder="Hospital Address">
			  </div>
			  <div class="form-group">  
					<label>Hospital Contact Number :</label>
			    		<input type="number" class="form-control" id="hos_phone" name="hos_phone" placeholder="Hospital Contact Number">
			  </div>
			  <div class="form-group">  
					<label>Hospital Email :</label>
			    		<input type="email" class="form-control" id="hos_email" name="hos_email" placeholder="Hospital email">
			  </div>
			  <input type="button" id="btnSave" value="Submit" class="btn btn-primary">
			 
			 <input type="hidden" id="hideHospitalSave" name="hideHospitalSave" value="" >
			 
			  <!-- <button type="submit" class="btn btn-primary">Submit</button>
			   -->
		</form>
    </div>
    
 	 </div id="alertSuccess" class="alert alert-success">
 	 <%
 	 	out.print(session.getAttribute("statusMsg"));
 	 %>  
	</div>
	
	 </div id="alertError" class="alert alert-danger">
 	 <%
 	 	Hospital_DB hos_db_obj = new Hospital_DB();
 	 	out.print(hos_db_obj.readHospital());
 	 %>  
	</div>
	
</div>
    
    <div class="row">
<div class="col-12" id="colHospital">

</div>
</div>
    
    
    
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.js"></script>
    <script src="assets/js/script.min.js?h=b402b77bba6981bcbca2e2c72263497d"></script>
</body>

</html>
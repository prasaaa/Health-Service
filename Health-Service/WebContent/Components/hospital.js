$(document).ready(function()
{
	if($("#alertSuccess").text().trim() == "")
	{
	
		$("#alertSuccess").hide();
	}
	 $("#alertError").hide();
}); 
//page refresh




//SAVE ============================================
$(document).on("click", "#btnSave", function(event)
{
// Clear alerts---------------------
 $("#alertSuccess").text("");
 $("#alertSuccess").hide();
 $("#alertError").text("");
 $("#alertError").hide(); 
 
//Form validation-------------------
 var status = validateItemForm();
 if (status != true)
  {
  $("#alertError").text(status);
  $("#alertError").show();
  return;
  }
 
 
 var type = ($("#hideHospitalSave").val() == "") ? "POST" : "PUT";

 $.ajax(
	{
	 url : "HospitalAPI",
	 type : type,
	 data : $("#form_hospital").serialize(),
	 dataType : "text",
	 complete : function(response, status)
	 {
		 onHospitalSaveComplete(response.responseText, status);
	 }
 });
 
 // If valid-------------------------
 // $("#form_hospital").submit();
 });





//UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event)
{
 $("#hideHospitalSave").val($(this).closest("tr").find('#hideHospitalSave').val());
 $("#hos_id").val($(this).closest("tr").find('td:eq(0)').text());
 $("#hos_name").val($(this).closest("tr").find('td:eq(1)').text());
 $("#hos_address").val($(this).closest("tr").find('td:eq(2)').text());
 $("#hos_phone").val($(this).closest("tr").find('td:eq(3)').text());
 $("#hos_email").val($(this).closest("tr").find('td:eq(4)').text());
});






// DELETE==========================================
$(document).on("click", ".btnRemove", function(event)
{
	$.ajax(
	 {
		 url : "HospitalAPI",
		 type : "DELETE",
		 data : "hos_id=" + $(this).data("hos_id"),
		 dataType : "text",
		 complete : function(response, status)
		{
		 onItemDeleteComplete(response.responseText, status);
		 }
	 });
	});




//CLIENT-MODEL=================================================================
function validateHospitalForm()
{
// hospital name
if ($("#hos_name").val().trim() == "")
 {
 return "Insert hospital name.";
 }

if ($("#hos_address").val().trim() == "")
{
return "Insert hospital address.";
}

/*if ($("#hos_phone").val().trim() == "")
{
return "Insert hospital phone.";
}*/
// Validate numbers

if ($("#hos_phone").val().trim() != ""){
	
	if($("#hos_phone").val().length < 10){
		return "Wrong Phone Number";
	}	
}

/*if ($("#hos_email").val().trim() == "")
{
return "Insert hospital email.";
}*/
// validate emails
if ($("#hos_email").val().trim() != ""){
	
	var email = $("#hos_email").val();
	var regex = /^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	
	if(!regex.test(email))
	{
		return "InValide Email.";
	}
		
	
}
return true;
}


function getHospitalCard(hos_name, hos_address, hos_phone,hos_email)
{


var hospital = "";
hospital += "<div class=\"hospital card bg-light m-2\
			style=\"max-width: 10rem; float: left;\">";
hospital += "<div class=\"card-body\">";
hospital += hos_name + " " + hos_address + " " + hos_phone + " ,";
hospital += "<br>";
hospital += hos_email + " hos_email";
hospital += "</div>";
hospital += "<input type=\"button\" value=\"Remove\
			class=\"btn btn-danger remove\">";
hospital += "</div>";
	return hospital;
	}
	




function onHospitalSaveComplete(response, status)
{
if (status == "success")
 {
 var resultSet = JSON.parse(response);
 if (resultSet.status.trim() == "success")
 {
 $("#alertSuccess").text("Successfully saved.");
 $("#alertSuccess").show();
 $("#divHospitalGrid").html(resultSet.data);
 } else if (resultSet.status.trim() == "error")
 {
 $("#alertError").text(resultSet.data);
 $("#alertError").show();
 }
 } else if (status == "error")
 {
 $("#alertError").text("Error while saving.");
 $("#alertError").show();
 } else
 {
 $("#alertError").text("Unknown error while saving..");
 $("#alertError").show();
 }
 $("#hideHospitalSave").val("");
 $("#form_hospital")[0].reset();
}




function onHospitalDeleteComplete(response, status)
{
if (status == "success")
 {
 var resultSet = JSON.parse(response);
 if (resultSet.status.trim() == "success")
 {
 $("#alertSuccess").text("Successfully deleted.");
 $("#alertSuccess").show();
 $("#divHospitalGrid").html(resultSet.data);
 } else if (resultSet.status.trim() == "error")
 {
 $("#alertError").text(resultSet.data);
 $("#alertError").show();
 }
 } else if (status == "error")
 {
 $("#alertError").text("Error while deleting.");
 $("#alertError").show();
 } else
 {
 $("#alertError").text("Unknown error while deleting..");
 $("#alertError").show();
 }
}
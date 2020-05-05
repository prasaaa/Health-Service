$(document).ready(function()
{
	if($("#alertSuccess").text().trim() == "")
	{
	
		$("#alertSuccess").hide();
	}
	 $("#alertError").hide();
}); 
//page refresh

/*hos_id int AI PK 
hos_name varchar(45) 
hos_address varchar(100) 
hos_phone varchar(20) 
hos_email varchar(45)*/

//SAVE ============================================
$(document).on("click", "#btnSave", function(event)
{
// Clear status msges-------------
 $("#alertSuccess").text("");
 $("#alertSuccess").hide();
 $("#alertError").text("");
 $("#alertError").hide();
// Form validation----------------
var status = validateItemForm();
// If not valid-------------------
if (status != true)
 {
 $("#alertError").text(status);
 $("#alertError").show();
 return;
 }



//If valid
var hospital = getHospitalCard($("#hos_id").val().trim(),
		$("#hos_name").val().trim(),
		$("#hos_address").val().trim(),
		$("#hos_phone").val().trim(),
		$("#hos_email").val().trim(),

$("#colHospital").append(hospital);



 $("#alertSuccess").text("Saved successfully.");
 $("#alertSuccess").show();

 $("#form_hospital")[0].reset();
});
// REMOVE==========================================
$(document).on("click", ".remove", function(event)
{
 $(this).closest(".hospital").remove();

 $("#alertSuccess").text("Removed successfully.");
 $("#alertSuccess").show();
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

if ($("#hos_phone").val().trim() == "")
{
return "Insert hospital phone.";
}

if ($("#hos_email").val().trim() == "")
{
return "Insert hospital email.";
}
return true;
}


function getHospitalCard(hos_name, hos_address, hos_phone,hos_email)
{


var hospital = "";
hospital += "<div class=\"hospital card bg-light m-2\"
 style=\"max-width: 10rem; float: left;\">";
hospital += "<div class=\"card-body\">";
hospital += hos_name + " " + hos_address + " " + hos_phone + " ,";
hospital += "<br>";
hospital += hos_email + " hos_email";
hospital += "</div>";
hospital += "<input type=\"button\" value=\"Remove\"
 class=\"btn btn-danger remove\">";
hospital += "</div>";
return hospital;
}


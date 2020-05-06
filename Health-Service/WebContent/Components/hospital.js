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
 // If valid-------------------------
  $("#form_hospital").submit();
 });





//UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event)
{
 $("#hideHospitalSave").val($(this).closest("tr").find('#hidhospitalIDUpdate').val());
 $("#hos_id").val($(this).closest("tr").find('td:eq(0)').text());
 $("#hos_name").val($(this).closest("tr").find('td:eq(1)').text());
 $("#hos_address").val($(this).closest("tr").find('td:eq(2)').text());
 $("#hos_phone").val($(this).closest("tr").find('td:eq(3)').text());
 $("#hos_email").val($(this).closest("tr").find('td:eq(4)').text());
});






// DELETE==========================================
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
	
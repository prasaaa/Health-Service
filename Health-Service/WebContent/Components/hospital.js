/**
 * 
 */
$(document).ready(function()
{
	if($("#alertSuccess").text().trim() == "")
	{
	
		$("#alertSuccess").hide();
	}
	 $("#alertError").hide();
}); 

// Save 
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
		// If valid-----------------------
		
		// hos_name hos_address hos_phone hos_email
		
		var hospital = getHospitalCard($("#txtName").val().trim(),
		 /*$('input[name="rdoGender"]:checked').val(),*/
		 $("#ddlYear").val());
		 $("#colStudents").append(hospital);

		 $("#alertSuccess").text("Saved successfully.");
		 $("#alertSuccess").show();

		 $("#form_hospital")[0].reset();
		});



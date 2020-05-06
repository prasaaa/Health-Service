package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;




public class Hospital_DB {
	
	public String output;
	private Connection con;
	private String query;
	private PreparedStatement preparedStmt;
	
	//View data
	public String readHospital() {
		output = "";
		try {
			con = DBConnection.connect();

			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			/*hos_id int AI PK 
			hos_name varchar(45) 
			hos_address varchar(100) 
			hos_phone varchar(20) 
			hos_email varchar(45)*/
			// Prepare the html table to be displayed
		
				
		
						output = "<table border='1'><tr>" +
								"<th>ID </th>" +
								"<th>Hospital ID</th>" +
								"<th>Hospital Name</th>"+ 
								"<th>Hospital Address</th>" +
								"<th>Hospital Phone</th>" +
								"<th>Hospital Email</th>"+ 
								"<th>Update</th>" +
								"<th>Remove</th>" + 
								"</tr>";
						
						
						query = "SELECT * FROM hospital_table";
						Statement stmt = con.createStatement();
						ResultSet rs = stmt.executeQuery(query);
						
						while (rs.next()) {
							
							String hos_id = Integer.toString(rs.getInt("hos_id"));
							 String hos_name = rs.getString("hos_name");
							 String hos_address = rs.getString("hos_address");
							 String hos_phone = rs.getString("hos_phone"); 
							 String hos_email = rs.getString("hos_email"); 
								
							 
							// Add into the html table
							 output += "<tr><td>" + hos_id + "</td>";
							 output += "<td>" + hos_name + "</td>";
							 output += "<td>" + hos_address + "</td>";
							 output += "<td>" + hos_phone + "</td>";
							 output += "<td>" + hos_email + "</td>";
							 
							 
							// buttons
							 output += "<td><input name=\"btnUpdate\" type=\"button\"value=\"Update\"></td>\r\n"
							  + "<td><form method=\"post\" action=\"index.jsp\">"
							  + "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\">"
							  + "<input name=\"hos_id\" type=\"hidden\" value=\"" + hos_id + "\">"
							  + "</form></td></tr>";
							 }
					
		
		con.close();

		// Complete the html table
		output += "</table>";

	} catch (Exception e) {
		output = "Error while reading the Hospital";
		System.err.println(e.getMessage());
	}
	return output;
}	
	
	
	//insert data
	public String insertHospital(String hos_name, String hos_address, String hos_phone, String hos_email) {
		System.out.println("came here insertHospital");
		output = "";
		//String validData = "";
		try {
		//	System.out.println("validated");
			con = DBConnection.connect();

			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			
			
			// create a prepared statement
			query =	"insert into hospital_table values(?,?,?,?) ";
			 
			preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setString(1, hos_name);
			preparedStmt.setString(2, hos_address);
			preparedStmt.setString(3, hos_phone);
			preparedStmt.setString(4, hos_email);
			
			
			
			// execute the statement
			preparedStmt.execute();
			
			
			con.close();
		

		} catch (Exception e) {
			output = "Error while inserting the Hospital."; 
			System.err.println(e.getMessage());
			System.out.println("error insert" +e);
			
		}
		System.out.println(output);
		return output;
	}
	
	
	
	// to select specific Hospital from database
		public String searchHospital(String hos_id) {
			output = "";
			
			try {
				con = DBConnection.connect();

				if (con == null) {
					return "Error while connecting to the database for reading.";
				}

				// Prepare the html table to be displayed
				output = "<table border='1'><tr>" +
						"<th>ID </th>" +
						"<th>Hospital ID</th>" +
						"<th>Hospital Name</th>"+ 
						"<th>Hospital Address</th>" +
						"<th>Hospital Phone</th>" +
						"<th>Hospital Email</th>"+ 
						"<th>Update</th>" +
						"<th>Remove</th>" + 
						"</tr>";

				query = "select * from hospital_table where hos_id ="+hos_id;
				preparedStmt = con.prepareStatement(query);
				ResultSet rs = preparedStmt.executeQuery(query);

				// iterate through the rows in the result set
				while (rs.next()) {

					String hos_id1 = Integer.toString(rs.getInt("hos_id"));
					 String hos_name = rs.getString("hos_name");
					 String hos_address = rs.getString("hos_address");
					 String hos_phone = rs.getString("hos_phone"); 
					 String hos_email = rs.getString("hos_email"); 
						
					 
					// Add into the html table
					 output += "<tr><td>" + hos_id1 + "</td>";
					 output += "<td>" + hos_name + "</td>";
					 output += "<td>" + hos_address + "</td>";
					 output += "<td>" + hos_phone + "</td>";
					 output += "<td>" + hos_email + "</td>";

				}
				con.close();

				// Complete the html table
				output += "</table>";

			} catch (Exception e) {
				output = "Error while reading the Hospital";
				System.err.println(e.getMessage());
			}
			return output;
		}
	
		
		
		public String deleteHospital(String hos_id) {
			output = "";
			try {
				

				con = DBConnection.connect();
				if (con == null) {
					return "Error while connecting to the database for Deleting.";
				}
				// create a prepared statement
				query = "delete from hospital_table WHERE hos_id=?";
				preparedStmt = con.prepareStatement(query);
				// binding values
				preparedStmt.setString(1, hos_id);
				// execute the statement
				preparedStmt.executeUpdate();
				con.close();
				
				
				output = " Deleted the Hospital."; 
			} catch (Exception e) {
				output = "Error while deleting the Hospital."; 
				System.err.println(e.getMessage());
			}
			return output;
		}
		
		
		
		public String updateHospital(String hos_name, String hos_address, String hos_phone, String hos_email,String hos_id) {

			output = "";
			try {
				con = DBConnection.connect();

				if (con == null) {
					return "Error while connecting to the database for Updating.";
				}
				

				// create a prepared statement
				query = "update hospital_table SET hos_name=?,hos_address=?,hos_phone=?,hos_email=? WHERE hos_id=?";

				preparedStmt = con.prepareStatement(query);
				// binding values
				preparedStmt.setString(1, hos_name);
				preparedStmt.setString(2, hos_address);
				preparedStmt.setString(3, hos_phone);
				preparedStmt.setString(4, hos_email);
				preparedStmt.setString(5, hos_id);
				
				// execute the statement
				preparedStmt.executeUpdate();

						
				
				con.close();
				System.out.println("updated");
			

			} catch (Exception e) {
				output = "Error while Update the Hospital."; 
				System.err.println(e.getMessage());
				System.out.println("error update" +e);
				
			}
			System.out.println(output);
			return output;

		}	
		
}
		


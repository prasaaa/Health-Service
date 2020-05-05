package com;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import model.DoctorM;

public class DoctorRepositry {
	
	
	Connection con =null;
	public  DoctorRepositry() {
		String url = "jdbc:mysql://localhost/healthcare";
		String username ="root";
		String password = "";
		 try
		 {
			
		 Class.forName("com.mysql.jdbc.Driver");

		
		 con = DriverManager.getConnection(url,username,password);
		 }
		 catch (Exception e) {
		 	System.out.println(e);
		 
		 }
		 
		 
		 
	}
	
	
	public List<DoctorM> getDoctors() {
		List<DoctorM> doctor = new ArrayList<>();
		String sql = "select * from doctor ";
		try {
			Statement st = con.createStatement();
			ResultSet rs =  st.executeQuery(sql);
			while(rs.next()) {
				
				DoctorM a= new DoctorM();
				
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setTel(rs.getInt(3));
				a.setSpecialization(rs.getString(4));
				a.setHosptal(rs.getString(5));
				
				doctor.add(a);
				
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return doctor;
	}
	
	public DoctorM getDoctor(int id) {
		
		String sql = "select * from doctor where id ="+id;
		DoctorM a= new DoctorM();
		try {
			Statement st = con.createStatement();
			ResultSet rs =  st.executeQuery(sql);
			if(rs.next()) {
				
				
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setTel(rs.getInt(3));
				a.setSpecialization(rs.getString(4));
				a.setHosptal(rs.getString(5));
				
			
				
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return a;
	}
	

	public void create(DoctorM d1) {
		String sql = "insert into doctor values(?,?,?,?,?) ";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1,d1.getId());
			st.setString(2,d1.getName());
			st.setInt(3,d1.getTel());
			st.setString(4,d1.getSpecialization());
			st.setString(5,d1.getHosptal());
			
			st.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void update(DoctorM d1) {
		String sql = "UPDATE doctor SET name=?,Tel=?,Specialization=?,Hospital=? WHERE id=?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			
			st.setString(1,d1.getName());
			st.setInt(2,d1.getTel());
			st.setString(3,d1.getSpecialization());
			st.setString(4,d1.getHosptal());
			st.setInt(5,d1.getId());
			
			st.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	

}

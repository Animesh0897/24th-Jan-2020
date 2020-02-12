package com.ibm.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementDemo {

	Connection dbCon;
	PreparedStatement pstmt;

	public PreparedStatementDemo() {
		try {
			dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/ibmtraining?serverTimezone=IST","root", "");
			System.out.println("Connected Succefully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Some issues while connecting " + e.getMessage());
		}
	}
	
	
	public static void main(String[] args) {
		PreparedStatementDemo demo = new PreparedStatementDemo();
		
		demo.queryTable();
	}
	
	
	private void queryTable()
	{
		String fetchQry = "select*from user_database where user_id=?";
		
		//Create
		
		try {
			pstmt = dbCon.prepareStatement(fetchQry);
			pstmt.setInt(1,4);//1st placeholder has 4 = value
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				System.out.println("Name"+rs.getString("user Name"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Issue while creating prepared statement " + e.getMessage());
		}
		
		try
		{
			dbCon.close();
		}catch(SQLException e)
		{
			System.out.println("Issues while closing the connection" + e.getMessage());
		}
	}
	
	//Update table user_database

	void updateData()
	{
		//write the query to update table
		
		String updateQry = "update user_database set user_name = ? where user_id = ?";
		
		try
		{
			pstmt = dbCon.prepareStatement(updateQry);
			
			//put values into the pstmt
			
			pstmt.setString(1,  "Mayank Ava");
			pstmt.setInt(2, 2);
			
			//Execute the 	query;
			
			
			if (pstmt.executeUpdate()>0)
			{
				System.out.println("Done succssfully");
			}
			
			else
			{
				System.out.println("Failed");
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
}



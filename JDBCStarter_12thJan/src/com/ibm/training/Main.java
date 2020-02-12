package com.ibm.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		//Load the driver in memory
		//Class.forName(className)
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/ibmtraining?serverTimezone=IST","root", "");
			System.out.println("Successfully connected");
			
			new Main().insertData(dbCon);
			new Main().getAllData(dbCon);
			

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Exception while loading driver" + e.getMessage());
		}catch(SQLException e)
		{
			System.out.println("Exception while connecting to db :" + e.getMessage());
		}
		
//		new Main().insertData(dbCon);
//		new Main().getAllData(dbCon);

	}
	
	void getAllData(Connection dbCon)
	{
		//Create a Statement
		
		try {
			Statement stmt = dbCon.createStatement();
			
			String fetchQry =  "select*from user_database";
			ResultSet rs = stmt.executeQuery(fetchQry);
			
			//Traverse through result set
			
			while(rs.next())
			{
				System.out.println("User ID :" + rs.getInt("user_id"));
				System.out.println("User Name :" + rs.getString("user_address"));
			}
			
			dbCon.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Issues Creating statement" + e.getMessage());
		}
	}
	
	
	void insertData(Connection dbCon)
	{
		String insertQuery = "insert into user_database values('amaz' , 78 , 'Banglore')";
		
		try
		{
			Statement stmt = dbCon.createStatement();
			
			if(stmt.executeUpdate(insertQuery)>0)
			{
				System.out.println("Successfull insertted a new row..");
			}
		}
		catch(SQLException e)
		{
			System.out.println("Issues creating the statement " + e.getMessage());
		}
	}

}

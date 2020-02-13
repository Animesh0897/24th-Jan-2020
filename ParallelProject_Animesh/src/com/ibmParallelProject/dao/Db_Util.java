package com.ibmParallelProject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db_Util 
{
	public Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/ibmtraining?serverTimezone=IST","root", "");
		return dbCon;
	}
}

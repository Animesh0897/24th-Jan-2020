package com.ibm.ParallelProject.doa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ibm.ParallelProject.bean.Customer;
import com.ibm.ParallelProject.bean.Wallet;

public class Doa1 {
	Connection dbCon;
	PreparedStatement pstmt;
	
	public Doa1() {
		try {
			dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/ibmtraining?serverTimezone=IST", "root", "");
		} catch (SQLException e) {
			System.out.println("Error while connecting the database: "+e.getMessage());
		}
	}
	//Data1 d = new Data1();
	Customer c = new Customer();
	Wallet w = new Wallet();
	public void addMoney(int id,int m) {
		int mnew = m+balance(id);
		String updateQry = "update wallet_database set balance = ? where id = ?";
		try {
			/*Statement stmt = dbCon.createStatement();
			ResultSet rs = stmt.executeQuery(updateQry);*/
			pstmt = dbCon.prepareStatement(updateQry);
			pstmt.setInt(1, mnew);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void withdrawMoney(int id,int m) {
		m = balance(id)-m;
		String updateQry = "update wallet_database set balance = ? where id = ?";
		try {
			/*Statement stmt = dbCon.createStatement();
			ResultSet rs = stmt.executeQuery(updateQry);*/
			pstmt = dbCon.prepareStatement(updateQry);
			pstmt.setInt(1, m);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int balance(int id) {
		String balQry = "select id,balance from wallet_database";
		try {
			Statement stmt = dbCon.createStatement();
			ResultSet rs = stmt.executeQuery(balQry);
			//ResultSet rs = pstmt.executeQuery(balQry);
			while(rs.next()) {
				if(rs.getInt("id")==id) {
					return rs.getInt("balance");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public void createAcc(Customer c) {
		String insertQry = "insert into wallet_database values(?,?,?,?,?)";
		try {
			pstmt = dbCon.prepareStatement(insertQry);
			pstmt.setInt(1, c.getId());
			pstmt.setString(2, c.getName());
			pstmt.setInt(3, c.getBalance());
			pstmt.setString(4,c.getPassword());
			pstmt.setString(5, c.getDate());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error while adding employee: "+e.getMessage());
		}
	}
	public void transfer(int id,int m,int idp) {
		int m1 = balance(id)-m;
		String updateQry1 = "update wallet_database set balance = ? where id = ?";
		try {
			pstmt = dbCon.prepareStatement(updateQry1);
			pstmt.setInt(1, m1);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int m2 = balance(idp)+m;
		String updateQry2 = "update wallet_database set balance = ? where id = ?";
		try {
			pstmt = dbCon.prepareStatement(updateQry2);
			pstmt.setInt(1, m2);
			pstmt.setInt(2, idp);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void showAll() {
		String showQry = "select name,balance,date_created from wallet_database";
		try {
			ResultSet rs = pstmt.executeQuery(showQry);
			while(rs.next()) {
				System.out.println("Name: " +rs.getString("name") +" Balance: "+rs.getString("balance")+" Created on: " + rs.getString("date_created"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public boolean log(int id,String p) {
		String logQry = "select id,password from wallet_database";
		try {
			Statement stmt = dbCon.createStatement();
			ResultSet rs = stmt.executeQuery(logQry);
			while(rs.next()) {
				if(rs.getInt("id")==id && (rs.getString("password")).equals(p)) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean checkid(int id) {
		String idQry = "select id from wallet_database";
		try {
			ResultSet rs = pstmt.executeQuery(idQry);
			while(rs.next()) {
				if(rs.getInt("id")==id) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public void closeDB() {
		try {
			dbCon.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
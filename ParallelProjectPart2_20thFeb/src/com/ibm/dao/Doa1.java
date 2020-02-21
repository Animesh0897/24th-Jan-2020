package com.ibm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ibm.bean.Customer;

public class Doa1 {
	Connection dbCon;
	PreparedStatement pstmt;
	Doa2 d = new Doa2();
	public Doa1()throws SQLException, ClassNotFoundException {
			Class.forName("com.mysql.cj.jdbc.Driver");
			dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3307/test?serverTimezone=IST", "root", "");
	}
	public void CreateAccount(Customer a)throws SQLException {
		String insertQry = "insert into wallet_database values(?,?,?,?,?)";
		pstmt = dbCon.prepareStatement(insertQry);
		pstmt.setInt(1, a.getId());
		pstmt.setString(2, a.getName());
		pstmt.setInt(3, a.getBalance());
		pstmt.setString(4,a.getPassword());
		pstmt.setString(5, a.getDate());
		pstmt.executeUpdate();
	}
	public boolean check(Customer a)throws SQLException{
		String idQry = "select id from wallet_database";
		Statement stmt = dbCon.createStatement();
		ResultSet rs = stmt.executeQuery(idQry);
		while(rs.next()) {
			if(rs.getInt("id")==a.getId()) {
				return true;
			}
		}
	return false;
	}
	public boolean log(Customer a)throws SQLException {
		String logQry = "select id,password from wallet_database";
			Statement stmt = dbCon.createStatement();
			ResultSet rs = stmt.executeQuery(logQry);
			while(rs.next()) {
				if(rs.getInt("id")==a.getId() && (rs.getString("password")).equals(a.getPassword())) {
					return true;
				}
			}
		return false;
	}
	public int balance(Customer a)throws SQLException {
		String balQry = "select id,balance from wallet_database";
			Statement stmt = dbCon.createStatement();
			ResultSet rs = stmt.executeQuery(balQry);
			//ResultSet rs = pstmt.executeQuery(balQry);
			while(rs.next()) {
				if(rs.getInt("id")==a.getId()) {
					return rs.getInt("balance");
				}
			}
		return 0;
	}
	public void addMoney(Customer a)throws SQLException {
		int mnew = a.getBalance()+balance(a);
		String updateQry = "update wallet_database set balance = ? where id = ?";
			pstmt = dbCon.prepareStatement(updateQry);
			pstmt.setInt(1, mnew);
			pstmt.setInt(2, a.getId());
			pstmt.executeUpdate();
		
	}
	public void withdrawMoney(Customer a)throws SQLException {
		int mnew = balance(a)-a.getBalance();
		String updateQry = "update wallet_database set balance = ? where id = ?";
			pstmt = dbCon.prepareStatement(updateQry);
			pstmt.setInt(1, mnew);
			pstmt.setInt(2, a.getId());
			pstmt.executeUpdate();
	}
	public boolean checkid(Customer a)throws SQLException {
		String idQry = "select id from wallet_database";
		Statement stmt = dbCon.createStatement();
		ResultSet rs = stmt.executeQuery(idQry);
		while(rs.next()) {
			if(rs.getInt("id")==a.getId()) {
				return true;
			}
		}
		return false;
	}
	public ArrayList<String> showAll()throws SQLException {
		ArrayList<String> al = new ArrayList<>();
		Customer a  = new Customer();
		String showQry = "select name,balance,date_created from wallet_database";
		int c = 0;
			Statement stmt = dbCon.createStatement();
			ResultSet rs = stmt.executeQuery(showQry);
			//ResultSet rs = pstmt.executeQuery(showQry);
			while(rs.next()) {
				StringBuilder sb = new StringBuilder("");
				sb.append("Name: ");
				sb.append(rs.getString("name"));
				sb.append(" Balance: ");
				sb.append(rs.getInt("balance"));
				sb.append(" Created on: ");
				sb.append(rs.getString("date_created"));
				al.add(sb.toString());
				//System.out.println("Name: " +rs.getString("name") +" Balance: "+rs.getString("balance")+" Created on: " + rs.getString("date_created"));
			}
			return al;
	}
}

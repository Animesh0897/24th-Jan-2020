package com.ibm.training;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 */
@WebServlet("/CreateAccount")
public class CreateAccount extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String create = request.getParameter("create");

		if (create != null) {
			try {
				if (validate(username)) {
					response.setContentType("text/html");
					response.getWriter().println("username already exists");
					RequestDispatcher dispatcher = request.getRequestDispatcher("createAcc.html");
					dispatcher.include(request, response);

				} else {
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager
								.getConnection("jdbc:mysql://localhost:3307/test?serverTimezone=IST", "root", "");
						String qry = "insert into reg values(?,?,?)";
						PreparedStatement ps = con.prepareStatement(qry);
						ps.setString(1, name);
						ps.setString(2, username);
						ps.setString(3, password);
						ps.executeUpdate();

					} catch (SQLException e) {
						System.out.println("cant connect");
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}

				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.setContentType("text/html");
			response.getWriter().println("Successfully created");
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
			dispatcher.include(request, response);
		}

	}

	public boolean validate(String username) throws ClassNotFoundException {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/test?serverTimezone=IST", "root","");

			String id = "select username from reg";
			Statement stmt;
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(id);
			while(rs.next())
			{
				
			
			if(rs.getString("username").equals(username)) {
				return true;
			}
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Cant connect");
		}

		return false;

	}

}

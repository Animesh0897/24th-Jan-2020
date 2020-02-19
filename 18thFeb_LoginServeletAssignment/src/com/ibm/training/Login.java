package com.ibm.training;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String login = request.getParameter("login");

		if (login != null) {
			if (validate(username, password)) {
				HttpSession session = request.getSession(true);
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/test?serverTimezone=IST",
							"root", "");
					String idQry = "select * from reg";
					Statement stmt;
					stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(idQry);
					while (rs.next()) {
						if (rs.getString("username").equals(username) && rs.getString("password").equals(password)) {
							session.setAttribute("name", rs.getString("username"));
							response.sendRedirect("Welcome");
						}
					}
				} catch (SQLException e) {
					System.out.println("Can't connect" + e.getMessage());
				} catch (ClassNotFoundException e) {
					System.out.println("Driver could not be loaded");
				}
			}
				else {
					//	HttpSession session = request.getSession();
					//	session.setAttribute("isUserLoggedIn",false);
					//	session.invalidate();
						response.setContentType("text/html");
						response.getWriter().println("Login failed!!! Try again");
						RequestDispatcher dispatcher = request.getRequestDispatcher("loginAcc.html");
						RequestDispatcher dispatcher1 = request.getRequestDispatcher("Welcome");
						dispatcher.include(request, response);
						dispatcher1.include(request,response);
				}
			}
		}

	

	public boolean validate(String username, String password) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3307/test?serverTimezone=IST",
					"root", "");
			String idQry = "select username,password from reg";
			Statement stmt;
			stmt = dbCon.createStatement();
			ResultSet rs = stmt.executeQuery(idQry);
			// ResultSet rs = pstmt.executeQuery(idQry);
			while (rs.next()) {
				if (rs.getString("username").equals(username) && rs.getString("password").equals(password)) {
					return true;
				}
			}
		} catch (SQLException e) {
			System.out.println("Can't connect" + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Driver could not be loaded");
		}
		return false;
	}

}

package com.ibm.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StartIndex
 */
@WebServlet("/StartIndex")
public class StartIndex extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String addAccount = request.getParameter("addAccount");
		String loginAccount = request.getParameter("loginAccount");
		String  viewUsers = request.getParameter("viewUsers");
		String exit = request.getParameter("exit");
		ServiceClass ms = new ServiceClass();
		try {
		if(addAccount!=null) {
			response.sendRedirect("CreateAccount.jsp");
		}
		else if(loginAccount!=null) {
			response.sendRedirect("login.jsp");
		}
		else if(viewUsers!=null) {
			ArrayList<String> al = ms.allUsers();
			StringBuilder sb = new StringBuilder("");
			for(String str:al) {
				sb.append((str));
				
			}
			request.setAttribute("message",sb.toString());
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		
		else if(exit!=null) {
			response.sendRedirect("End.jsp");
		}
		
		}catch(SQLException e) {
			
			System.out.println("Error on index page: "+e.getMessage());
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

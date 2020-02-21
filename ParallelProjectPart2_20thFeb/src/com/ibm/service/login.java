package com.ibm.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.bean.Customer;
import com.ibm.dao.Doa1;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("uniqueid");
		String password  = request.getParameter("password");
		String login = request.getParameter("loginaccount");
		Customer a = new Customer();
		a.setId(Integer.parseInt(id));
		a.setPassword(password);
		ServiceClass ms = new ServiceClass();
		try {
		if(login!=null) {
			int m = ms.login(a);
			if(m==0) {
				request.setAttribute("message", " DO NOT MATCH");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			else {
				request.getSession().setAttribute("sid", id);
				request.getSession().setAttribute("spass", password);
				response.sendRedirect("Menu.jsp");
			}
			
		}
		}catch(SQLException e) {
			System.out.println("Error logging in: "+e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error logging driver: "+e.getMessage());
		}
	}

}

package com.ibm.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.bean.Customer;

/**
 * Servlet implementation class CreateAccount
 */
@WebServlet("/CreateAccount")
public class CreateAccount extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer a = new Customer();
		ServiceClass ms = new ServiceClass();
		Date date = new Date();
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String uniqueid = request.getParameter("uniqueid");
		String startingbalance = request.getParameter("startingbalance");
		String create = request.getParameter("createaccount");
		a.setName(name);
		a.setId(Integer.parseInt(uniqueid));
		a.setPassword(password);
		a.setBalance(Integer.parseInt(startingbalance));
		a.setDate(date.toString());
		try {
			if(create!=null) {
				//service to create
				int m = ms.addAccount(a);
				String message="";
				if(m==1) {
					message="SUCCESSFULL";
				}
				else if(m==0) {
					message= "ID ALREADY EXISTS!!!";
				}
				request.setAttribute("message", message);
				request.getRequestDispatcher("index.jsp").forward(request, response);
				
			}
		}catch(SQLException e) {
			System.out.println("Error while creating account " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Error while creating class "+e.getMessage());
		}
		
	}

}

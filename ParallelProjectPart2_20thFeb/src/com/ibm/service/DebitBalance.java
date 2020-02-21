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
 * Servlet implementation class DebitBalance
 */
@WebServlet("/DebitBalance")
public class DebitBalance extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String debitbalance = request.getParameter("debitholder");
		String debitbutton  = request.getParameter("debitbutton");
		Customer a = new Customer();
		Date date = new Date();
		a.setId(Integer.parseInt(request.getSession().getAttribute("sid").toString()));
		a.setBalance(Integer.parseInt(debitbalance));
		a.setDate(date.toString());
		ServiceClass ms = new ServiceClass();
		try {
		if(debitbutton!=null) {
			//service to deduct balance
			//service to show balance
			int m = ms.withdraw(a);
			if(m==1) {
				StringBuilder sb = new StringBuilder();
				sb.append("WITHDRAW SUCCESSFULL!!! \nYour updated balance: ");
				sb.append(ms.balanceCheck(a));
				request.setAttribute("message",sb.toString() );
				request.getRequestDispatcher("Menu.jsp").forward(request, response);
			}
			else {
				request.setAttribute("message","WITHDRAW AMOUNT CANNOT BE MOER THANE BALANCE AMOUNT INVALID!");
				request.getRequestDispatcher("Menu.jsp").forward(request, response);
			}
		}
		}catch(SQLException e) {
			System.out.println("Error while debit: "+e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error while debit driver: "+e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

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
 * Servlet implementation class CreditBalance
 */
@WebServlet("/CreditBalance")
public class CreditBalance extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String creditbalance = request.getParameter("creditholder");
		String creditbutton  = request.getParameter("creditbutton");
		Customer a  = new Customer();
		Date date = new Date();
		ServiceClass ms = new ServiceClass();
		a.setBalance(Integer.parseInt(creditbalance));
		a.setId(Integer.parseInt(request.getSession().getAttribute("sid").toString()));
		a.setDate(date.toString());
		try {
		if(creditbutton!=null) {
			//service to add balance
			//service to show balance
			int m = ms.deposit(a);
			if(m==1) {
				StringBuilder sb = new StringBuilder();
				sb.append("DEPOSIT SUCCESSFULL!! Your updated balance: ");
				sb.append(ms.balanceCheck(a));
				request.setAttribute("message",sb.toString() );
				request.getRequestDispatcher("Menu.jsp").forward(request, response);
			}
		}
		}catch(SQLException e) {
			System.out.println("Error while credit: "+e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error while credit driver: "+e.getMessage());
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

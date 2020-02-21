package com.ibm.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.bean.Customer;

/**
 * Servlet implementation class Menu
 */
@WebServlet("/Menu")
public class Menu extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String credit = request.getParameter("creditbalance");
		String debit = request.getParameter("debitbalance");
		String viewbalance = request.getParameter("viewbalance");
		String fundtransfer = request.getParameter("fundtransfer");
		String viewtransactions = request.getParameter("viewtransactions");
		String logout = request.getParameter("logout");
		Customer a = new Customer();
		a.setId(Integer.parseInt(request.getSession().getAttribute("sid").toString()));
		a.setPassword(request.getSession().getAttribute("spass").toString());
		ServiceClass ms = new ServiceClass();
		try {
		if(credit!=null) {
			response.sendRedirect("CreditBalance.jsp");
		}
		else if(debit!=null) {
			response.sendRedirect("DebitBal.jsp");
		}
		else if(viewbalance!=null) {
			//service to view balance
			int m = ms.balanceCheck(a);
			StringBuilder sb = new StringBuilder("Your balance is "); 
			sb.append(m);
			request.setAttribute("message",sb.toString() );
			request.getRequestDispatcher("Menu.jsp").forward(request, response);
		}
		else if(fundtransfer!=null) {
			response.sendRedirect("FundTransfer.jsp");
		}
		else if(viewtransactions!=null) {
			//service to view all transactions
			ArrayList<String> al = ms.allTransactions(a);
			StringBuilder sb = new StringBuilder("");
			for(String str:al) {
				sb.append(str + System.lineSeparator());
				
			}
			request.setAttribute("message",sb.toString());
			request.getRequestDispatcher("Menu.jsp").forward(request, response);
		}
		else if(logout!=null) {
			request.getSession().setAttribute("sid", null);
			request.getSession().invalidate();
			request.setAttribute("message1","LOGGED OUT");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		}catch(SQLException e) {
			System.out.println("Error in Menu: "+e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error in Menu Driver: "+e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

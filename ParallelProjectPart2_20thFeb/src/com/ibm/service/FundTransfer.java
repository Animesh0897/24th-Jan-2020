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
 * Servlet implementation class FundTransfer
 */
@WebServlet("/FundTransfer")
public class FundTransfer extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String reid = request.getParameter("receiverid");
		String bal = request.getParameter("balancetransfer");
		String transfer = request.getParameter("transferbutton");
		Date date = new Date();
		Customer a = new Customer();
		Customer b = new Customer();
		a.setId(Integer.parseInt(request.getSession().getAttribute("sid").toString()));
		a.setBalance(Integer.parseInt(bal));
		a.setDate(date.toString());
		b.setId(Integer.parseInt(reid));
		b.setBalance(Integer.parseInt(bal));
		b.setDate(date.toString());
		ServiceClass ms = new ServiceClass();
		try {
			if (transfer != null) {
				
			
				if (ms.checkID(b)) {
					int balan = ms.balanceCheck(a);
					int m = ms.withdraw(a);
					if (m == 1) {
						StringBuilder sb = new StringBuilder();
						ms.deposit(b);
						sb.append("FUND TRANSFER IS SUCCESSFULL /nYour balance after transfer is : ");
						sb.append(ms.balanceCheck(a));
						request.setAttribute("message", sb.toString());
						request.getRequestDispatcher("Menu.jsp").forward(request, response);
					} else {
						request.setAttribute("message", "INVALID/nWithdraw amount more than balance");
						request.getRequestDispatcher("Menu.jsp").forward(request, response);
					}
				} else {
					request.setAttribute("message", "INVALID!\nENTERED ID DOESNT EXIST");
					request.getRequestDispatcher("Menu.jsp").forward(request, response);
				}
			}

		} catch (SQLException e) {
			System.out.println("Error while fund transfer: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error while fund transfer driver: " + e.getMessage());
		}
	}
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}

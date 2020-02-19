package com.ibm.training;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Welcome")
public class Welcome extends HttpServlet {
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(false); //to retrive the login session
		response.setContentType("text/html");
		if(session!=null) {
			//String email = (String) session.getAttribute("email");
			response.getWriter().println("Welcome User " + (String)session.getAttribute("name") +" successfully logged in: ");
			//above statement  will  returns the current session if session exists and if there's no valid session, a new session  will not be created,  it  will return null.
			response.getWriter().print("<br/><a href=\"logout\">LOGOUT!</a>");
		}
		else {
			response.sendRedirect("index.html");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}

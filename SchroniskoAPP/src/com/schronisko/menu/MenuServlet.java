package com.schronisko.menu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public MenuServlet() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 if (request.getParameter("b1") != null) {
			 response.sendRedirect("http://localhost:8080/SchroniskoAPP/dodaj.jsp"); 
	        } else if (request.getParameter("b2") != null) {
	        	response.sendRedirect("http://localhost:8080/SchroniskoAPP/usun.jsp");
	        } else if (request.getParameter("b3") != null) {
	        	response.sendRedirect("http://localhost:8080/SchroniskoAPP/index.jsp");
	}

}}

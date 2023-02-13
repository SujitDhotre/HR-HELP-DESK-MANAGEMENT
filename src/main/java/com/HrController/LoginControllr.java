package com.HrController;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HR.dao.Emp_dao;

/**
 * Servlet implementation class LoginControllr
 */
@WebServlet("/LoginControllr")
public class LoginControllr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginControllr() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
	
			
			
			try {
				if(Emp_dao.Login(email, pass)){
					
					RequestDispatcher rd=request.getRequestDispatcher("home.html");
					rd.forward(request, response);
				}
				else
				{
					pw.print("something went Wrong...!");
					RequestDispatcher rd=request.getRequestDispatcher("Login.html");
					rd.include(request, response);

					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	}


package com.HrController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HR.dao.Emp_dao;
import HR.bo.Emp_bo;

/**
 * Servlet implementation class SignupController
 */
@WebServlet("/SignupController")
public class SignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String pass=request.getParameter("password");
		String doj=request.getParameter("doj");
		
		
	
		Emp_bo em=new Emp_bo();
		em.setName(name);
		em.setEmail(email);
		em.setPhone(phone);
		em.setPassword(pass);
		em.setDoj(doj);
		
		
		int status =Emp_dao.signup(em);
		if(status>0)
		{
			RequestDispatcher rd=request.getRequestDispatcher("home.html");
			rd.forward(request, response);
		}
		else
		{
			pw.print("<h1>chukalay bhava</h1>");
		}
		
		
		
	}

}


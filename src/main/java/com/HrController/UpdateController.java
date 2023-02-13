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
 * Servlet implementation class UpdateController
 */
@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() {
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
		
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String pass=request.getParameter("password");
		String doj=request.getParameter("date");
		
		
		
		
		
		
		Emp_bo eb=new Emp_bo();
		eb.setId(id);
		eb.setName(name);
		eb.setEmail(email);
		eb.setPhone(phone);
		eb.setPassword(pass);
		eb.setDoj(doj);
		int status =Emp_dao.Update(eb);
		if(status>0)
		{
			RequestDispatcher rd=request.getRequestDispatcher("EmployeeController");
			rd.forward(request, response);
		}
		
	}

}

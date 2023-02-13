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
import HR.bo.Enquiry_bo;

/**
 * Servlet implementation class EnqController
 */
@WebServlet("/EnqController")
public class EnqController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnqController() {
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
		
		String desc=request.getParameter("desc");
		String date=request.getParameter("date");
		
		Enquiry_bo eb=new Enquiry_bo();
		eb.setName(name);
		eb.setEmail(email);
		eb.setDesc(desc);
		eb.setDate(date);
		int status=Emp_dao.enq(eb);
		
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
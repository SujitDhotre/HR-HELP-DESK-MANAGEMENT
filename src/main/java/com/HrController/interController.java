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
import HR.bo.Interviwe_bo;

/**
 * Servlet implementation class interController
 */
@WebServlet("/interController")
public class interController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public interController() {
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
		String edu=request.getParameter("edu");
		String email=request.getParameter("email");
		String date=request.getParameter("date");
		String mode=request.getParameter("mode");
		
		
		Interviwe_bo im=new Interviwe_bo();
		im.setName(name);
		im.setEdu(edu);
		im.setEmail(email);
		im.setDate_time(date);
		im.setMode(mode);
		
		
		int status=Emp_dao.inter(im);
		
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

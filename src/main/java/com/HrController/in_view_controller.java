package com.HrController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HR.dao.Emp_dao;
import HR.bo.*;

/**
 * Servlet implementation class in_view_controller
 */
@WebServlet("/in_view_controller")
public class in_view_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public in_view_controller() {
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
		pw.write("<link rel='stylesheet' type='text/css' href='css/table.css'>");
		
		pw.write(" <h1>All Interview</h1>");
		pw.print("<center>");
	pw.write("<a href='home.html'> <button class='btn'>HOME</button></a>");
	
		pw.print("<table>");
		 pw.print("<tr> <th> Id </th> <th> Name </th> <th> Email </th> <th> Education </th> <th> Mode of Interview </th><th> Date  </th></tr>");
		try {
			
			List<Interviwe_bo> list =Emp_dao.getAllInter();
			for(Interviwe_bo im:list) {
				  
				   pw.print("<tr><td>"+im.getId()+"</td><td>"+im.getName()+"</td><td>"+im.getEmail()+"</td><td>"+im.getEdu()+"</td><td>"+im.getMode()+"</td><td>"+im.getDate()+"</td></tr>"); 
				  
			  }
			 pw.print("</table>");
			 
			  pw.print("<center>");
			
		}catch(Exception e)
		{
			System.out.print(e);
		}
	}

}
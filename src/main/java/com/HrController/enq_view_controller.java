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
import HR.bo.Enquiry_bo;
import HR.bo.Interviwe_bo;

/**
 * Servlet implementation class enq_view_controller
 */
@WebServlet("/enq_view_controller")
public class enq_view_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public enq_view_controller() {
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
		pw.write(" <h1>All Enquiry's</h1>");
		pw.print("<center>");
	pw.write("<a href='home.html'> <button class='btn'>HOME</button></a>");
	
		pw.print("<table>");
		 pw.print("<tr> <th> Id </th> <th> Name </th> <th> Email </th> <th> Discreption </th><th> Date  </th></tr>");
		try {
			List <Enquiry_bo> list =Emp_dao.getAllEnq();
			for(Enquiry_bo im:list) {
				  
				   pw.print("<tr><td>"+im.getId()+"</td><td>"+im.getName()+"</td><td>"+im.getEmail()+"</td><td>"+im.getDesc()+"</td><td>"+im.getDate()+"</td></tr>"); 
				  
			  }
			pw.print("</center>");
			
			
		}catch(Exception e)
		{
			
		}
		
	}

}
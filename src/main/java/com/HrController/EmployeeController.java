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
import HR.bo.Emp_bo;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeController() {
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
		pw.write(" <h1>All Employee's</h1>");
		pw.print("<center>");
	pw.write("<a href='home.html'> <button class='btn'>HOME</button></a>");
	;
		pw.print("<table>");
		 pw.print("<tr> <th> Id </th> <th> Name </th> <th> Email </th> <th> Phone </th> <th> Password </th><th> Date of joining </th><th>Action</th>   </tr>");
		  try {
			List<Emp_bo> list= Emp_dao.getAllEmployee();
			
			
			
			for(Emp_bo eb:list) {
				  
				   pw.print("<tr><td>"+eb.getId()+"</td><td>"+eb.getName()+"</td><td>"+eb.getEmail()+"</td><td>"+eb.getPhone()+"</td><td>"+eb.getPassword()+"</td><td>"+eb.getDoj()+"</td><td><a href='EditServlete?id="+eb.getId() +"'>Edit </a> </td></tr>"); 
				  
			  }
			
			  pw.print("</table>");
			 
			  pw.print("</center>");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  


		
		
	}

}
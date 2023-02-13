package com.HrController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HR.dao.Emp_dao;
import HR.bo.Emp_bo;

/**
 * Servlet implementation class EditServlete
 */
@WebServlet("/EditServlete")
public class EditServlete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		 PrintWriter pw=response.getWriter();
		
		 
	      String id=request.getParameter("id");
          
	      int eid= Integer.parseInt(id);
	    
	      Emp_bo eb= Emp_dao.getElementByid(eid);
	    
		 
		pw.print("<form  action='UpdateController' method='post'> ");
	    
		pw.print("<table>");
		
		pw.print("<tr><td></td><td><input type='hidden' name='id' value='"+eb.getId()+"'/></td></tr>");  
		pw.print("<tr><td>Name: </td> <td><input type='text' name='name' value='"+eb.getName()+"'/></td></tr>");
	   	pw.print("<tr><td>Email: </td> <td><input type='text' name='email' value='"+eb.getEmail()+"'/></td></tr>");
	   	pw.print("<tr><td>Phone:</td> <td><input type='text' name='phone' value='"+eb.getPhone()+"'/></td></tr>");
	   	pw.print("<tr><td>PassWord:</td> <td><input type='text' name='password' value='"+eb.getPassword()+"'/></td></tr>");

	   	pw.print("<tr><td>Date of Joining : </td> <td><input type='text' name='date' value='"+eb.getDoj()+"'/></td></tr>");
		
	    pw.print("<tr><td><input type='submit' value='Edit '/></td></tr>"); 
	    
	   	pw.print("</table>");
		
		pw.print("</form>");
		
	}

}

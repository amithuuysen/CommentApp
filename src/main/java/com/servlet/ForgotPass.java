package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ForgotPass")
public class ForgotPass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String email = request.getParameter("email");
		String secret = request.getParameter("secret");
		String filter = "Amithu";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/commentapp","root","1234");
			
			String query = "select * from credentials where mail=? and secret=?";
			
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, secret);
			
			ResultSet resultSet = preparedStatement.executeQuery();
 
			if(resultSet.next())
			{
				HttpSession session = request.getSession();
				session.setAttribute("email", email);
				session.setAttribute("filter", filter);
				response.sendRedirect("commentpage.jsp");
			}
			else
			{
				PrintWriter out = response.getWriter();  
				response.setContentType("text/html");  
				out.println("<script type=\"text/javascript\">");  
				out.println("alert('Incorrect Email or Secret Code');");
				//out.println("location='signin.html';");
				out.println("</script>");
				RequestDispatcher rd=request.getRequestDispatcher("forgotpass.html");
				rd.include(request, response);
				
			}
			connection.close();
			
		}
		catch(Exception e)
		{
			//ToDo
		}
	}

}

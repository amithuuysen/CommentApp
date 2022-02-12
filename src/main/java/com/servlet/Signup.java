package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String secret = request.getParameter("secret");
		String filter = "Amithu";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/commentapp","root","1234");
			
			
			String query = "insert into credentials values(?,?,?)";
			String queryCheck = "select * from credentials where mail=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			PreparedStatement preparedStatementCheck = connection.prepareStatement(queryCheck);
			
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, secret);
			
			preparedStatementCheck.setString(1, email);
			
			ResultSet resultSet = preparedStatementCheck.executeQuery();
			
			if(resultSet.next())
			{
				//ToDo
				PrintWriter out = response.getWriter();  
				response.setContentType("text/html");  
				out.println("<script type=\"text/javascript\">");  
				out.println("alert('Account already exist! Please, try Sign In');");
				//out.println("location='signin.html';");
				out.println("</script>");
				RequestDispatcher rd=request.getRequestDispatcher("signup.html");
				rd.include(request, response);
			}
			else
			{
				preparedStatement.executeUpdate();
				HttpSession session = request.getSession();
				session.setAttribute("email", email);
				session.setAttribute("filter", filter);
				response.sendRedirect("commentpage.jsp");
			}
			
			connection.close();
			
		}
		catch(Exception e)
		{
			//
		}
	}

}

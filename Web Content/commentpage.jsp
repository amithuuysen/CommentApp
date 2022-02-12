<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.servlet.http.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="commentpage.css" />
	<title>Comment App | Comment Page</title>
	<!--  <script type="text/javascript">
	function change() // no ';' here
	{
		var elem = document.getElementById("btn");
	    if (elem.value=="Filter")
	    {
	    	elem.value = "UnFilter";
	    }
	    else
	    {
	    	elem.value = "Filter";
	    }
	}
	</script>
	-->
</head>
<body>
	<h2>Comment Page</h2>
	<form class="logout" action="Logout" method="post" name="logoutForm">
		<div class="profile">
			<i>Welcome! ${email}</i>
			<Button>Logout</Button>
		</div>
	</form>
	<%
	
		response.setHeader("Cache-Control","no-cache");
	  	response.setHeader("Cache-Control","no-store");
	  	response.setHeader("Pragma","no-cache");
	  	response.setDateHeader ("Expires", 0);
	
		if(session.getAttribute("email")==null)
		{
			response.sendRedirect("signin.html");
		}
	%>
	
	<form class="comment" action="Comments" method="post">
		<label>What would you like to share with world?</label>
		<div>
			<textarea rows="1" cols="1" name="textarea"></textarea>
			<input type="submit"/>
		</div>
	</form>
	<form onsubmit="return change()">
		<div class="content-comment">
			<div class="header">
				<h3>Comments</h3>
				<input id="btn" type="submit" value="Filter"/>
			</div>
		</div>
		<div class="comments">
			<table class="table" align="center" cellpadding="4" cellspacing="4">
			<%
				String email=null;
			try{
				email = session.getAttribute("email").toString();
			}
			catch(Exception e)
			{
				//
			}
				if(session.getAttribute("filter")=="Amithu")
				{
				try
				{
				Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/commentapp","root","1234");
				
				String query = "select * from comments";
				
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				ResultSet resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next())
				{
			%>
				
				<tr>
					<td style="width: 30%;"><%=resultSet.getString(1) %></td>
					<td style="border: solid 1px #000;"><%=resultSet.getString(2) %></td>
				</tr>
			<%
				session.setAttribute("filter", "Uysen");
				}
				}catch(Exception e)
				{
					//
				}
				}
				else
				{
				try
				{
				Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/commentapp","root","1234");
				
				String query = "select * from comments where mail=?";
				
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				
				preparedStatement.setString(1, email);
				ResultSet resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next())
				{
			%>
				
				<tr>
					<td style="width: 30%;"><%=resultSet.getString(1) %></td>
					<td style="border: solid 1px #000;"><%=resultSet.getString(2) %></td>
				</tr>
			<%
				session.setAttribute("filter", "Amithu");
				}
				}catch(Exception e)
				{
					//
				}
				}
			%>
			</table>
		</div>
	</form>
</body>
</html>
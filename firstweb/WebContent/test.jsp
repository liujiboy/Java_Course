<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<td>id</td>
		<td>name</td>
	</tr>

<%
	String driverClass="com.mysql.jdbc.Driver";
	String jdbcURL="jdbc:mysql://localhost/test1?useUnicode=true&characterEncoding=UTF-8";
	String user="root";
	String pwd="CquJava2018";
	Class.forName(driverClass);
	Connection conn=DriverManager.getConnection(jdbcURL, user, pwd);
	PreparedStatement ps=conn.prepareStatement("select id,name from user");
	ResultSet rs=ps.executeQuery();
	while(rs.next())
	{
%>
	<tr>
		<td><%=rs.getString(1) %></td>
		<td><%=rs.getString(2) %></td>
	</tr>
<%
	}
	rs.close();
	ps.close();
	conn.close();
%>
</table>
</body>
</html>
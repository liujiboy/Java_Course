<%@ page language="java" contentType="text/html; charset=gb2312"

	pageEncoding="gb2312" import="java.io.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=gb2312">

<title>request对象的使用</title>

</head>

<body>

Request对象的信息：

<hr>

<%

	out.println("<br> getMethod:");

	out.println(request.getMethod());

	out.println("<br>getParameter:");

	out.println(request.getParameter("name"));



	out.println("<br>getAttributeNames:");

	java.util.Enumeration e = request.getAttributeNames();

	while (e.hasMoreElements())

		out.println(e.nextElement());



	out.println("<br>getCharacterEncoding:");

	out.println(request.getCharacterEncoding());

	out.println("<br>getContentLength: ");

	out.println(request.getContentLength());

	out.println("<br>getContentType:");

	out.println(request.getContentType());

	out.println("<br>getLocale:");

	out.println(request.getLocale());

	out.println("<br>getProtocol:");

	out.println(request.getProtocol());

	out.println("<br>getRemoteAddr:");

	out.println(request.getRemoteAddr());

	out.println("<br>getRemoteHost:");

	out.println(request.getRemoteHost());

	out.println("<br>getRemoteUser:");

	out.println(request.getRemoteUser());

	out.println("<br>getServerName:");

	out.println(request.getServerName());

	out.println("<br>getServerPort:");

	out.println(request.getServerPort());

	out.println("<br>getSession:");

	out.println(request.getSession(true));

	out.println("<br>getHeader('User-Agent')");

	out.println(request.getHeader("User-Agent"));

%>

</body>

</html>


<%@ page language="java" contentType="text/html; charset=gb2312"

	pageEncoding="gb2312"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=gb2312">

<title>理解JSP工作原理</title>

</head>

<body>

<h1>

<%

	int times = Integer.parseInt(request.getParameter("times"));

	for (int i = 0; i < times; i++) {

		out.println("Hello, World!");

		out.println("<br/>");

	}

%>

</h1>

</body>

</html>


<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>创建Session</title>
</head>
<body>
<%
	session.setAttribute("value", new Date());
%>
<p>Session已经创建</p>
<p>访问<a href="index.jsp">其他页面</a></p>
</body>
</html>
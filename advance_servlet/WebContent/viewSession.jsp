<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看Session</title>
</head>
<body>
<%
	if(session.getAttribute("value")==null)
	{
		
%>
<p>session尚未创建，请访问<a href="createSession.jsp">createSession.jsp</a></p>
<%
	}
	else
	{
%>
<p>session已经创建，session.getAttribute("value")的值为:<%=session.getAttribute("value") %></p>
<%
	}
%>
</body>
</html>
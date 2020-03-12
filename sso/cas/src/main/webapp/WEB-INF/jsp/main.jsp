<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>main</title>
</head>
<body>
<%
	Cookie cookies[]=request.getCookies();
	for(Cookie cookie:cookies)
	{
		out.println(cookie.getName()+"="+cookie.getValue()+"<br>");
	}
%>
<p><a href="http://localhost:8080/app1/view.do">子系统1</a></p>
<p><a href="http://localhost:8080/app2/view.do">子系统2</a></p>

</body>
</html>
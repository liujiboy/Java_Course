<%@ page language="java" contentType="text/html; charset=gb2312"

	pageEncoding="gb2312"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=gb2312">

<title>网站计数器</title>

</head>

<body>

欢迎你，你是第

<%=request.getAttribute("hitCount")%>

位访问本网站的用户！

</body>

</html>


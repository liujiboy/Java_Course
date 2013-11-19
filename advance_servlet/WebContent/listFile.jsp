<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示文件</title>
</head>
<body>
<p>显示服务器目录/Users/liuji/upload目录下的所有文件</p>
<%
	File dir=new File("/Users/liuji/upload");
	for(File file:dir.listFiles())
	{
%>
<pre>
<%=file.getName() %>  <a href="download?path=<%=URLEncoder.encode(file.getAbsolutePath(),"UTF-8")%>">下载</a>
</pre>
<%
	}
%>
</body>
</html>
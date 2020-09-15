<%@ page language="java" pageEncoding="GB18030"%>
<%@page import="db.StudentManager"%>
<%@page import="db.Student"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<link href="style.css" " rel="stylesheet" type="text/css">
<title>查看学生信息</title>
</head>
<body>
<%
	String id = request.getParameter("id");
	Student student = StudentManager.getStudent(id);
%>
<div align="center">
<table width="500" cellpadding="1" cellspacing="1">
	<tr>
		<td colspan="9" align="center" class="title" height="30">学生信息</td>
	</tr>
	<tr height="30">
		<td align="center" class="header" width="100">学号：</td>
		<td align="center" class="data"><%=student.getId()%></td>
	</tr>
	<tr height="30">
		<td align="center" class="header" width="100">姓名：</td>
		<td align="center" class="data"><%=student.getName()%></td>
	</tr>
	<tr height="30">
		<td align="center" class="header" width="100">年龄：</td>
		<td align="center" class="data"><%=student.getAge()%></td>
	</tr>
	<tr height="30">
		<td align="center" class="header" width="100">性别：</td>
		<td align="center" class="data"><%=(student.getSex() == 1 ? "男" : "女")%>
		</td>
	</tr>
	<tr height="30">
		<td align="center" class="header" width="100">专业：</td>
		<td align="center" class="data"><%=student.getMajor()%></td>
	</tr>
	<tr height="30">
		<td align="center" class="header" width="100">学院：</td>
		<td align="center" class="data"><%=student.getCollege()%></td>
	</tr>
	<tr height="30">
		<td align="center" class="header" width="100">简介：</td>
		<td align="left" class="data"><%=student.getIntroduction()%></td>
	</tr>
</table>
</div>
</body>
</html>

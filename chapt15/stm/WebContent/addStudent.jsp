<%@ page language="java" pageEncoding="GB18030"%>
<%@page import="db.StudentManager"%>
<%@page import="db.Student"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<link href="style.css" " rel="stylesheet" type="text/css">
<title>添加学生信息</title>
</head>
<body>
<div align="center">
<form action="addStudent" method="post">
<table width="500" cellpadding="1" cellspacing="1">
	<tr>
		<td colspan="9" align="center" class="title" height="30">学生信息</td>
	</tr>
	<tr height="30">
		<td align="center" class="header">学号：</td>
		<td align="center" class="data"><input name="id"></td>
	</tr>
	<tr height="30">
		<td align="center" class="header">姓名：</td>
		<td align="center" class="data"><input name="name"></td>
	</tr>
	<tr height="30">
		<td align="center" class="header">年龄：</td>
		<td align="center" class="data"><input name="age"></td>
	</tr>
	<tr height="30">
		<td align="center" class="header">性别：</td>
		<td align="center" class="data"><select name="sex">
			<option value="1">男</option>
			<option value="0">女</option>
		</select></td>
	</tr>
	<tr height="30">
		<td align="center" class="header">专业：</td>
		<td align="center" class="data"><input name="major"></td>
	</tr>
	<tr height="30">
		<td align="center" class="header">学院：</td>
		<td align="center" class="data"><input name="college"></td>
	</tr>
	<tr height="30">
		<td align="center" class="header">简介：</td>
		<td align="left" class="data"><textarea rows="10" cols="50"
			name="introduction"></textarea></td>
	</tr>
</table>
<input type="submit" value="提交"></form>
</div>
</body>
</html>

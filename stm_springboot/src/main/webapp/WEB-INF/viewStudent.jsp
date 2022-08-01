<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link href="style.css" rel="stylesheet" type="text/css">
<title>查看学生信息</title>
</head>
<body>
<div align="center">
<table width="500" cellpadding="1" cellspacing="1">
	<tr>
		<td colspan="9" align="center" class="title" height="30">学生信息</td>
	</tr>
	<tr height="30">
		<td align="center" class="header" width="100">学号：</td>
		<td align="center" class="data">${student.id }</td>
	</tr>
	<tr height="30">
		<td align="center" class="header" width="100">姓名：</td>
		<td align="center" class="data">${student.name }</td>
	</tr>
	<tr height="30">
		<td align="center" class="header" width="100">年龄：</td>
		<td align="center" class="data">${student.age }</td>
	</tr>
	<tr height="30">
		<td align="center" class="header" width="100">性别：</td>
		<td align="center" class="data">
			<c:if test="${student.sex==1 }">
			男
			</c:if>
			<c:if test="${student.sex!=1 }">
			女
			</c:if>
		</td>
	</tr>
	<tr height="30">
		<td align="center" class="header" width="100">专业：</td>
		<td align="center" class="data">${student.major }</td>
	</tr>
	<tr height="30">
		<td align="center" class="header" width="100">学院：</td>
		<td align="center" class="data">${student.college }</td>
	</tr>
	<tr height="30">
		<td align="center" class="header" width="100">简介：</td>
		<td align="center" class="data">${student.introduction }</td>
	</tr>
</table>
</div>
</body>
</html>

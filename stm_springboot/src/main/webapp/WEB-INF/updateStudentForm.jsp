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
<form action="updateStudent.do" method="post">
<table width="500" cellpadding="1" cellspacing="1">
	<tr>
		<td colspan="9" align="center" class="title" height="30">学生信息</td>
	</tr>
	<tr height="30">
		<td align="center" class="header">学号：</td>
		<td align="center" class="data"><input name="id"
			value="${student.id }" readonly></td>
	</tr>
	<tr height="30">
		<td align="center" class="header">姓名：</td>
		<td align="center" class="data"><input name="name"
			value="${student.name }"></td>
	</tr>
	<tr height="30">
		<td align="center" class="header">年龄：</td>
		<td align="center" class="data"><input name="age"
			value="${student.age }"></td>
	</tr>
	<tr height="30">
		<td align="center" class="header">性别：</td>
		<td align="center" class="data">
			<select name="sex">
				<c:if test="${student.sex==1}">
					<option value="1" selected="selected">男</option>
					<option value="0">女</option>
				</c:if>
				<c:if test="${student.sex!=1}">
					<option value="1" >男</option>
					<option value="0" selected="selected">女</option>
				</c:if>
			</select>
		</td>
	</tr>
	<tr height="30">
		<td align="center" class="header">专业：</td>
		<td align="center" class="data"><input name="major"
			value="${student.major }"></td>
	</tr>
	<tr height="30">
		<td align="center" class="header">学院：</td>
		<td align="center" class="data"><input name="college"
			value="${student.college }"></td>
	</tr>
	<tr height="30">
		<td align="center" class="header">简介：</td>
		<td align="left" class="data"><textarea rows="10" cols="50"
			name="introduction">${student.introduction }</textarea></td>
	</tr>
</table>
<input type="submit" value="提交"></form>
</div>
</body>
</html>

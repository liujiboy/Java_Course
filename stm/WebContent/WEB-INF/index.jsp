<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link href="style.css" rel="stylesheet" type="text/css">
<title>学生信息管理</title>
</head>
<body>
	<div align="center">

		<table width="600" cellpadding="1" cellspacing="1">
			<tr>
				<td colspan="9" align="right" height="30"><a
					href="addStudentForm.do">添加学生</a></td>
			</tr>
		</table>
		<table width="600" cellpadding="1" cellspacing="1">
			<tr>
				<td colspan="9" align="center" class="title" height="30">
					全部学生信息
				</td>
			</tr>
			<tr height="30">
				<td align="center" class="header">学号</td>
				<td align="center" class="header">姓名</td>
				<td align="center" class="header">年龄</td>
				<td align="center" class="header">性别</td>
				<td align="center" class="header">专业</td>
				<td align="center" class="header">学院</td>
				<td align="center" colspan="3" class="header">操作</td>
			</tr>
			<c:forEach items="${students}" var="student">
				<tr height="30">
					<td align="center" class="data">${student.id }</td>
					<td align="center" class="data">${student.name }</td>
					<td align="center" class="data">${student.age }</td>
					<td align="center" class="data">
						<c:if test="${student.sex==1 }">
								男
						</c:if> 
						<c:if test="${student.sex!=1 }">
								女
						</c:if>
					</td>
					<td align="center" class="data">${student.major }</td>
					<td align="center" class="data">${student.college }</td>
					<td align="center" class="data"><a
						href="viewStudent.do?id=${student.id }">查看</a></td>
					<td align="center" class="data"><a
						href="updateStudentForm.do?id=${student.id }">修改</a></td>
					<td align="center" class="data"><a
						href="deleteStudent.do?id=${student.id }">删除</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>

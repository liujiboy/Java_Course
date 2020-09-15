<%@ page language="java" pageEncoding="GB18030"%>
<%@page import="db.StudentManager"%>
<%@page import="db.Student"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<link href="style.css"" rel="stylesheet" type="text/css">
<title>学生信息管理</title>
</head>
<body>
<div align="center" >

<table width="600"  cellpadding="1" cellspacing="1">
<tr>
	<td colspan="9" align="right" height="30">
	<a href="addStudent.jsp">添加学生</a>
	</td>
</tr>
</table>
<table width="600"  cellpadding="1" cellspacing="1">
<tr>
	<td colspan="9" align="center" class="title" height="30">
	全部学生信息
	</td>
</tr>
<tr height="30">
	<td align="center" class="header">
	学号
	</td>
	<td align="center" class="header">
	姓名
	</td>
	<td align="center" class="header">
	年龄
	</td>
	<td align="center" class="header">
	性别
	</td>
	<td align="center" class="header">
	专业
	</td>
	<td align="center" class="header">
	学院
	</td>
	<td align="center" colspan="3" class="header">
	操作
	</td>
</tr>
<%
	ArrayList<Student> students=StudentManager.getAllStudents();
	for(Student student:students)
	{
 %>
 <tr height="30">
	<td align="center" class="data">
	<%=student.getId() %>
	</td>
	<td align="center" class="data">
	<%=student.getName() %>
	</td>
	<td align="center" class="data">
	<%=student.getAge() %>
	</td>
	<td align="center" class="data">
	<%=(student.getSex()==1?"男":"女") %>
	</td>
	<td align="center" class="data">
	<%=student.getMajor() %>
	</td>
	<td align="center" class="data">
	<%=student.getCollege() %>
	</td>
	<td align="center" class="data">
	<a href="viewStudent.jsp?id=<%=student.getId() %>">查看</a>
	</td>
	<td align="center" class="data">
	<a href="updateStudent.jsp?id=<%=student.getId() %>">修改</a>
	</td>
	<td align="center" class="data">
	<a href="deleteStudent?id=<%=student.getId() %>">删除</a>
</td>
</tr>
<%
	}
 %>
</table>
</div>
</body>
</html>

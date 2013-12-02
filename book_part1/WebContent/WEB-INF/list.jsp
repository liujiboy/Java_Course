<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示所有书籍</title>
</head>
<body>
<p><a href="book?op=add">添加书籍</a></p>
<p>下列表格显示所有书籍</p>
<table border="1" width="500">
	<tr>
		<td>序号</td><td>名称</td><td>价格（元）</td><td>介绍</td><td>图片</td><td>操作</td>
	</tr>
	<c:forEach items="${ books}" var="book">
	<tr>
		<td>${book.id }</td>
		<td>${book.name }</td>
		<td>${book.price }</td>
		<td>${book.des }</td>
		<td><img src="book?op=image&id=${book.id }" width="200"></td>
		<td>
			<a href="book?op=view&id=${book.id }">查看</a><br>
			<a href="book?op=edit&id=${book.id }">修改</a><br>
			<a href="book?op=delete&id=${book.id }">删除</a><br>
		</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>
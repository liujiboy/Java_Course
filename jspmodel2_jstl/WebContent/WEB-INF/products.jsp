<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示所有的商品</title>
</head>
<body>
<p>下列表格显示所有商品</p>
<table border="1" width="400">
	<tr>
		<td>序号</td><td>名称</td><td>价格（元）</td><td>介绍</td>
	</tr>
	<c:forEach items="${ products}" var="product">
	<tr>
		<td>${product.id }</td>
		<td>${product.name }</td>
		<td>${product.price }</td>
		<td>${product.des }</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>
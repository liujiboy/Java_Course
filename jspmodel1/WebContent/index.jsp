<%@page import="javabean.Product"%>
<%@page import="java.util.List"%>
<%@page import="javabean.ProductList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示所有的商品</title>
</head>
<body>
<%
	ProductList pList=new ProductList();
	List<Product> products=pList.getAllProducts();
%>
<p>下列表格显示所有商品</p>
<table border="1" width="400">
	<tr>
		<td>序号</td><td>名称</td><td>价格（元）</td><td>介绍</td>
	</tr>
	<%
		for(Product product:products)
		{
	%>
	<tr>
		<td style="background-color:red"><%=product.getId() %></td>
		<td><%=product.getName() %></td>
		<td><%=product.getPrice() %></td>
		<td><%=product.getDes() %></td>
	</tr>
	<%
		}
	%>
</table>
</body>
</html>
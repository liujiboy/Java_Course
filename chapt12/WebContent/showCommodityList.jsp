<%@ page language="java" contentType="text/html; charset=gb2312"

    pageEncoding="gb2312"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=gb2312">

<title>显示商品信息</title>

</head>

<body>

<jsp:useBean id="commodity" scope="page" class="code1202.CommodityInfoBean"/>

<h1>商品信息如下：</h1>

名称：<%=commodity.getName() %>

<br/>

价格：<%=commodity.getPrice() %>

<br/>

状态：<jsp:getProperty property="status" name="commodity"/>

<br/>

</body>

</html>


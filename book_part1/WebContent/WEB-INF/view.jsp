<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看书籍</title>
</head>
<body>
<p>序号：${book.id }</p>
<p>名称：${book.name }</p>
<p>价格：${book.price }</p>
<p>描述：${book.des }</p>
<p>图片：<img src="book?op=image&id=${book.id }" width="200"></p>
</body>
</html>
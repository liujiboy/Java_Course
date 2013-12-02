<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改书籍</title>
</head>
<body>
<form action="book?op=doEdit" method="post" enctype="multipart/form-data">
<p>序号：<input type="text" name="id" value="${book.id }" readonly></p>
<p>名称：<input type="text" name="name" value="${book.name }"></p>
<p>价格：<input type="text" name="price" value="${book.price }"></p>
<p>描述：<textarea name="des" cols="50" rows="10">${book.des }</textarea></p>
<p>图片：<input type="file" name="image"></p>
<input type="hidden" name="oldId" value="${book.id }"> 
<p><input type="submit" value="修改"></p>
</form>
</body>
</html>
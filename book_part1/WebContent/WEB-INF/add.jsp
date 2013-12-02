<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加书籍</title>
</head>
<body>
<form action="book?op=doAdd" method="post" enctype="multipart/form-data">
<p>序号：<input type="text" name="id"></p>
<p>名称：<input type="text" name="name"></p>
<p>价格：<input type="text" name="price"></p>
<p>描述：<textarea name="des" cols="50" rows="10"></textarea></p>
<p>图片：<input type="file" name="image"></p>
<p><input type="submit" value="提交"></p>
</form>
</body>
</html>
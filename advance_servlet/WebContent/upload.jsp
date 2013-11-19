<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传页面</title>
</head>
<body>
<p>上传文件到服务器</p>
<form action="upload" method="post" enctype="multipart/form-data">
<p>文件1：<input type="file" name="file1"></p>
<p>文件2：<input type="file" name="file2"></p>
<p>文件3：<input type="file" name="file3"></p>
<p><input type="submit" value="上传"></p>
</form>
</body>
</html>
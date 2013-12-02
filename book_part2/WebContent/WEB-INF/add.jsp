<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="scripts/jquery.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("form:first").submit(function(){
		$("#error").html("");
		var id=$("input[name='id']").val();
		var name=$("input[name='name']").val();
		var price=$("input[name='price']").val();
		var des=$("textarea[name='des']").val();
		var image=$("input[name='image']").val();
		if(id.length<=0||id.length>32)
			$("#error").append("<p>序号的长度必须大于0小于32</p>");
		var htmlobj=$.ajax({url:"book?op=exist&id="+id,async:false});
		if(htmlobj.responseText==1)
			$("#error").append("<p>序号已经存在</p>");;
		if(name.length<=0||name.length>200)
			$("#error").append("<p>名称的长度必须大于0小于200</p>");
		var doubleReg=/^[\-\+]?([0-9]\d*|0|[1-9]\d{0,2}(,\d{3})*)(\.\d+)?$/;
		if(!doubleReg.test(price))
			$("#error").append("<p>价格必须是数字</p>");
		if(des.length<=0||des.length>500)
			$("#error").append("<p>描述的长度必须大于0小于500</p>");
		if(image.length<=0)
			$("#error").append("<p>图片不能为空</p>");
		if($("#error").html().length>0)
			return false;
		else
			return true;
	});
});
</script>
<title>添加书籍</title>
</head>
<body>
<p id="error" style="color: red;"></p>
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
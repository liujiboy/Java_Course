<%@ page language="java" contentType="text/html; charset=gb2312"

	pageEncoding="gb2312" import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=gb2312">

<title>在response中使用Cookie</title>

</head>

<body>

<%

	String userName = "zhangsan";

	Cookie[] cookie = request.getCookies();

	Cookie cookie_response = null;

	List list = Arrays.asList(cookie);

	Iterator it = list.iterator();

	while (it.hasNext()) {

		Cookie temp = (Cookie) it.next();

		if (temp.getName().equals(userName + "_access_time")) {

			cookie_response = temp;

			break;

		}

	}



	out.println("当前的时间：" + new Date() + "<br>");

	if (cookie_response != null) {

		out.println("上一次访问的时间：" + cookie_response.getValue());

		cookie_response.setValue(new Date().toString());

	} else {

		cookie_response = new Cookie(userName + "_access_time",

				new Date().toString());

	}

	response.addCookie(cookie_response);

	response.setContentType("text/html");

	response.flushBuffer();

%>

</body>

</html>


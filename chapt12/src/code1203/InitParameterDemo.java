package code1203;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns = { "/initParameterDemo" }, 
		initParams = { 
				@WebInitParam(name = "appName", value = "第12章示例程序")
		})
public class InitParameterDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String appName;



	public void init() throws ServletException {

		appName = getInitParameter("appName");

	}



	protected void doGet(HttpServletRequest request,

			HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("gb2312");

		response.setContentType("text/html;charset=gb2312");

		PrintWriter out = response.getWriter();

		out.println("应用程序名是：");

		out.println(appName);

	}



	protected void doPost(HttpServletRequest request,

			HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);

	}



}

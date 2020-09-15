package code1203;

import java.io.IOException;

import java.io.PrintWriter;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

@WebServlet("/doPostDemo")
public class DoPostDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request,

			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("gb2312");

		response.setContentType("text/html;charset=gb2312");

		PrintWriter out = response.getWriter();

		out.println("获得了一下参数值：data=<br>" + request.getParameter("data"));

		out.flush();

	}


}

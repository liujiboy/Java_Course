package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value="*.do")
public class UserController extends HttpServlet  {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri=request.getRequestURI();
		if(uri.endsWith("/view.do"))
		{
			request.getRequestDispatcher("/WEB-INF/jsp/view.jsp").forward(request, response);;
		}else if(uri.endsWith("/logout.do"))
		{
			HttpSession session=request.getSession();
			session.invalidate();
		}
	}
	
}

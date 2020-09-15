package code1204;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/websiteCounter")
public class WebsiteCounter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static int count;

	protected void doGet(HttpServletRequest request,

			HttpServletResponse response) throws ServletException, IOException {

		count++;

		request.setAttribute("hitCount", count); // 将访问次数写入request中，以便传给JSP页面

		String url = "/websiteCounterInfo.jsp";

		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);

		rd.forward(request, response);

	}

}

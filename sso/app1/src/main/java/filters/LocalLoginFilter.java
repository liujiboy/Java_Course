package filters;

import java.io.IOException;

import cas.client.Constants;
import cas.client.filter.AbstractLocalLoginFilter;
import database.DB;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import domains.User;


/**
 * Servlet Filter implementation class LocalLoginFilter
 */
@WebFilter(filterName="F3",urlPatterns="/*")
public class LocalLoginFilter extends AbstractLocalLoginFilter implements
		Filter {

	/**
	 * @see AbstractLocalLoginFilter#AbstractLocalLoginFilter()
	 */
	public LocalLoginFilter() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	@Override
	protected void loginFail(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().println("登录失败");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected boolean doLogin(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			String userId = (String) session
					.getAttribute(Constants.LOCAL_USER_ID);
			User user=DB.getUser(userId);
			session.setAttribute("user", user);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

}

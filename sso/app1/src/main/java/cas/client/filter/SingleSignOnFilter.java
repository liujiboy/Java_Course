package cas.client.filter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cas.client.Constants;

/**
 * Servlet Filter implementation class SingleSignOnFilter
 */
@WebFilter(filterName="F2",urlPatterns="/*")
public class SingleSignOnFilter implements Filter {
	private String CAS_LOGIN_URL="http://localhost:8080/cas/login.do";
	private String CAS_USER_URL="http://localhost:8080/cas/getUser.do";

	/**
	 * Default constructor.
	 */
	public SingleSignOnFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();
		String CAS_ST = httpRequest.getParameter(Constants.CAS_ST);
		if (CAS_ST != null) {
			// CAS返回ST
			session.setAttribute(Constants.LOCAL_ST, CAS_ST);
			String LOCAL_SERVICE = httpRequest
					.getParameter(Constants.LOCAL_SERVICE);
			if (LOCAL_SERVICE != null && !LOCAL_SERVICE.equals(""))
				httpResponse.sendRedirect(LOCAL_SERVICE);
			else
				httpResponse.sendRedirect(httpRequest.getContextPath());
			return;
		} else {
			String LOCAL_ST = (String) session.getAttribute(Constants.LOCAL_ST);
			if (LOCAL_ST == null) {
				// 跳转到CAS登录
				httpResponse.sendRedirect(CAS_LOGIN_URL + "?"
						+ Constants.LOCAL_SERVICE + "="
						+ httpRequest.getRequestURL());
			} else {
				String LOCAL_USER_ID = (String) session
						.getAttribute(Constants.LOCAL_USER_ID);
				if (LOCAL_USER_ID == null) {
					// 获取LOCAL_USER_ID
					try {
						URL url = new URL(CAS_USER_URL + "?" + Constants.CAS_ST
								+ "=" + LOCAL_ST + "&host="
								+ httpRequest.getServerName() + "&app="
								+ httpRequest.getContextPath() + "&"
								+ Constants.LOCAL_SERVICE + "="
								+ httpRequest.getRequestURL() + "&sessionId="
								+ session.getId());
						System.out.println(url);
						BufferedReader reader = new BufferedReader(
								new InputStreamReader(url.openStream()));
						LOCAL_USER_ID = reader.readLine();
						reader.close();
						session.setAttribute(Constants.LOCAL_USER_ID,
								LOCAL_USER_ID);
					} catch (Exception e) {
						e.printStackTrace();
						// 跳转到CAS登录
						httpResponse.sendRedirect(CAS_LOGIN_URL + "?"
								+ Constants.LOCAL_SERVICE + "="
								+ httpRequest.getRequestURL());
					}

				}
				chain.doFilter(request, response);

			}
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
//		CAS_LOGIN_URL = fConfig.getInitParameter(Constants.CAS_LOGIN_URL);
//		CAS_USER_URL = fConfig.getInitParameter(Constants.CAS_USER_URL);
	}

}

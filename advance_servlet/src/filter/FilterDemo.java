package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/filter.jsp")
public class FilterDemo implements Filter {
    public FilterDemo() {
    }
	public void destroy() {
	}
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		out.print("<p>本段在filter.jsp执行之前输出</p>");
		chain.doFilter(request, response);
		out.print("<p>本段在filter.jsp执行之后输出</p>");
	}
	public void init(FilterConfig fConfig) throws ServletException {
	}

}

package controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cas.server.Constants;
import database.DB;
import domains.SessionStorage;
@WebServlet(value="/logout.do")
public class LogoutController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		session.invalidate();
		Cookie cookies[] = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(Constants.CAS_TGS)) {
					String CAS_TGS = cookie.getValue();
					String CAS_ST = CAS_TGS;
					cookie.setMaxAge(0);
					response.addCookie(cookie);
					List<SessionStorage> list =DB.findSessionStorage(CAS_ST);
							
					try {
						for (SessionStorage item : list) {
							URL url = new URL(item.getLocalService()
									+ "?logout=true&sessionId="
									+ item.getSessionId());
							BufferedReader reader = new BufferedReader(
									new InputStreamReader(url.openStream()));
							reader.readLine();
							reader.close();
						}
					} catch (Exception e) {
						e.printStackTrace();

					}
					DB.deleteSessionStorage(CAS_ST);
					DB.deleteServiceTicket(CAS_ST);
				}
			}
		}
		response.sendRedirect(request.getContextPath()+"/login.do");
	}

}

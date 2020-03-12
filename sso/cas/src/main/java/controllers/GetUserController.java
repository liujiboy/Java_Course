package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DB;
import domains.Mapping;
import domains.ServiceTicket;
@WebServlet(value="/getUser.do")
public class GetUserController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String CAS_ST=request.getParameter("CAS_ST");
		String host=request.getParameter("host");
		String app=request.getParameter("app");
		String LOCAL_SERVICE=request.getParameter("LOCAL_SERVICE");
		String sessionId=request.getParameter("sessionId");
		DB.addSessionStorage(LOCAL_SERVICE,CAS_ST,sessionId);
		ServiceTicket st = DB.findServiceTicketbySt(CAS_ST);
		Mapping mapping = DB.findMappingByHostAndAppAndCasUser(host,app,st.getUser());
		response.getWriter().println(mapping.getLocalUser());
	}

}

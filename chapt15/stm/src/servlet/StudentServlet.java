package servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import db.StudentManager;
public class StudentServlet extends HttpServlet {
	//处理GET请求
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//让GET和POST请求以相同的逻辑进行处理
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//设置编码为GB18030，否则会出现中文乱码
		request.setCharacterEncoding("GB18030");
		if (request.getRequestURI().endsWith("/deleteStudent")) {
			//处理对/deleteStudent的请求
			doDeleteStudent(request, response);
		} else if (request.getRequestURI().endsWith("/addStudent")) {
			//处理对/addStudent的请求
			doAddStudent(request, response);
		} else if (request.getRequestURI().endsWith("/updateStudent")) {
			//处理对/updateStudent的请求
			doUpdateStudent(request, response);
		}
	}

	//删除学生信息
	private void doDeleteStudent(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		StudentManager.deleteStudent(id);
		response.sendRedirect("index.jsp");
	}

	//添加学生信息
	private void doAddStudent(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String sex = request.getParameter("sex");
		String major = request.getParameter("major");
		String college = request.getParameter("college");
		String introduction = request.getParameter("introduction");
		StudentManager.addStudent(id, name, new Integer(age), new Integer(sex),
				major, college, introduction);
		response.sendRedirect("index.jsp");

	}

	//修改学生信息
	private void doUpdateStudent(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String sex = request.getParameter("sex");
		String major = request.getParameter("major");
		String college = request.getParameter("college");
		String introduction = request.getParameter("introduction");
		StudentManager.updateStudent(id, name, new Integer(age), new Integer(
				sex), major, college, introduction);
		response.sendRedirect("index.jsp");
	}
}

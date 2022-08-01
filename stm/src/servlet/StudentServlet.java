package servlet;

import java.io.IOException;
import java.util.ArrayList;

import dao.StudentDao;
import domain.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 处理GET请求
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 让GET和POST请求以相同的逻辑进行处理
		doPost(request, response);
	}
	//处理POST请求
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码为UTF-8，否则会出现中文乱码
		request.setCharacterEncoding("UTF-8");
		if (request.getRequestURI().endsWith("/index.do")) {
			// 处理对/index.do的请求
			index(request, response);
		} else if (request.getRequestURI().endsWith("/deleteStudent.do")) {
			// 处理对/deleteStudent.do的请求
			deleteStudent(request, response);
		} else if (request.getRequestURI().endsWith("/addStudentForm.do")) {
			// 处理对/addStudentForm.do的请求
			addStudentForm(request, response);
		} else if (request.getRequestURI().endsWith("/addStudent.do")) {
			// 处理对/addStudent.do的请求
			addStudent(request, response);
		} else if (request.getRequestURI().endsWith("/updateStudentForm.do")) {
			// 处理对/updateStudentForm.do的请求
			updateStudentForm(request, response);
		} else if (request.getRequestURI().endsWith("/updateStudent.do")) {
			// 处理对/updateStudent.do的请求
			updateStudent(request, response);
		} else if (request.getRequestURI().endsWith("/viewStudent.do")) {
			// 处理对/viewStudent.do的请求
			viewStudent(request, response);
		}
	}

	// 修改学生信息表单页
	private void updateStudentForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		Student student = StudentDao.getStudent(id);
		request.setAttribute("student", student);
		request.getRequestDispatcher("/WEB-INF/updateStudentForm.jsp").forward(request, response);
	}

	// 添加学生信息表单页
	private void addStudentForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/addStudentForm.jsp").forward(request, response);

	}

	// 首页
	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Student> students = StudentDao.getAllStudents();
		request.setAttribute("students", students);
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

	// 删除学生信息
	private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		StudentDao.deleteStudent(id);
		response.sendRedirect("index.do");
	}

	// 添加学生信息
	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String sex = request.getParameter("sex");
		String major = request.getParameter("major");
		String college = request.getParameter("college");
		String introduction = request.getParameter("introduction");
		StudentDao.addStudent(id, name, Integer.parseInt(age), Integer.parseInt(sex), major, college, introduction);
		response.sendRedirect("index.do");
	}

	// 修改学生信息
	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String sex = request.getParameter("sex");
		String major = request.getParameter("major");
		String college = request.getParameter("college");
		String introduction = request.getParameter("introduction");
		StudentDao.updateStudent(id, name, Integer.parseInt(age), Integer.parseInt(sex), major, college, introduction);
		response.sendRedirect("index.do");
	}

	// 查看学生信息
	private void viewStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		Student student = StudentDao.getStudent(id);
		request.setAttribute("student", student);
		request.getRequestDispatcher("/WEB-INF/viewStudent.jsp").forward(request, response);
	}
}

package stm.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import stm.dao.StudentDao;
import stm.domain.Student;
@Controller
public class StudentController {
	@Autowired
	private StudentDao studentDao;

	// 首页
	@RequestMapping("/index.do")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		Iterable<Student> students = studentDao.findAll();
		mv.addObject("students", students);
		mv.setViewName("/WEB-INF/index.jsp");
		return mv;
	}

	// 添加学生信息表单页
	@RequestMapping("/addStudentForm.do")
	public String addStudentForm() {
		return "/WEB-INF/addStudentForm.jsp";
	}

	// 修改学生信息表单页
	@RequestMapping("/updateStudentForm.do")
	public ModelAndView updateStudentForm(String id) {
		ModelAndView mv = new ModelAndView();
		Student student = studentDao.findById(id).get();
		mv.addObject("student", student);
		mv.setViewName("/WEB-INF/updateStudentForm.jsp");
		return mv;
	}

	// 查看学生信息
	@RequestMapping("/viewStudent.do")
	public ModelAndView viewStudent(String id) {
		ModelAndView mv = new ModelAndView();
		Student student = studentDao.findById(id).get();
		mv.addObject("student", student);
		mv.setViewName("/WEB-INF/viewStudent.jsp");
		return mv;
	}

	// 添加学生信息
	@RequestMapping("/addStudent.do")
	public String addStudent(Student student) {
		studentDao.save(student);
		return "redirect:/index.do";
	}

	// 修改学生信息
	@RequestMapping("/updateStudent.do")
	public String updateStudent(Student student) {
		studentDao.save(student);
		return "redirect:/index.do";
	}

	// 删除学生信息
	@RequestMapping("/deleteStudent.do")
	public String deleteStudent(String id) {
		studentDao.deleteById(id);
		return "redirect:/index.do";
	}

}

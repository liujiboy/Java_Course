package cn.edu.cqu;

import java.util.List;

import cn.edu.cqu.dao.StudentDao;
import cn.edu.cqu.domain.Student;

public class TestStudentDao {
	public static void main(String[] args) {
		StudentDao.addStudent("1", "foo1", 10, "1");
		StudentDao.addStudent("2", "foo2", 11, "1");
		StudentDao.addStudent("3", "foo3", 12, "1");
		StudentDao.addStudent("4", "bar1", 13, "2");
		List<Student> students = StudentDao.getAllStudents();
		for (Student s : students) {
			System.out.printf("id=%s,name=%s,age=%d,college.id=%s,college.name=%s\n", s.getId(), s.getName(), s.getAge(), s.getCollege().getId(),
					s.getCollege().getName());
		}
	}
}

package cn.edu.cqu.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import cn.edu.cqu.domain.College;
import cn.edu.cqu.domain.Student;
import cn.edu.cqu.util.HibernateUtil;

public class StudentDao {
	public static void addStudent(String id, String name, int age, String collegeId) {
		College college = CollegeDao.getCollegeById(collegeId);
		Student student = new Student();
		student.setId(id);
		student.setAge(age);
		student.setCollege(college);
		student.setName(name);
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(student);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public static List<Student> getAllStudents() {
		Session session = HibernateUtil.getSession();
		try {
			Query<Student> q=session.createQuery("from Student",Student.class);
			return q.list();
		} finally {
			session.close();
		}

	}
}

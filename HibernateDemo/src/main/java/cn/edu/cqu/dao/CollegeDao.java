package cn.edu.cqu.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.edu.cqu.domain.College;
import cn.edu.cqu.util.HibernateUtil;

public class CollegeDao {
	public static void addCollege(String id, String name) {
		College college = new College(id, name);
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(college);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public static College getCollegeById(String id) {
		Session session = HibernateUtil.getSession();
		try {
			return session.get(College.class, id);
		} finally {
			session.close();
		}

	}

	public static void deleteById(String id) {

		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		try {
			College college = session.get(College.class, id);
			session.delete(college);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
}

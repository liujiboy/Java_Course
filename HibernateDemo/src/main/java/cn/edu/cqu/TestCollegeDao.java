package cn.edu.cqu;


import cn.edu.cqu.dao.CollegeDao;
import cn.edu.cqu.domain.College;

public class TestCollegeDao {

	public static void main(String[] args) {
		CollegeDao.addCollege("1", "计算机学院");
		CollegeDao.addCollege("2", "通信学院");
		College college=CollegeDao.getCollegeById("2");
		System.out.printf("id=%s,name=%s\n",college.getId(),college.getName());
	}

}

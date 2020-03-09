package cn.edu.cqu;

import cn.edu.cqu.dao.CollegeDao;

public class TestDelete {

	public static void main(String[] args) {
		//删除id=1的学院，级联删除学生
		CollegeDao.deleteById("1");
		//删除id=2的学院，级联删除学生
		CollegeDao.deleteById("2");
	}

}

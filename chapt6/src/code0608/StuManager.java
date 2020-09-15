package code0608;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
//定义学生类
class Student {
	int id;// 学号
	String name; // 姓名
	String gender;// 性别
	Date birth; // 出生日期
	public Student(int id, String name, String gender, Date birth) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.birth = birth;
	}
	public String toString() {
		return id + "-" + name + "-" + gender + "-" + birth;
	}
}

//定义学生管理类
public class StuManager {
	int STU_NUM = 10;
	TreeMap stuList = new TreeMap();
	// 初始化学生信息
	void initStudents() {
		for (int i = 0; i < STU_NUM; i++) {
			int id = i;
			String name = "name" + (int) (Math.random() * 1000);
			String gender = "女";
			if (i % 2 == 0) {
				gender = "男";
			}
			// 随机生成出生日期
			Date birth = new Date(new Date().getTime()
					+ (long) (Math.random() * 1000000000000l));
			Student stu = new Student(id, name, gender, birth);
			stuList.put(id, stu);
		}
	}
	Student searchByID(int id) {
		Student stu = (Student) stuList.get(id);
		return stu;
	}

	// 按照日期进行排序,使用最简单的冒泡法
	List sortStudentByDate() {
		List stus = new ArrayList();
		// 把学生加入列表
		stus.addAll(stuList.values());
		// 使用冒泡法 对列表中的学生排序
		for (int i = 0; i < stus.size(); i++) {
			for (int j = 0; j < stus.size(); j++) {
				Student tmp1 = (Student) stus.get(i);
				Student tmp2 = (Student) stus.get(j);
				// 比较出生日期
				if (tmp1.birth.before(tmp2.birth)) {
					stus.set(i, tmp2);
					stus.set(j, tmp1);
				}
			}
		}
		return stus;
	}

	public static void main(String args[]) {
		StuManager manager = new StuManager();
		manager.initStudents();
		// 随机生成一个学号进行检索
		int id = (int) (Math.random() * 10);
		System.out.println("检索学号：" + id);
		Student stu = manager.searchByID(id);
		if (stu == null) {
			System.out.println("未检索到学生信息");
		} else
			System.out.println("检索到的学生信息是:" + stu);
		System.out.println("按照日期排序后的结果：");
		List l = manager.sortStudentByDate();
		// 遍历列表进行输出
		for (Iterator iterator = l.iterator(); iterator.hasNext();) {
			Student tmp = (Student) iterator.next();
			System.out.println(tmp);
		}
	}
}

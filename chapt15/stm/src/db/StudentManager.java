package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class StudentManager {
	//获取数据库连接
	private static Connection getConnection() throws Exception {
		//jdbc url地址
		String url = "jdbc:jtds:sqlserver://127.0.0.1:1433/pubs";
		//数据库用户名
		String user = "sa";
		//数据库密码
		String pwd = "";
		//数据库驱动名
		String driver = "net.sourceforge.jtds.jdbc.Driver";
		//加载数据库驱动
		Class.forName(driver);
		//获取数据库连接
		Connection conn = DriverManager.getConnection(url, user, pwd);
		return conn;
	}
	//添加学生信息
	public static boolean addStudent(String id, String name, int age, int sex,
			String major, String college, String introduction) {
		try {
			Connection conn = getConnection();
			PreparedStatement st = conn
					.prepareStatement("insert into student values(?,?,?,?,?,?,?)");
			st.setString(1, id);
			st.setString(2, name);
			st.setInt(3, age);
			st.setInt(4, sex);
			st.setString(5, major);
			st.setString(6, college);
			st.setString(7, introduction);
			st.execute();
			conn.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	//修改学生信息
	public static boolean updateStudent(String id, String name, int age,
			int sex, String major, String college, String introduction) {
		try {
			Connection conn = getConnection();
			PreparedStatement st = conn
					.prepareStatement("update student set name=?,age=?,sex=?,major=?,college=?,introduction=? where id=?");
			st.setString(1, name);
			st.setInt(2, age);
			st.setInt(3, sex);
			st.setString(4, major);
			st.setString(5, college);
			st.setString(6, introduction);
			st.setString(7, id);
			st.execute();
			conn.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	//删除学生信息
	public static boolean deleteStudent(String id) {
		try {
			Connection conn = getConnection();
			PreparedStatement st = conn
					.prepareStatement("delete student where id=?");
			st.setString(1, id);
			st.execute();
			conn.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	//按照学号查询学生信息
	public static Student getStudent(String id) {
		Student student = null;
		try {
			Connection conn = getConnection();
			PreparedStatement st = conn
					.prepareStatement("select * from student where id=?");
			st.setString(1, id);
			st.execute();
			ResultSet rs = st.getResultSet();
			if (rs.next()) {
				student = new Student();
				student.setId(rs.getString("id"));
				student.setName(rs.getString("name"));
				student.setAge(rs.getInt("age"));
				student.setSex(rs.getInt("sex"));
				student.setMajor(rs.getString("major"));
				student.setCollege(rs.getString("college"));
				student.setIntroduction(rs.getString("introduction"));
			}
			conn.close();
		} catch (Exception e) {
		}
		return student;
	}

	//查询所有学生信息
	public static ArrayList<Student> getAllStudents(){
		ArrayList<Student> students = new ArrayList<Student>();
		try {
			Connection conn = getConnection();
			PreparedStatement st = conn
					.prepareStatement("select * from student");
			st.execute();
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				Student student = new Student();
				student.setId(rs.getString("id"));
				student.setName(rs.getString("name"));
				student.setAge(rs.getInt("age"));
				student.setSex(rs.getInt("sex"));
				student.setMajor(rs.getString("major"));
				student.setCollege(rs.getString("college"));
				student.setIntroduction(rs.getString("introduction"));
				students.add(student);
			}
			conn.close();
		} catch (Exception e) {
		}
		return students;
	}
}

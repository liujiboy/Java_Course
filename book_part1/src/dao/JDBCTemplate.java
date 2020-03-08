package dao;

import java.sql.Connection;
import java.sql.DriverManager;

abstract public class JDBCTemplate<T> {
	private String driverClass="com.mysql.jdbc.Driver";
	private String jdbcURL="jdbc:mysql://localhost/book?useUnicode=true&characterEncoding=UTF-8";
	private String user="root";
	private String pwd="root";
	abstract public T execute() throws Exception;
	protected Connection getConnection()throws Exception {
			Class.forName(driverClass);
			Connection conn=DriverManager.getConnection(jdbcURL, user, pwd);
			return conn;
		
	}
}

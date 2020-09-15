package code1405;

import java.sql.*;

public class CreateCommodityTable {

	public static void main(String[] args) {
		String url = "jdbc:derby:testDB;create=true";

		Connection con = null;

		Statement stmt = null;

		String createString;

		createString = "CREATE TABLE commodity "

				+ "(id INT NOT NULL PRIMARY KEY, " + "name VARCHAR(50), "

				+ "price FLOAT, " + "status VARCHAR(10))";

		try {

			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

			con = DriverManager.getConnection(url);

			stmt = con.createStatement();

			stmt.executeUpdate(createString);

			System.out.println("创建commodity表成功。");

		} catch (ClassNotFoundException e) {

			System.err.print("类没有找到异常：");

			System.err.println(e.getMessage());

		} catch (SQLException e) {

			System.err.println("SQL异常：" + e.getMessage());

		} finally {

			if (stmt != null) {

				try {

					stmt.close();

				} catch (SQLException e) {

				}

				stmt = null;

			}

			if (con != null) {

				try {

					con.close();

				} catch (SQLException e) {

				}

				con = null;

			}

		}

	}

}

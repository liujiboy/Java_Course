package code1405;

import java.sql.*;

public class InsertNewCommodity {

	public static void main(String[] args) {
		String url = "jdbc:derby:testDB;create=true";

		Connection con = null;

		Statement stmt = null;

		String query = "SELECT * FROM commodity";



		try {

			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

			con = DriverManager.getConnection(url);

			stmt = con.createStatement();



			stmt.executeUpdate("INSERT INTO commodity "

					+ "VALUES(1,'联想笔记本电脑G450L-TTH',2699, '停产')");

			stmt.executeUpdate("INSERT INTO commodity "

					+ "VALUES(2,'惠普笔记本电脑CQ515',2950, '在售')");

			stmt.executeUpdate("INSERT INTO commodity "

					+ "VALUES(3,'索尼笔记本电脑VPCEA27EC',5259, '在售')");



			ResultSet rs = stmt.executeQuery(query);



			System.out.println("商品信息列表：");

			System.out.println("编号\t名称\t\t\t价格\t状态");

			while (rs.next()) {

				int id = rs.getInt("id");

				String name = rs.getString("name");

				float price = rs.getFloat("price");

				String status = rs.getString("status");

				System.out.println(id + "\t" + name + "\t" + price + "\t"

						+ status);

			}

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

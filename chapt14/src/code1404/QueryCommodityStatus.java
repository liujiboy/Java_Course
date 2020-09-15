package code1404;

import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

import java.sql.*;


public class QueryCommodityStatus {

	public static void main(String[] args) {
		String url = "jdbc:derby:testDB;create=true";

		Connection con = null;

		PreparedStatement pstm = null;



		try {

// 加载JDBC驱动程序

			Class.forName("org.apache.derby.jdbc.EmbeddedDriver"); 

			con = DriverManager.getConnection(url); // 建立连接

			pstm = con.prepareStatement("SELECT status FROM commodity WHERE name=?"); // 创建PreparedStatement语句



			System.out.println("请输入要查询的商品名称：");

			String inputName = (new BufferedReader(new InputStreamReader(

					System.in))).readLine();

			pstm.setString(1, inputName); // 对SQL语句中的参数进行赋值

			ResultSet rs = pstm.executeQuery(); // 执行SQL语句

			if (rs.next()) {

				String status = rs.getString("status"); // 检索结果

				System.out.println("商品\"" + inputName + "\"的状态是：" + status);

			} else {

				System.out.println("没有商品\"" + inputName + "\"的相关信息。");

			}

		} catch (ClassNotFoundException e) {

			System.err.print("类没有找到异常：");

			System.err.println(e.getMessage());

		} catch (SQLException e) {

			System.err.println("SQL异常：" + e.getMessage());

		} catch (IOException e) {

			System.err.println("IO异常：" + e.getMessage());

		} finally {

			if (pstm != null) {

				try {

					pstm.close(); // 关闭PreparedStatement语句

				} catch (SQLException e) {

				}

				pstm = null;

			}

			if (con != null) {

				try {

					con.close(); // 关闭连接

				} catch (SQLException e) {

				}

				con = null;

			}

		}



	}

}

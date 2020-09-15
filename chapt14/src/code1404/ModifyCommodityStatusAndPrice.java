package code1404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class ModifyCommodityStatusAndPrice {

	public static void main(String[] args) throws IOException {
		String url = "jdbc:derby:testDB;create=true";
		Connection con = null;
		PreparedStatement pstm = null;

		boolean isExisted = false;

		System.out.println("请输入要修改的商品名称：");
		String inputName = (new BufferedReader(new InputStreamReader(System.in))).readLine();

		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con = DriverManager.getConnection(url);
		} catch (ClassNotFoundException e) {
			System.err.print("类没有找到异常：");
			System.err.println(e.getMessage());
		} catch (SQLException e) {
			System.err.println("SQL异常：" + e.getMessage());
		}

		try {
			pstm = con.prepareStatement("SELECT * FROM commodity where name=?");
			pstm.setString(1, inputName);
			ResultSet rs = pstm.executeQuery();

			if (rs.next()) {
				isExisted = true;
				System.out.println("商品修改前的信息是:");
				int id = rs.getInt("id");
				String name = rs.getString("name");
				float price = rs.getFloat("price");
				String status = rs.getString("status");
				System.out.println(id + "\t" + name + "\t" + price + "\t" + status);
			} else {
				System.out.println("输入的商品不存在。");
			}
		} catch (SQLException e) {
			System.err.println("SQL异常：" + e.getMessage());
		} finally {
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
				}
				pstm = null;
			}
			System.err.flush();
		}

		if (isExisted) {
			System.out.println("请输入商品新的状态：");
			String inputStatus = (new BufferedReader(new InputStreamReader(System.in))).readLine();
			System.out.println("请输入商品新的价格：");
			Double inputPrice = Double.valueOf((new BufferedReader(new InputStreamReader(System.in))).readLine());

			try {
				con.setAutoCommit(false);
				con.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);

				pstm = con.prepareStatement("UPDATE commodity SET price=? where name=?");
				pstm.setDouble(1, inputPrice.doubleValue());
				pstm.setString(2, inputName);
				pstm.executeUpdate();
				pstm.close();

				pstm = con.prepareStatement("UPDATE commodity SET status=? where name=?");
				pstm.setString(1, inputStatus);
				pstm.setString(2, inputName);
				pstm.executeUpdate();
				pstm.close();

				con.commit();
			} catch (SQLException e) {
				try {
					con.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				System.err.println("SQL异常：" + e.getMessage());
			} finally {
				if (pstm != null) {
					try {
						pstm.close();
					} catch (SQLException e) {
					}
					pstm = null;
				}
				try {
					con.setAutoCommit(true);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				System.err.flush();
			}

			try {
				pstm = con.prepareStatement("SELECT * FROM commodity where name=?");
				pstm.setString(1, inputName);
				ResultSet rs = pstm.executeQuery();

				if (rs.next()) {
					isExisted = true;
					System.out.println("商品修改后的信息是:");
					int id = rs.getInt("id");
					String name = rs.getString("name");
					float price = rs.getFloat("price");
					String status = rs.getString("status");
					System.out.println(id + "\t" + name + "\t" + price + "\t" + status);
				}
			} catch (SQLException e) {
				System.err.println("SQL异常：" + e.getMessage());
			} finally {
				if (pstm != null) {
					try {
						pstm.close();
					} catch (SQLException e) {
					}
					pstm = null;
				}
				System.err.flush();
			}
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

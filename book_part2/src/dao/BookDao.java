package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import domain.Book;

/**
 * 访问数据库
 * 
 * @author liuji
 * 
 */
public class BookDao {
	//添加
	public static Boolean add(final Book book) throws Exception {
		JDBCTemplate<Boolean> t = new Transaction<Boolean>() {
			@Override
			protected Boolean doTransaction(Connection conn) throws Exception {
				PreparedStatement ps = conn
						.prepareStatement("insert into book(id,name,price,des,image) values(?,?,?,?,?)");
				ps.setString(1, book.id);
				ps.setString(2, book.name);
				ps.setDouble(3, book.price);
				ps.setString(4, book.des);
				ps.setString(5, book.image);
				return ps.execute();
			}
		};
		return t.execute();
	}
	//获取
	public static Book get(final String id) throws Exception {
		JDBCTemplate<Book> q = new Query<Book>() {
			@Override
			protected Book doQuery(Connection conn) throws Exception {
				PreparedStatement ps = conn
						.prepareStatement("select * from book where id=?");
				ps.setString(1, id);
				ps.execute();
				ResultSet rs = ps.getResultSet();
				Book book = null;
				if (rs.next()) {
					book = new Book();
					book.id = rs.getString("id");
					book.name = rs.getString("name");
					book.price = rs.getDouble("price");
					book.des = rs.getString("des");
					book.image = rs.getString("image");
				}
				return book;
			}
		};
		return q.execute();
	}

	// 获取全部
	public static List<Book> getAll() throws Exception {
		JDBCTemplate<List<Book>> q = new Query<List<Book>>() {

			@Override
			protected List<Book> doQuery(Connection conn) throws Exception {
				List<Book> books = new ArrayList<Book>();
				PreparedStatement ps = conn
						.prepareStatement("select * from book");
				ps.execute();
				ResultSet rs = ps.getResultSet();
				while (rs.next()) {
					Book book = new Book();
					book.id = rs.getString("id");
					book.name = rs.getString("name");
					book.price = rs.getDouble("price");
					book.des = rs.getString("des");
					book.image = rs.getString("image");
					books.add(book);
				}
				return books;
			}
		};
		return q.execute();
	}

	// 修改
	public static Boolean update(final Book book, final String oldId)
			throws Exception {
		JDBCTemplate<Boolean> t = new Transaction<Boolean>() {
			@Override
			protected Boolean doTransaction(Connection conn) throws Exception {
				PreparedStatement ps = conn
						.prepareStatement("update book set id=?,name=?,price=?,des=?,image=? where id=?");
				ps.setString(1, book.id);
				ps.setString(2, book.name);
				ps.setDouble(3, book.price);
				ps.setString(4, book.des);
				ps.setString(5, book.image);
				ps.setString(6, oldId);
				return ps.execute();
			}
		};
		return t.execute();
	}

	// 删除
	public static Boolean delete(final String id) throws Exception {
		JDBCTemplate<Boolean> t = new Transaction<Boolean>() {
			@Override
			protected Boolean doTransaction(Connection conn) throws Exception {
				PreparedStatement ps = conn
						.prepareStatement("delete from book where id=?");
				ps.setString(1, id);
				return ps.execute();
			}
		};
		return t.execute();
	}
}

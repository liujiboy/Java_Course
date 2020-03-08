package cn.edu.cqu.annotation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.edu.cqu.annotation.domain.Book;

//Data Access Object
//CRUD，Create Read Update Delete
public class BookDao {
	
	@SQLConnection
	private Connection conn;

	// 添加
	@Transaction
	public Boolean add(final Book book) throws Exception {

		PreparedStatement ps = conn.prepareStatement("insert into book(id,name,price,des,image) values(?,?,?,?,?)");
		ps.setString(1, book.id);
		ps.setString(2, book.name);
		ps.setDouble(3, book.price);
		ps.setString(4, book.des);
		ps.setString(5, book.image);
		ps.execute();
		return true;
	}

	// 获取
	@Query
	public Book get(final String id) throws Exception {
		PreparedStatement ps = conn.prepareStatement("select * from book where id=?");
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

	// 获取全部
	@Query
	public List<Book> getAll() throws Exception {
		List<Book> books = new ArrayList<Book>();
		PreparedStatement ps = conn.prepareStatement("select * from book");
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

	// 修改
	@Transaction
	public Boolean update(final Book book, final String oldId) throws Exception {
		PreparedStatement ps = conn.prepareStatement("update book set id=?,name=?,price=?,des=?,image=? where id=?");
		ps.setString(1, book.id);
		ps.setString(2, book.name);
		ps.setDouble(3, book.price);
		ps.setString(4, book.des);
		ps.setString(5, book.image);
		ps.setString(6, oldId);
		ps.execute();
		return true;
	}

	// 删除
	@Transaction
	public Boolean delete(final String id) throws Exception {
		PreparedStatement ps = conn.prepareStatement("delete from book where id=?");
		ps.setString(1, id);
		ps.execute();
		return true;
	}

}

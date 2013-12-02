package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import domain.Book;


public class BookDao {
	private static final String driverClass="com.mysql.jdbc.Driver";
	private static final String jdbcURL="jdbc:mysql://localhost/book?useUnicode=true&characterEncoding=UTF-8";
	private static final String user="root";
	private static final String pwd="";
	//获取数据库连接
	public static Connection getConnection() throws Exception
	{
		Class.forName(driverClass);
		Connection conn=DriverManager.getConnection(jdbcURL, user, pwd);
		return conn;
	}
	//添加
	public static Boolean add(final Book book)throws Exception
	{
		Connection conn=getConnection();
		conn.setAutoCommit(false);
		try{
			PreparedStatement ps=conn.prepareStatement("insert into book values(?,?,?,?,?)");
			ps.setString(1,book.id);
			ps.setString(2, book.name);
			ps.setDouble(3, book.price);
			ps.setString(4, book.des);
			ps.setString(5, book.image);
			ps.execute();
			conn.commit();
			return true;
		}catch(Exception e)
		{
			
			conn.rollback();
			throw e;
		}finally
		{
			conn.close();
		}
	}
	//获取
	public static Book get(final String id)throws Exception
	{
		Connection conn=getConnection();
		try{
			PreparedStatement ps=conn.prepareStatement("select * from book where id=?");
			ps.setString(1,id);
			ps.execute();
			ResultSet rs=ps.getResultSet();
			Book book=null;
			if(rs.next())
			{
				book=new Book();
				book.id=rs.getString("id");
				book.name=rs.getString("name");
				book.price=rs.getDouble("price");
				book.des=rs.getString("des");
				book.image=rs.getString("image");
			}
			return book;
		}catch(Exception e)
		{
			throw e;
		}
		finally
		{
			conn.close();
		}
	}
	//获取全部
	public static List<Book> getAll()throws Exception
	{
		List<Book> books=new ArrayList<Book>();
		Connection conn=getConnection();
		try{
			PreparedStatement ps=conn.prepareStatement("select * from book");
			ps.execute();
			ResultSet rs=ps.getResultSet();
			while(rs.next())
			{
				Book book=new Book();
				book.id=rs.getString("id");
				book.name=rs.getString("name");
				book.price=rs.getDouble("price");
				book.des=rs.getString("des");
				book.image=rs.getString("image");
				books.add(book);
			}
			return books;
		}catch(Exception e)
		{
			throw e;
		}
		finally
		{
			conn.close();
		}
	}
	//修改
	public static Boolean update(final Book book,final String oldId)throws Exception
	{
		Connection conn=getConnection();
		conn.setAutoCommit(false);
		try{
			PreparedStatement ps=conn.prepareStatement("update book set id=?,name=?,price=?,des=?,image=? where id=?");
			ps.setString(1,book.id);
			ps.setString(2, book.name);
			ps.setDouble(3, book.price);
			ps.setString(4, book.des);
			ps.setString(5, book.image);
			ps.setString(6, oldId);
			ps.execute();
			conn.commit();
			return true;
		}catch(Exception e)
		{
			conn.rollback();
			throw e;
		}finally
		{
			conn.close();
		}
	}
	//删除
	public static Boolean delete(final String id)throws Exception
	{
		Connection conn=getConnection();
		conn.setAutoCommit(false);
		try{
			PreparedStatement ps=conn.prepareStatement("delete from book where id=?");
			ps.setString(1,id);
			ps.execute();
			conn.commit();
			return true;
		}catch(Exception e)
		{
			conn.rollback();
			throw e;
		}finally
		{
			conn.close();
		}
	}
}

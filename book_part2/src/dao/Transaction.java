package dao;

import java.sql.Connection;

public abstract class Transaction<T> extends JDBCTemplate<T> {

	@Override
	public T execute() throws Exception{
		Connection conn=getConnection();
		conn.setAutoCommit(false);
		try{
			T result=doTransaction(conn);
			conn.commit();
			return result;
		}catch(Exception e)
		{
			conn.rollback();
			e.printStackTrace();
			throw e;
		}finally
		{
			conn.close();
		}
	}

	abstract protected T doTransaction(Connection conn)throws Exception;

}

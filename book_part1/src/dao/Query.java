package dao;

import java.sql.Connection;

 public abstract class Query<T> extends JDBCTemplate<T>{

	@Override
	public T execute() throws Exception 
		{
			Connection conn=getConnection();
			try{
				T result=doQuery(conn);
				return result;
			}catch(Exception e)
			{
				throw e;
			}finally
			{
				conn.close();
			}
		}

	abstract protected T doQuery(Connection conn)throws Exception;
}

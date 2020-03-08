package cn.edu.cqu.annotation.dao;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class DaoProxy {

	private static final String driverClass="com.mysql.cj.jdbc.Driver";
	private static final String jdbcURL="jdbc:mysql://localhost/book?useUnicode=true&characterEncoding=UTF-8";
	private static final String user="root";
	private static final String pwd="root";
	//获取数据库连接
	private static Connection getConnection() throws Exception
	{
		Class.forName(driverClass);
		Connection conn=DriverManager.getConnection(jdbcURL, user, pwd);
		return conn;
	}
	@SuppressWarnings("unchecked")
	public static <T> T create(Class<T> daoClass)
	{
		Enhancer enhancer =new Enhancer();
        enhancer.setSuperclass(daoClass);
        //寻找标注为SQLConnection的成员变量
        final Field sqlConnectionField = findSQLConnectionField(daoClass);
        //设置方法拦截器
        enhancer.setCallback(new MethodInterceptor() {
			@Override
			public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
				
				Query query=method.getAnnotation(Query.class);
				Transaction transaction=method.getAnnotation(Transaction.class);
				Object result=null;
				if(query!=null || transaction!=null)
				{
					Connection conn=getConnection();
					sqlConnectionField.set(obj, conn);//设置数据库连接
					if(query!=null)
					{
						result = doQuery(obj, args, proxy, conn);
					}else
					{
						result = doTransaction(obj, args, proxy, conn);
					}
				}else
				{
					result = proxy.invokeSuper(obj, args);
				}
		        return result;
			}

			private Object doTransaction(Object obj, Object[] args, MethodProxy proxy, Connection conn)
					throws SQLException, Throwable, Exception {
				Object result=null;
				conn.setAutoCommit(false);
				try {
					result = proxy.invokeSuper(obj, args);
					conn.commit();
				}
				catch(Exception e)
				{
					conn.rollback();
					throw e;
				}
				finally
				{
					conn.close();
				}
				return result;
			}

			private Object doQuery(Object obj, Object[] args, MethodProxy proxy, Connection conn) throws Throwable, Exception, SQLException {
				Object result=null;
				try {
					result = proxy.invokeSuper(obj, args);
				}
				catch(Exception e)
				{
					throw e;
				}
				finally
				{
					conn.close();
				}
				return result;
			}
        });
		return (T) enhancer.create();
	}
	private static <T> Field findSQLConnectionField(Class<T> daoClass) {
		for(Field f:daoClass.getDeclaredFields())
        {
        	SQLConnection sqlConnection=f.getAnnotation(SQLConnection.class);
        	if(sqlConnection!=null)
        	{
        		f.setAccessible(true);//设置可以访问私有变量
        		return f;
        	}
        }
		return null;
	}
}

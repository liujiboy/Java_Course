package cn.edu.cqu.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import cn.edu.cqu.domain.College;
import cn.edu.cqu.domain.Student;

public class HibernateUtil {
	 private static final SessionFactory sessionFactory;
	  

	    static {
	    	
	    	//获取hibernate.properties或hibernate.cfg.xml的配置信息
	    	final Configuration configuration = new Configuration();
			configuration.addAnnotatedClass( College.class );
			configuration.addAnnotatedClass( Student.class );
			//创建sessionFactory
			sessionFactory = configuration.buildSessionFactory( new StandardServiceRegistryBuilder().build() );
	    }
	   
	    //从SessionFactory中获取Session
	    public static Session getSession(){
	        return sessionFactory.openSession();
	    }

	  

}

package com.smbms.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private static SqlSessionFactory sessionFactory;
	static {
		try {
			//1.读取全局的配置文件
			String resource = "mybatis-config.xml";
			//2.获取文件的输入流
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static SqlSession createSqlSession() {
		//默认没开启事务控制
		return sessionFactory.openSession();
//		return sessionFactory.openSession(false);
	}
	public static void closeSqlSession(SqlSession session) {
		if (session != null) {
			session.close();
		}	
	}
}

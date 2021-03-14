package com.smbms.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.smbms.dao.MyBatisUtil;

public class UserMapperTest {

	@Test
	public void selectCountFromUser() throws IOException {
		// 1.读取全局的配置文件
		String resource = "mybatis-config.xml";
		// 2.获取文件的输入流
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 3.根据配置文 件构建sqlsessionfactory
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		// 4.通过factory创建sqlsession
		SqlSession session = factory.openSession();
		

		// 5.执行映射中的sql，通过mapper文件的命名空间+ID执行
		int num = session.selectOne("com.smbms.dao.user.mapper.UserMapper.count");
		System.out.println(num);
		// 6.关闭联接
		session.close();
	}

	@Test
	public void selectCountFromUser2() throws IOException {
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			sqlSession.selectOne("com.smbms.dao.user.mapper.UserMapper.count");
		} finally {
			MyBatisUtil.closeSqlSession(sqlSession);
		}

	}
}

package com.smbms.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.smbms.dao.MyBatisUtil;
import com.smbms.dao.user.mapper.UserMapper;
import com.smbms.pojo.User;

public class UserMapperImpl {
//	查询
	@Test
	public void testCount() {
		SqlSession session = null;
		List<User> users = new ArrayList<User>();
		try {
			session = MyBatisUtil.createSqlSession();
			// int num = session.getMapper(UserMapper.class).count();
			// session.getMapper(UserMapper.class).searchByName("赵");
			User user = new User();
			user.setUserName("赵");
			user.setUserRole(3);
			// session.getMapper(UserMapper.class).searchByMutiCondition(user);
			Map<String, String> mapsMap = new HashMap<String, String>();
			mapsMap.put("userName", "赵");
			mapsMap.put("userRoles", "3");
			// session.getMapper(UserMapper.class).searchByMap(mapsMap);
			// users = session.getMapper(UserMapper.class).searchByUser(user);
			session.getMapper(UserMapper.class).searchByName("赵");

		} finally {
			// TODO: handle finally clause
			MyBatisUtil.closeSqlSession(session);
		}
	}

	// 增刪改
	@Test
	public void testCRUD() throws ParseException {
		SqlSession session = null;
		int count = 0;
		try {
			session = MyBatisUtil.createSqlSession();
			User user = new User();
			user.setUserCode("test003");
			user.setUserName("测试用户003");
			user.setUserPassword("1234567");
			Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse("1988-09-25");
			user.setBirthday(birthday);
			user.setAddress("测试地址");
			user.setGender(1);
			user.setPhone("12322223333");
			user.setUserRole(3);
			//user.setCreatedBy(1);
			//user.setCreationDate(new Date());
			user.setModifyBy(1);
			user.setModifyDate(new Date());
			user.setId(20);
			//count = session.getMapper(UserMapper.class).addUser(user);	
			//count = session.getMapper(UserMapper.class).modifyUser(user);	
			count = session.getMapper(UserMapper.class).modifyPassword(20, "1111111");
			
			//int i= 20/0;
			//提交事务
			session.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.rollback();
			count = 0;	
		}finally {
			// TODO: handle finally clause
			MyBatisUtil.closeSqlSession(session);
		}
	}
}

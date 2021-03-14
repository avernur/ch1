package com.smbms.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.smbms.dao.MyBatisUtil;
import com.smbms.dao.user.mapper.UserMapper;
import com.smbms.pojo.User;

public class UserMapperImpl {
	@Test
	public void testCount() {
		SqlSession session = null;
		List<User> users = new ArrayList<User>();
		try {
			session = MyBatisUtil.createSqlSession();
		//	int num = session.getMapper(UserMapper.class).count();
			//session.getMapper(UserMapper.class).searchByName("赵");
			User user = new User();
			user.setUserName("赵");
			user.setUserRole(3);
			//session.getMapper(UserMapper.class).searchByMutiCondition(user);
			Map<String, String> mapsMap = new HashMap<String, String>();
			mapsMap.put("userName", "赵");
			mapsMap.put("userRoles", "3");
			//session.getMapper(UserMapper.class).searchByMap(mapsMap);
			//users = session.getMapper(UserMapper.class).searchByUser(user);
			session.getMapper(UserMapper.class).searchByName("赵");
			
		} finally {
			// TODO: handle finally clause
			MyBatisUtil.closeSqlSession(session);
		}
	}
}

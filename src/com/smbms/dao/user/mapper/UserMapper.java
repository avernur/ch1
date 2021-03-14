package com.smbms.dao.user.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.smbms.pojo.User;

public interface UserMapper {
	public int count() ;
	public List<User> all();
	public List<User> searchByName(String userName);
	public List<User> searchByMutiCondition(User user);
	public List<User> searchByMap(Map<String, String> maps);
	public List<User> searchByMuti1(String name, int role);
	public List<User> searchByMuti2(@Param(value = "name")String name, 
									@Param(value = "role") int role);
	
	public List<User> searchByUser(User user);
}

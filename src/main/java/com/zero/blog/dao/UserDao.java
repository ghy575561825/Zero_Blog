package com.zero.blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zero.blog.entity.User;

/**
 * 用户dao接口
 * @author Administrator
 *
 */
@Mapper
public interface UserDao {

	/**
	 * 获取用户的总记录数
	 * @return
	 */
	public int getRowCount(@Param("username") String username);
	
	/**
	 * 分页条件查询
	 * @param username
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public List<User> findObjects(
			@Param("username")String username, 
			@Param("startIndex")Integer startIndex, 
			@Param("pageSize")Integer pageSize);
}

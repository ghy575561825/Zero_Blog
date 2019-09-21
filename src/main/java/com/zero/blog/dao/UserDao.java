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
	 * 用户的删除操作
	 * @param id
	 * @return
	 */
	public int deleteObject(@Param("ids")Integer...ids);
	
	/**
	 * 用户的更新
	 * @param user
	 * @return
	 */
	public int updateObject(User user);
	
	/**
	 * 用户的新增
	 * @param user
	 * @return
	 */
	public int insertObject(User user);
	
	/**
	 * 获取用户的总记录数
	 * @return
	 */
	public int getRowCount(@Param("username") String username);
	
	/**
	 * 用户的分页条件查询
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

package com.zero.blog.service;

import com.zero.blog.entity.User;
import com.zero.common.vo.PageObject;

/**
 * 用户的service接口
 * @author Administrator
 *
 */
public interface UserService {

	/**
	 * 用户的删除操作
	 * @param id
	 * @return
	 */
	public int deleteObject(Integer...id);
	
	/**
	 * 用户的更新操作
	 * @param user
	 * @return
	 */
	public int updateObject(User user);
	
	/**
	 * 用户的增加操作
	 * @param user
	 * @return
	 */
	public int saveObject(User user);
	
	/**
	 * 用户的条件查询操作
	 * @param username
	 * @param pageCurrent
	 * @return
	 */
	public PageObject<User> findObjects(String username, Integer pageCurrent);
}

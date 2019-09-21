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
	 * 条件查询
	 * @param username
	 * @param pageCurrent
	 * @return
	 */
	public PageObject<User> findObjects(String username, Integer pageCurrent);
}

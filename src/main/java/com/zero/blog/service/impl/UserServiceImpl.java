package com.zero.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zero.blog.dao.UserDao;
import com.zero.blog.entity.User;
import com.zero.blog.service.UserService;
import com.zero.common.vo.PageObject;

/**
 * 用户service的是线程
 * @author Administrator
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public PageObject<User> findObjects(String username, Integer pageCurrent) {
		//判断参数是否合法
		if(pageCurrent == null || pageCurrent<1)
			throw new IllegalArgumentException("页码不正确");
		//获取总记录数
		int rowCount = userDao.getRowCount(username);
		//如果总记录为0,表示未找到对应记录
		if(rowCount == 0)
			throw new IllegalArgumentException("没有对象记录");
		//页面大小
		int pageSize = 3;
		//起始索引
		int startIndex = (pageCurrent - 1)*pageSize;
		//查询出的所有记录
		List<User> records = userDao.findObjects(username, startIndex, pageSize);
		return new PageObject<>(pageCurrent, pageSize, rowCount, records);
	}

}

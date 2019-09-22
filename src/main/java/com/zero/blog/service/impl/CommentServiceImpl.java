package com.zero.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.zero.blog.dao.CommentDao;
import com.zero.blog.dao.UserDao;
import com.zero.blog.entity.Comment;
import com.zero.blog.entity.User;
import com.zero.blog.service.CommentService;
import com.zero.common.exception.ServiceException;
import com.zero.common.vo.PageObject;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentDao commentDao;

	@Override
	public PageObject<Comment> findPageObjects(String createdUser, Integer pageCurrent) {
		// 判断参数是否合法
		if (pageCurrent == null || pageCurrent < 1)
			throw new IllegalArgumentException("页码不正确");
		// 获取总记录数
		int rowCount = commentDao.getRowCount(createdUser);
		// 如果总记录为0,表示未找到对应记录
		if (rowCount == 0)
			throw new IllegalArgumentException("没有对象记录");
		// 页面大小
		int pageSize = 2;
		// 起始索引
		int startIndex = (pageCurrent - 1) * pageSize;
		// 查询出的所有记录
		List<Comment> records = commentDao.findPageObjects(createdUser, startIndex, pageSize);
		return new PageObject<>(pageCurrent, pageSize, rowCount, records);
	}

	@Override
	public int deleteObjects(Integer... ids) {
		// 1.参数校验
		if (ids == null || ids.length == 0)
			throw new IllegalArgumentException("参数值无效");
		// 2.执行删除
		int rows = commentDao.deleteObject(ids);
		if (rows == 0)
			throw new ServiceException("记录可能已经不存在");
		//3.返回结果
		return rows;
	}

	@Override
	public int updateObject(Comment entity) {
		// 1.验证数据合法性
		if (entity == null)
			throw new ServiceException("保存对象不能为空");
		if (StringUtils.isEmpty(entity.getCreatedUser()))
			throw new ServiceException("用户名不能为空");
		if (StringUtils.isEmpty(entity.getEmail()))
			throw new ServiceException("邮箱不能为空");
		if (StringUtils.isEmpty(entity.getContent()))
			throw new ServiceException("内容不能为空");
		// 2.将数据写入数据库
		commentDao.updateObject(entity);
		// 2.1先根据id删除原有数据
		commentDao.deleteObject(entity.getId());
		// 2.2插入新的数据
		int rows = commentDao.insertObject(entity);
		//3.返回结果
		return rows;
	}

	@Override
	public int insertObject(Comment entity) {
		// 1.验证数据合法性
		if (entity == null)
			throw new ServiceException("保存对象不能为空");
		if (StringUtils.isEmpty(entity.getCreatedUser()))
			throw new ServiceException("用户名不能为空");
		if (StringUtils.isEmpty(entity.getEmail()))
			throw new ServiceException("邮箱不能为空");
		if (StringUtils.isEmpty(entity.getContent()))
			throw new ServiceException("内容不能为空");
		//2.写入数据库
		int rows = commentDao.insertObject(entity);
		//3.返回结果
		return rows;
	}
}

package com.zero.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.zero.blog.dao.CategoryDao;
import com.zero.blog.entity.Category;
import com.zero.blog.service.CategoryService;
import com.zero.common.exception.ServiceException;
import com.zero.common.vo.PageObject;
@Service
public class Categoryimpl implements CategoryService{
	@Autowired
	private CategoryDao categoryDao;

	@Override
	public PageObject<Category> findObjects(String name, Integer pageCurrent) {
		// 判断参数是否合法
		if (pageCurrent == null || pageCurrent < 1)
			throw new IllegalArgumentException("页码不正确");
		// 获取总记录数
		int rowCount = categoryDao.getRowCount(name);
		// 如果总记录为0,表示未找到对应记录
		if (rowCount == 0)
			throw new IllegalArgumentException("没有对象记录");
		// 页面大小
		int pageSize = 2;
		// 起始索引
		int startIndex = (pageCurrent - 1) * pageSize;
		// 查询出的所有记录
		List<Category> records = categoryDao.findPageObjects(name, startIndex, pageSize);
		return new PageObject<>(pageCurrent, pageSize, rowCount, records);
	}

	
	@Override
	public int updateObject(Category entity) {
		// 1.验证数据合法性
		if (entity == null)
			throw new ServiceException("保存对象不能为空");
		if (StringUtils.isEmpty(entity.getName()))
			throw new ServiceException("类型不能为空");
		if (StringUtils.isEmpty(entity.getUrl()))
			throw new ServiceException("链接不能为空");
	
		// 2.将数据写入数据库
		int rows = categoryDao.updateObject(entity);
		// 2.1先根据id删除原有数据
		//categoryDao.deleteObject(entity.getId());
		// 2.2插入新的数据
//		int rows = categoryDao.insertObject(entity);
		//3.返回结果
		return rows;
	}

	@Override
	public int insertObject(Category entity) {
		// 1.验证数据合法性
		if (entity == null)
			throw new ServiceException("保存对象不能为空");
		if (StringUtils.isEmpty(entity.getName()))
			throw new ServiceException("类型不能为空");
		if (StringUtils.isEmpty(entity.getUrl()))
			throw new ServiceException("链接不能为空");
		//2.写入数据库
		int rows = categoryDao.insertObject(entity);
		//3.返回结果
		return rows;
	}
}

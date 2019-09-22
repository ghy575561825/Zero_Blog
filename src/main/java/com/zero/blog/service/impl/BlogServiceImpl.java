package com.zero.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zero.blog.dao.BlogDao;
import com.zero.blog.entity.Blog;
import com.zero.blog.service.BlogService;
import com.zero.common.exception.ServiceException;
import com.zero.common.vo.PageObject;

/**
 * 博客service的实现层
 * @author Administrator
 *
 */
@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogDao blogDao;
	
	/**
	 * 博客的删除
	 */
	@Override
	public int deleteObject(Integer... ids) {
		if(ids == null)
			new ServiceException("数据不合法");
		int rows = blogDao.deleteObject(ids);
		if(rows == 0)
			throw new ServiceException("此信息可能已经不存在");
		return rows;
	}
	
	/**
	 * 博客的更新
	 */
	@Override
	public int updateObject(Blog blog) {
		if(blog == null)
			throw new ServiceException("更新对象不能为空");
		if(blog.getId() == null)
			throw new ServiceException("博客id不能为空");
		int rows;
		try {
			rows = blogDao.updateObject(blog);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("更新失败");
		}
		return rows;
	}
	
	/**
	 * 博客的增加
	 */
	@Override
	public int saveObject(Blog blog) {
		if(blog == null)
			throw new ServiceException("保存的对象不能为空");
		int rows;
		try {
			rows = blogDao.insertObject(blog);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("保存失败");
		}
		return rows;
	}
	
	/**
	 * 博客条件分页查询
	 */
	@Override
	public PageObject<Blog> findObjects(String title, Integer pageCurrent) {
		//判断参数是否合法
		if(pageCurrent == null || pageCurrent < 1)
			throw new IllegalArgumentException("页码不正确");
		//数据总记录数
		int rowCount = blogDao.getRowCount(title);
		if(rowCount == 0)
			throw new IllegalArgumentException("没有对应记录");
		//一页显示的最多记录数
		int pageSize = 3;
		//从第几条记录查询开始索引
		int startIndex = (pageCurrent - 1)*pageSize;
		//所有所有记录对象
		List<Blog> records = blogDao.findObjects(title, startIndex, pageSize);
		return new PageObject<>(pageCurrent, pageSize, rowCount, records);
	}

}

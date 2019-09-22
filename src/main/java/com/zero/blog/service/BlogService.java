package com.zero.blog.service;

import com.zero.blog.entity.Blog;
import com.zero.common.vo.PageObject;

public interface BlogService {

	/**
	 * 博客的删除
	 * @param ids
	 * @return
	 */
	public int deleteObject(Integer...ids);
	
	/**
	 * 博客的更新
	 * @return
	 */
	public int updateObject(Blog blog);
	
	/**
	 * 博客的增加
	 * @param blog
	 * @return
	 */
	public int saveObject(Blog blog);
	
	/**
	 * 博客条件查询
	 * @param title
	 * @param pageCurrent
	 * @return
	 */
	public PageObject<Blog> findObjects(String title, Integer pageCurrent);
}

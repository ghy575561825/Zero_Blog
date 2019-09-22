package com.zero.blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zero.blog.entity.Blog;

/**
 * 博客dao层接口
 * @author Administrator
 *
 */
@Mapper
public interface BlogDao {

	/**
	 * 博客的删除功能
	 * @param ids
	 * @return
	 */
	public int deleteObject(@Param("ids")Integer...ids);
	
	/**
	 * 博客的更新功能
	 * @param blog
	 * @return
	 */
	public int updateObject(Blog blog);
	
	/**
	 * 博客的增加功能
	 * @param blog
	 * @return
	 */
	public int insertObject(Blog blog);
	
	/**
	 * 获取博客记录的总数
	 * @param title
	 * @return
	 */
	public int getRowCount(@Param("title") String title);
	
	/**
	 * 博客的条件查询功能
	 * @param title
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public List<Blog> findObjects(
			@Param("title") String title, 
			@Param("startIndex") Integer startIndex, 
			@Param("pageSize") Integer pageSize);
}

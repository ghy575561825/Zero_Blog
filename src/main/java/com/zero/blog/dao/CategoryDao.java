package com.zero.blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import com.zero.blog.entity.Category;
@Mapper
public interface CategoryDao {
	
	int insertObject(Category category);
	
	int updateObject(Category category);
	
	
	int getRowCount(@Param("name") String name);
	
	List<Category> findPageObjects(
		      @Param("name")String  name,
		      @Param("startIndex")Integer startIndex,
		      @Param("pageSize")Integer pageSize);
}

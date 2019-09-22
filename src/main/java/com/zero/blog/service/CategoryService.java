package com.zero.blog.service;

import com.zero.blog.entity.Category;
import com.zero.blog.entity.User;
import com.zero.common.vo.PageObject;

public interface CategoryService {
	
	 
	 int updateObject(Category entity);
	 
	 int insertObject(Category entity);
	 
 PageObject<Category> findObjects(String name, Integer pageCurrent);
	 
}

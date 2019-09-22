package com.zero;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zero.blog.dao.CategoryDao;
import com.zero.blog.entity.Category;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCategory {

	@Autowired
	private CategoryDao categoryDao;
	
	@Test
	public void testFind() {
		List<Category> list = categoryDao.findPageObjects("", 0, 6);
		for (Category user : list) {
			System.out.println(user);
		}
		System.out.println(categoryDao.getRowCount(""));
	}
	
	@Test
	public void testUpdate() {
		Category category = new Category();
		category.setId(1);
		category.setName("八卦");
		category.setUrl("wwww");
		int rows = categoryDao.updateObject(category);
		System.out.println("rows:"+rows);
		
	}
	
	@Test
	public void testInsert() {
		Category category = new Category();
		category.setId(7);
		category.setName("舞蹈");
		category.setUrl("wwww");
		int rows = categoryDao.insertObject(category);
		System.out.println("rows:"+rows);
		
	}
}

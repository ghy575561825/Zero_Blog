package com.zero.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zero.blog.entity.Category;
import com.zero.blog.service.CategoryService;
import com.zero.blog.service.UserService;
import com.zero.common.vo.JsonResult;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/doFindObjects")
	public JsonResult doFindObjects(String name, Integer pageCurrent) {
		return new JsonResult(categoryService.findObjects(name, pageCurrent));
	}
	@RequestMapping("/doUpdateObjects")
	public JsonResult doUpdateFindObjects(Category entity) {
		return new JsonResult(categoryService.updateObject(entity));
	}
	@RequestMapping("/doInsertObjects")
	public JsonResult doInsertFindObjects(Category entity) {
		return new JsonResult(categoryService.insertObject(entity));
	}
}

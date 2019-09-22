package com.zero.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zero.blog.entity.Blog;
import com.zero.blog.service.BlogService;
import com.zero.common.vo.JsonResult;

@RestController
@RequestMapping("/blog")
public class BlogController {

	@Autowired
	private BlogService blogService;
	
	/**
	 * 博客删除接口
	 * @param ids
	 * @return
	 */
	@RequestMapping("/doDeleteObject")
	public JsonResult doDeleteObject(Integer... ids) {
		blogService.deleteObject(ids);
		return new JsonResult("delete ok");
	}
	
	/**
	 * 博客更新接口
	 * @param blog
	 * @return
	 */
	@RequestMapping("/doUpdateObject")
	public JsonResult doUpdateObject(Blog blog) {
		blogService.updateObject(blog);
		return new JsonResult("update ok");
	}
	
	/**
	 * 博客添加接口
	 * @param blog
	 * @return
	 */
	@RequestMapping("/doSaveObject")
	public JsonResult doSaveObject(Blog blog) {
		blogService.saveObject(blog);
		return new JsonResult("save ok");
	}
	
	/**
	 * 博客条件查询接口
	 * @param title
	 * @param pageCurrent
	 * @return
	 */
	@RequestMapping("/doFindObjects")
	public JsonResult doFindObjects(String title, Integer pageCurrent) {
		return new JsonResult(blogService.findObjects(title, pageCurrent));
	}
}

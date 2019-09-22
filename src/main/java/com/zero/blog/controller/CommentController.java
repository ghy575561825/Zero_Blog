package com.zero.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zero.blog.entity.Comment;
import com.zero.blog.entity.User;
import com.zero.blog.service.CommentService;
import com.zero.common.vo.JsonResult;
import com.zero.common.vo.PageObject;

@RestController
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@RequestMapping("/doFindObjects")
	public JsonResult doFindObjects(String createdUser, Integer pageCurrent) {
		return new JsonResult(commentService.findPageObjects(createdUser, pageCurrent));
	}
	
	@RequestMapping("/doUpdateObjects")
	public JsonResult doUpdateObjects(Comment entity) {
		return new JsonResult(commentService.updateObject(entity));
	}
	
	@RequestMapping("/doDeleteObjects")
	public JsonResult doDeleteObjects(Integer ids) {
		return new JsonResult(commentService.deleteObjects(ids));
	}
	
	@RequestMapping("/doInsertObjects")
	public JsonResult doInsertObjects(Comment entity) {
		return new JsonResult(commentService.insertObject(entity));
	}
	
	
	
	
	
	
}

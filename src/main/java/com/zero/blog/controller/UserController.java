package com.zero.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zero.blog.entity.User;
import com.zero.blog.service.UserService;
import com.zero.common.vo.JsonResult;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/doDeleteObject")
	public JsonResult doDeleteObject(Integer...ids) {
		userService.deleteObject(ids);
		return new JsonResult("delete ok");
	}
	
	@RequestMapping("/doUpdateObject")
	public JsonResult doUpdateObject(User user) {
		userService.updateObject(user);
		return new JsonResult("update ok");
	}
	
	@RequestMapping("/doSaveObject")
	public JsonResult doSaveObject(User user) {
		userService.saveObject(user);
		return new JsonResult("save ok");
	}
	
	@RequestMapping("/doFindObjects")
	public JsonResult doFindObjects(String username, Integer pageCurrent) {
		return new JsonResult(userService.findObjects(username, pageCurrent));
	}
}

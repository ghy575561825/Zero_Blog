package com.zero.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zero.blog.service.UserService;
import com.zero.common.vo.JsonResult;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/doFindObjects")
	public JsonResult doFindObjects(String username, Integer pageCurrent) {
		return new JsonResult(userService.findObjects(username, pageCurrent));
	}
}

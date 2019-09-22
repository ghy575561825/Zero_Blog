package com.zero.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 登录后台管理使用doIndexUI
 * 登录前端使用index
 * @author Crazy
 *
 */
@Controller
@RequestMapping("/")
public class pageController {
	
	@RequestMapping("doIndexUI")
	public String doIndexUI() {
		return "starter";
	}
	@RequestMapping("blog_insert")
	public String blogInsert() {
		return "blog_insert";
	}
	
	@RequestMapping("{modeulId}")
	public String doModuleUI(@PathVariable String modeulId) {
		return modeulId;
	}
}

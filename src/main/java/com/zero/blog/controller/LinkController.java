package com.zero.blog.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zero.blog.entity.Link;
import com.zero.blog.service.LinkService;
import com.zero.common.vo.JsonResult;

@Controller
@RequestMapping("/link")
public class LinkController {
	
	@Resource()
	private LinkService linkService;

	/**
	 * doFindAll
	 * @return
	 */
	@RequestMapping("doFinaAll")
	public JsonResult doFindAll(){
		List<Link> list = linkService.findAll();
		return new JsonResult(list);
	}
	
	@RequestMapping("doDeleteLinkById")
	public JsonResult doDeleteLinkById(Integer...linkIds) {
		linkService.deleteLinkById(linkIds);
		return new JsonResult("delete OK!");
	}
	
	@RequestMapping("doInsertLink")
	public JsonResult doInsertLink(Link link) {
		linkService.insertLink(link);
		return new JsonResult("insert ok");
	}
	
	@RequestMapping("doFindLinkById")
	public JsonResult doFindLinkById(Integer linkId) {
		List<Link> list = linkService.findLinkById(linkId);
		return new JsonResult(list);
	}
	
	@RequestMapping("doUpdateLinkById")
	public JsonResult doUpdateLinkById(Link link) {
		linkService.updateLinkById(link);
		return new JsonResult("update OK");
	}
	
}

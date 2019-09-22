package com.zero.blog.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zero.blog.entity.Link;

public interface LinkService {
	
	/*查询所有链接*/
	List<Link> findAll();
	
	/*根据id删除链接*/
	int deleteLinkById(@Param("linkIds")Integer...linkIds);
	
	/*新增链接*/
	int insertLink(Link link);
	
	/*根据id查询链接*/
	List<Link> findLinkById(Integer linkId);
	
	/*修改链接*/
	int updateLinkById(Link link);
}

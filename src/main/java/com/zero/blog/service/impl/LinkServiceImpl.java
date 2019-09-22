package com.zero.blog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zero.blog.dao.LinkDao;
import com.zero.blog.entity.Link;
import com.zero.blog.service.LinkService;
import com.zero.common.exception.ServiceException;

@Service
public class LinkServiceImpl implements LinkService{

	@Resource()
	private LinkDao linkDao;
	
	@Override
	public List<Link> findAll() {
		List<Link> list = linkDao.findAll();
		return list;
	}
	
	@Override
	public int deleteLinkById(Integer...linkIds) {
		if(linkIds.length==0||linkIds==null)
			throw new ServiceException("请至少选择一个!");
		int rows = linkDao.deleteLinkById(linkIds);
		if(rows==0)
			throw new ServiceException("此记录不存在！");
		return rows;
	}
	
	@Override
	public int insertLink(Link link) {
		if(link==null)
			throw new IllegalArgumentException("链接内容不能为空");
		int rows = linkDao.insertLink(link);
		return rows;
	}
	
	@Override
	public List<Link> findLinkById(Integer linkId) {
		if(linkId==0||linkId==null)
			throw new ServiceException("该链接不存在");
		List<Link> list = linkDao.findLinkById(linkId);
		return list;
	}
	
	@Override
	public int updateLinkById(Link link) {
		if(link==null)
			throw new ServiceException("该链接可能不存在");
		int row = linkDao.updateLinkById(link);
		return row;
	}
	
}

package com.zero.blog.service;

import com.zero.blog.entity.Comment;
import com.zero.common.vo.PageObject;

public interface CommentService {
	int deleteObjects(Integer... ids);
	
	int updateObject(Comment entity);
	
	int insertObject(Comment entity);
	
	PageObject<Comment> findPageObjects(
			String createdUser,
			Integer pageCurrent);
	
}

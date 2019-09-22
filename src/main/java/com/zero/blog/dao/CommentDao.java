package com.zero.blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zero.blog.entity.Comment;

@Mapper
public interface CommentDao {
	int insertObject(Comment comment);
	
	int updateObject(Comment comment);
	
	int deleteObject(@Param("ids") Integer... ids );
	
	int getRowCount(@Param("createdUser")String createdUser);
	 
	 /**
	  * 分页查询当前页日志信息
	  * @param username 查询条件
	  * @param startIndex 当前页起始位置
	  * @param pageSize 当前页面大小
	  * @return 当前页查询到记录
	  */
	 List<Comment> findPageObjects(
		      @Param("createdUser")String createdUser,
		      @Param("startIndex")Integer startIndex,
		      @Param("pageSize")Integer pageSize);
	
	
}

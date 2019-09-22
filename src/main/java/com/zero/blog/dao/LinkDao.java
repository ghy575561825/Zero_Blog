package com.zero.blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.zero.blog.entity.Link;

@Mapper
public interface LinkDao {

	/*查询所有链接*/
	@Select("select * from t_db_link")
	List<Link> findAll();
	
	/*按id删除链接*/
	int deleteLinkById(@Param("linkIds")Integer...linkIds);
	
	/*添加链接*/
	int insertLink(Link link);
	
	/*按id查询连接*/
	@Select("select * from t_db_link where link_id=#{linkId}")
	List<Link> findLinkById(Integer linkId);
	
	/*修改链接*/
	int updateLinkById(Link link);
}

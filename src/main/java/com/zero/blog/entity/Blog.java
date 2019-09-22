package com.zero.blog.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 博客实体类
 * @author Administrator
 *
 */
@Data
public class Blog implements Serializable {
	
	private static final long serialVersionUID = 4737029447443351403L;
	//id
	private Integer id;
	//博客的类别id
	private Integer cId;
	//博客的主题
	private String title;
	//博客的内容
	private String content;
	//博客的标签名
	private String tags;
	//博客的图片地址
	private String image;
	//博客的点击量
	private Integer clickNum;
	//博客的评论次数
	private Integer commentNum;
	//是否置顶(0-不置顶,1-置顶)
	private Integer isUp;
	//博客的创建时间
	private Date createdTime;
	//博客的更新时间
	private Date updateTime;
}

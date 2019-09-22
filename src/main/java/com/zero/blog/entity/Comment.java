package com.zero.blog.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class Comment implements Serializable{
	
	private static final long serialVersionUID = 393351900625798106L;
	private Integer id;
	private String content;
	private String email;
	private String tel;
	private Date createdTime;
	private String createdUser;
}

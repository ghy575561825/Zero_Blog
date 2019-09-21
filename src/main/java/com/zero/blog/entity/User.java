package com.zero.blog.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 用户实体
 * @author Administrator
 *
 */
@Data
public class User implements Serializable {

	private static final long serialVersionUID = -3914987816499346536L;
	//id
	private Integer id;
	//用户名
	private String username;
	//密码
	private String password;
	//用户名（中文）
	private String nickname;
	//创建时间
	private Date createTime;
	//更新时间
	private Date updateTime;
}

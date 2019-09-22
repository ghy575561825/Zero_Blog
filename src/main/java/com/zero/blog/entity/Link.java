package com.zero.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 这是链接的实体类
 * @author armourer
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Link {
	private Integer linkId;
	private String linkName;
	private String linkAdd;
	private String linkLogo;
}

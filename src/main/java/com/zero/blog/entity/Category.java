package com.zero.blog.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class Category implements Serializable{

private static final long serialVersionUID = -6532633954373464773L;
private Integer id;
private String name;
private String url;

}

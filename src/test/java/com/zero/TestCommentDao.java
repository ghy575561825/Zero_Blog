package com.zero;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zero.blog.dao.CommentDao;
import com.zero.blog.entity.Comment;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCommentDao {

	@Autowired
	private CommentDao commentDao;
	
	@Test
	public void testFind() {
		List<Comment> list = commentDao.findPageObjects("", 0,5);
		for (Comment comment : list) {
			System.out.println(comment);
		}
		System.out.println(commentDao.getRowCount(""));
	}
	
	@Test
	public void testDelete() {
		int rows = commentDao.deleteObject(1);
		System.out.println("rows"+rows);
	}
	
	@Test
	public void testInsert() {
		Comment comment = new Comment();
		comment.setId(1);
		comment.setContent("写的很棒也");
		comment.setEmail("6262.com");
		comment.setCreatedUser("tutu");
		int rows = commentDao.insertObject(comment);
		System.out.println("rows"+rows);
	}
	
	@Test
	public void testUpdate() {
		Comment comment = new Comment();
		comment.setId(1);
		comment.setContent("写的很棒也");
		comment.setEmail("6262.com");
		comment.setCreatedUser("tu~~");
		int rows = commentDao.updateObject(comment);
		System.out.println("rows"+rows);
	}
	
	
	
}

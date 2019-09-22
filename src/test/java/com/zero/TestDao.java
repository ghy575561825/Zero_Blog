package com.zero;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zero.blog.dao.BlogDao;
import com.zero.blog.dao.UserDao;
import com.zero.blog.entity.Blog;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDao {

	@Autowired
	private UserDao userDao;
	@Autowired
	private BlogDao blogDao;
	
	@Test
	public void testUserDao() {
		/*
		 * List<User> list = userDao.findObjects("", 0, 2); for (User user : list) {
		 * System.out.println(user); } System.out.println(userDao.getRowCount(""));
		 */
		/*
		 * User user = new User(); user.setId(7); user.setUsername("Lily");
		 * user.setPassword("123456"); user.setNickname("黄丽"); int rows =
		 * userDao.updateObject(user); System.out.println(rows);
		 */
		int rows = userDao.deleteObject(7,8);
		System.out.println(rows);
	}
	
	@Test
	public void testBlogDao() {
		/*
		 * List<Blog> list = blogDao.findObjects("", 0, 2); for (Blog blog : list) {
		 * System.out.println(blog); } System.out.println(blogDao.getRowCount(""));
		 */
		/*
		 * Blog blog = new Blog(); blog.setId(7); blog.setCId(4);
		 * blog.setTitle("唐诗精选111"); blog.setContent("床前明月光111"); blog.setTags("古诗");
		 * blog.setImage("/static/images.img"); blog.setClickNum(15);
		 * blog.setCommentNum(20); blog.setIsUp(0); int rows =
		 * blogDao.updateObject(blog); System.out.println(rows);
		 */
		System.out.println(userDao.deleteObject(7));
	}
}

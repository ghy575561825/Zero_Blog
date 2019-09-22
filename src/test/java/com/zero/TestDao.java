package com.zero;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.zero.blog.dao.LinkDao;
import com.zero.blog.dao.UserDao;
import com.zero.blog.entity.Link;
import com.zero.blog.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDao {

	@Autowired
	private UserDao userDao;
	@Autowired
	private LinkDao linkDao;
	
	@Test
	public void testUserDao() {
		List<User> list = userDao.findObjects("", 0, 2);
		for (User user : list) {
			System.out.println(user);
		}
		System.out.println(userDao.getRowCount(""));
	}
	@Test
	public void testLinkDao() {
		List<Link> list = linkDao.findAll();
		for(Link link:list) {
			System.out.println(link);
		}
	}
	@Test
	public void testDeleteLinkById() {
		int row = linkDao.deleteLinkById(2);
		System.out.println("被影响的行数："+row);
	}
	
	@Test
	public void testInsertLink() {
		int row = linkDao.insertLink(new Link(null,"新浪","www.sina.com","11"));
		System.out.println("被影响的行数："+row);
	}
	@Test
	public void testFindLinkById() {
		List<Link> list = linkDao.findLinkById(2);
		System.out.println(list);
	}
	
	@Test
	public void testUpdate() {
		int row = linkDao.updateLinkById(new Link(2,"新浪","www.sina.com","新浪.jpg"));
		System.out.println("被影响的行数："+row);
	}
	
}

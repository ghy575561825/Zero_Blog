package com.zero;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zero.blog.dao.UserDao;
import com.zero.blog.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDao {

	@Autowired
	private UserDao userDao;
	
	@Test
	public void testUserDao() {
		List<User> list = userDao.findObjects("", 0, 2);
		for (User user : list) {
			System.out.println(user);
		}
		System.out.println(userDao.getRowCount(""));
	}
}

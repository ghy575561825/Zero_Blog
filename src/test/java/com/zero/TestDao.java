package com.zero;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zero.blog.dao.UserDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDao {

	@Autowired
	private UserDao userDao;
	
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
}

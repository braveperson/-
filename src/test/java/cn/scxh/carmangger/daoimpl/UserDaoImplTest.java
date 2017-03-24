/*package cn.scxh.carmangger.daoimpl;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.scxh.carmangger.dao.SafetyDao;
import cn.scxh.carmangger.dao.UserDao;
import cn.scxh.carmangger.model.Role;
import cn.scxh.carmangger.model.User;

public class UserDaoImplTest {
	private UserDao userDao;
	@Before
	public void setUp() throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		userDao = (UserDao) ctx.getBean("userDao");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testcheckUser() {
		User user = new User("test","test",2);
		User u = userDao.checkUser(user);
		System.out.println("u："+u);
	}
	@Test
	public void testaddUser() {
		
		User user = new User("test","test",2);
		Role role = new Role(1,"aa","dd");
		user.setRole(role);
		userDao.addUser(user);
	}
	@Test
	public void testgetAllUser() {		
		ArrayList<User> lists = userDao.getAllUser();
		System.out.println(lists.size());
		for(User u : lists ){
			System.out.println("u:"+u);
		}
	}

}
*/
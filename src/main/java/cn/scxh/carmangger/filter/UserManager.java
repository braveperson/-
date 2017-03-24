package cn.scxh.carmangger.filter;

import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.scxh.carmangger.dao.UserDao;
import cn.scxh.carmangger.model.Function;
import cn.scxh.carmangger.model.Role;
import cn.scxh.carmangger.model.User;
import cn.scxh.carmangger.utils.WebApplication;

public class UserManager {
	private static UserDao userDao;

	private static UserManager UMG = null;

	public static UserManager getInstance() {
		if (UMG == null) {
			UMG = new UserManager();
			initUserManager();
		}
		return UMG;
	}
/**
 * 一、在此方法中如果不加捕获异常，就会有代码不向下执行的问题
 * 二、
 * @param userId
 * @param action
 * @return
 */
	public boolean getGroupPermission(String userId, String action) {
		try {
			boolean results = false;

			User user = (User) userDao.getUserById(Integer.parseInt(userId));			
			Role role = user.getRole();
			Set<Function> functionLists = role.getFunctionLists();
			for (Function fuction : functionLists) {
				System.out.println("code :" + fuction.getFunction_code());
				if (fuction.getFunction_code().equals(action)) {
					results = true;
					break;
				}
			}
			
			return results;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void initUserManager() {
		// ApplicationContext ctx = new
		// ClassPathXmlApplicationContext("applicationContext.xml");
		// userDao = (UserDao) ctx.getBean("userDao");

		// userDao = (UserDao) WebApplication.getBean("userDao");
		userDao = WebApplication.getBean(UserDao.class);
		System.out.println("...."+userDao);
	}

}

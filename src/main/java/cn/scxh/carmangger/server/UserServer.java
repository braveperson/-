package cn.scxh.carmangger.server;

import java.util.ArrayList;

import cn.scxh.carmangger.dao.UserDao;
import cn.scxh.carmangger.model.User;

public interface UserServer {
	void addUser(User user);

	ArrayList<User> getAllUser();

	void deleteUserById(int user_id);

	User getUserById(int user_id);

	void updateUser(User user);

	User getUserByName(String name);

	User checkUser(User user);

	boolean registerUser(User user);// 注册

	User login(User user); // 登录

	void verifyUser(User user, int role_id);// 审核

	void verifyUser(User user, String roleName);// 审核
}

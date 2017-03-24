package cn.scxh.carmangger.dao;

import java.util.ArrayList;

import cn.scxh.carmangger.model.User;

public interface UserDao {
	void addUser(User user);

	ArrayList<User> getAllUser();

	void deleteUserById(int user_id);

	User getUserById(int user_id);

	void updateUser(User user);

	User getUserByName(String name);

	User checkUser(User user);

}

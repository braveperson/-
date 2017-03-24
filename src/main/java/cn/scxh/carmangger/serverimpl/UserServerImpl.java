package cn.scxh.carmangger.serverimpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.scxh.carmangger.dao.SafetyDao;
import cn.scxh.carmangger.dao.UserDao;
import cn.scxh.carmangger.model.Function;
import cn.scxh.carmangger.model.Module;
import cn.scxh.carmangger.model.Role;
import cn.scxh.carmangger.model.User;
import cn.scxh.carmangger.server.SafetyServer;
import cn.scxh.carmangger.server.UserServer;
@Service("userServer")
public class UserServerImpl implements UserServer {
	/**
	 * 此处可注解多个dao
	 */
	@Autowired
	private UserDao userDao;
	@Autowired
	private SafetyDao safetyDao;

	 /**
     * 注册用户
     * 判断用户是否存在 
     * true 表示注册成功
     * false 注册失败
     */
	@Override
	public boolean registerUser(User user){
		User u = userDao.getUserByName(user.getUser_name());
		if(u == null){
			userDao.addUser(user);
			return true;
		}else{
			return false;
		}
	}
	

	
	
	/**
	 * state 审核是否通过
	 * 1 审核未通过
	 * 2 审核 通过
	 */
	@Override

	public User login(User user) {
		User u = userDao.checkUser(user);
		if(u != null){
			int state = u.getState();
			if(state == 2){
				return u;
			}else{
				return null;
			}
		}else{
		return null;
		}
	}
	/**
	 * 审查用户
	 */
	@Override
	public void verifyUser(User user, int role_id) {
		if(user.getState() == 2){
			Role role = safetyDao.getRoleById(role_id);
			user.setRole(role);
			userDao.updateUser(user);
		}
		
	}
	/**
	 * 审查用户
	 */
	@Override
	public void verifyUser(User user, String RoleName) {
		if(user.getState() == 2){
			Role role = safetyDao.getRoleByName(RoleName);
			user.setRole(role);
			userDao.updateUser(user);
		}
		
	}
	
	@Override
	public void addUser(User user) {
		userDao.addUser(user);
		
	}

	@Override
	public ArrayList<User> getAllUser() {
		ArrayList<User> lists = userDao.getAllUser();
		return lists;
	}

	@Override
	public void deleteUserById(int user_id) {
		userDao.deleteUserById(user_id);
		
	}

	@Override
	public User getUserById(int user_id) {
		User user = userDao.getUserById(user_id);
		return user;
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
		
	}

	@Override
	public User getUserByName(String name) {
		
		return userDao.getUserByName(name);
	}

	@Override
	public User checkUser(User user) {
		
		return userDao.checkUser(user);
	}

	
}
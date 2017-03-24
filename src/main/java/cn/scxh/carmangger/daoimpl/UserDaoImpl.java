package cn.scxh.carmangger.daoimpl;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.stereotype.Repository;

import cn.scxh.carmangger.dao.UserDao;
import cn.scxh.carmangger.model.Module;
import cn.scxh.carmangger.model.User;
@Repository("userDao")
@Scope("singleton")
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session session;
	@Override
	public void addUser(User user) {
		session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();//开启事物
		
		session.save(user);
		
		session.getTransaction().commit();//提交事物

	}
	@Override
	public ArrayList<User> getAllUser() {
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();//开启事物
		
		/*SQLQuery sqlQuery = session.createSQLQuery("select * from user").addEntity(User.class);*/
		
		Query query = session.createQuery("from User");
		
		ArrayList<User> lists =(ArrayList<User>) query.list();
		
	
		session.getTransaction().commit();//提交事物
	
		return lists;
	}
	@Override
	public void deleteUserById(int user_id) {
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();//开启事物
		
		User user = (User) session.get(User.class,user_id);
		session.delete(user);
		
		session.getTransaction().commit();//提交事物
		
	}
	@Override
	public User getUserById(int user_id) {
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();//开启事物
		
		User user = (User) session.get(User.class,user_id);
		
		session.getTransaction().commit();//提交事物
		return user;
		
		
	}
	@Override
	public void updateUser(User user) {
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();//开启事物
		
		session.update(user);
		
		session.getTransaction().commit();//提交事物
		
	}
	@Override
	public User getUserByName(String name) {
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();//开启事物
		
		Query query = session.createQuery("from User where user_name =:name");

		query.setParameter("name", name);

		User user = (User) query.uniqueResult();
		
		session.getTransaction().commit();//提交事物
		return user;
	}
	/**
	 * state 审核是否通过
	 * 1 审核未通过
	 * 2 审核 通过
	 */
	@Override
	public User checkUser(User user) {
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();//开启事物
		
		Query query = session.createQuery("from User u where u.user_name =? and u.password =?");
		query.setString(0,user.getUser_name());
		query.setString(1,user.getPassword());
//		query.setProperties(user); 
		
		ArrayList<User> userLists = (ArrayList<User>) query.list();
		session.getTransaction().commit();//提交事物
		if(userLists.size()>0 && userLists != null){
			return userLists.get(0);
		}else{
			return null;
		}
		
	}

}

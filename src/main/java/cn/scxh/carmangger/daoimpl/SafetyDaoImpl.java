package cn.scxh.carmangger.daoimpl;

import java.util.ArrayList;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import cn.scxh.carmangger.dao.SafetyDao;
import cn.scxh.carmangger.model.Car;
import cn.scxh.carmangger.model.Function;
import cn.scxh.carmangger.model.Module;
import cn.scxh.carmangger.model.Role;
import cn.scxh.carmangger.utils.MyHibernateDaoSupport;

@Repository("safetyDao")
@Scope("singleton")
public class SafetyDaoImpl implements SafetyDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session session;

	@Override
	public ArrayList<Module> getAllModule() {
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		Query query = session.createQuery("FROM Module");
		ArrayList<Module> lists = (ArrayList<Module>) query.list();

		session.getTransaction().commit();
		return lists;
	}

	@Override
	public void addModule(Module module) {
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		session.save(module);

		session.getTransaction().commit();
	}

	@Override
	public Module getModuleById(int id) {
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		Query query = session.createQuery("from Module where module_id =:id");

		query.setParameter("id", id);

		Module module = (Module) query.uniqueResult();

		session.getTransaction().commit();

		return module;
	}

	@Override
	public void deleteModuleById(int id) {
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		Module module = (Module) session.get(Module.class, id);

		session.delete(module);

		session.getTransaction().commit();

	}

	@Override
	public void updateModule(Module module) {
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		session.update(module);

		session.getTransaction().commit();

	}

	@Override
	public void addFunction(Function function) {
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		session.save(function);

		session.getTransaction().commit();

	}

	@Override
	public ArrayList<Function> getAllFunction() {
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		Query query = session.createQuery("FROM Function ");
		ArrayList<Function> lists = (ArrayList<Function>) query.list();

		session.getTransaction().commit();
		return lists;
	}

	@Override
	public Function getFunctionById(int function_id) {
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		Function function = (Function) session.get(Function.class, function_id);
		/**
		 * 获取数据库实例的三种方式 Function function = (Function)
		 * session.get(Function.class, function_id);
		 * 
		 * session.load(arg0, arg1)
		 * 
		 * Query query =
		 * session.createQuery("from Module where module_id =:id");
		 * query.setParameter("id", id); Module module = (Module)
		 * query.uniqueResult();
		 */
		session.getTransaction().commit();
		return function;
	}

	@Override
	public ArrayList<Function> getFunctionByModuleId(int module_id) {
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		Module module = (Module) session.get(Module.class, module_id);
		Set<Function> lists = module.getFunctionLists();
		ArrayList<Function> arrayList = new ArrayList();
		/**
		 * Set转List
		 */
		for (Function function : lists) {
			arrayList.add(function);
		}
		session.getTransaction().commit();
		return arrayList;

	}

	@Override
	public void deleteFunctionById(int id) {
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		Function function = (Function) session.get(Function.class, id);
		session.delete(function);

		session.getTransaction().commit();

	}

	@Override
	public void updateFunction(Function function) {
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		session.update(function);

		session.getTransaction().commit();

	}

	@Override
	public void addRole(Role role) {
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(role);
		session.getTransaction().commit();

	}

	@Override
	public ArrayList<Role> getAllRole() {
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		Query query = session.createQuery("From Role");
		ArrayList lists = (ArrayList) query.list();

		session.getTransaction().commit();
		return lists;
	}

	@Override
	public void deleteRoleById(int id) {
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		Role role = (Role) session.get(Role.class, id);
		
		session.delete(role);

		session.getTransaction().commit();

	}

	@Override
	public void updateRole(Role role) {
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		session.update(role);

		session.getTransaction().commit();

	}

	@Override
	public Role getRoleById(int role_id) {
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		Role role = (Role) session.get(Role.class, role_id);

		session.getTransaction().commit();
		return role;
	}

	@Override
	public Role getRoleByName(String role_name) {
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		Query query = session
				.createQuery("from Role where role_name =:role_name");

		query.setParameter("role_name", role_name);

		Role role = (Role) query.uniqueResult();

		session.getTransaction().commit();

		return role;
	}

}

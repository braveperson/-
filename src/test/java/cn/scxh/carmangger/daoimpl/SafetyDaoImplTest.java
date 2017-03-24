/*package cn.scxh.carmangger.daoimpl;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.scxh.carmangger.dao.SafetyDao;
import cn.scxh.carmangger.model.Function;
import cn.scxh.carmangger.model.Module;
import cn.scxh.carmangger.model.Role;

public class SafetyDaoImplTest {
	private SafetyDao safetyDao;
	@Before
	public void setUp() throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		safetyDao = (SafetyDao) ctx.getBean("safetyDao");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testaddModule() {
		
		
		Module module = new Module("角色模块2","对角色的增删改查");
		safetyDao.addModule(module);
	}

	@Test
	public void testgetALLModule() {
		ArrayList<Module> lists = safetyDao.getAllModule();
		for(Module module : lists){
			System.out.println(module);
		}
	}
	
	@Test
	public void testGETModule() {
		Module module = safetyDao.getModuleById(4);
		System.out.println(module);
		
	}
	
	@Test
	public void testaddFunction() {
		Module module = safetyDao.getModuleById(4);
		Function function = new Function("add_function.do2","添加功能2",module);
		safetyDao.addFunction(function);
	}
	
	@Test
	public void testgetALLFunction() {
		ArrayList<Function> lists = safetyDao.getAllFunction();
		for(Function function : lists){
			System.out.println(function);
		}
	}
	@Test
	public void testgetFunctionByModule_id() {
		ArrayList<Function> lists = safetyDao.getFunctionByModuleId(4);
		for(Function function : lists){
			System.out.println(function);
		}
	}
	
	@Test
	public void testaddRole() {
		Role role = new Role("二级管理员","管理车辆");
		safetyDao.addRole(role);
	}
	@Test
	public void testGetAllRole() {
		ArrayList<Role> lists = safetyDao.getAllRole();
		for(Role role : lists){
			System.out.println(role);
		}
	}
	
	@Test
	public void testgetRoleById() {
		Role role = safetyDao.getRoleById(1);		
			System.out.println(role);		
	}
	@Test
	public void testdeleteRole() {
		 safetyDao.deleteRoleById(10);
		
				
	}
	
	@Test
	public void testgetRoleByname() {
		Role role = safetyDao.getRoleByName("一级管理员");
			System.out.println(role);		
	}
}
*/
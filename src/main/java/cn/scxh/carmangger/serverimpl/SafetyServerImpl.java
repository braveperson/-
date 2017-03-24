package cn.scxh.carmangger.serverimpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.scxh.carmangger.dao.SafetyDao;
import cn.scxh.carmangger.model.Function;
import cn.scxh.carmangger.model.Module;
import cn.scxh.carmangger.model.Role;
import cn.scxh.carmangger.server.SafetyServer;

@Service("safetyServer")
public class SafetyServerImpl implements SafetyServer {
	@Autowired
	private SafetyDao safetyDao;

	@Override
	public void addModule(Module module) {
		safetyDao.addModule(module);

	}

	@Override
	public ArrayList<Module> getAllModule() {
		return safetyDao.getAllModule();

	}

	@Override
	public Module getModuleById(int id) {

		return safetyDao.getModuleById(id);
	}

	@Override
	public void deleteModuleById(int id) {
		safetyDao.deleteModuleById(id);

	}

	@Override
	public void updateModule(Module module) {
		safetyDao.updateModule(module);

	}

	@Override
	public void addFunction(Function function) {

		safetyDao.addFunction(function);

	}

	@Override
	public ArrayList<Function> getAllFunction() {
		return safetyDao.getAllFunction();
	}

	@Override
	public ArrayList<Function> getFunctionByModuleId(int module_id) {

		return safetyDao.getFunctionByModuleId(module_id);
	}

	@Override
	public Function getFunctionById(int function_id) {
		return safetyDao.getFunctionById(function_id);
	}

	@Override
	public void deleteFunctionById(int id) {
		safetyDao.deleteFunctionById(id);

	}

	@Override
	public void updateFunction(Function function) {
		safetyDao.updateFunction(function);

	}

	@Override
	public void addRole(Role role) {
		safetyDao.addRole(role);

	}

	@Override
	public ArrayList<Role> getAllRole() {

		return safetyDao.getAllRole();
	}

	@Override
	public void deleteRoleById(int id) {
		safetyDao.deleteRoleById(id);

	}

	@Override
	public void updateRole(Role role) {
		safetyDao.updateRole(role);

	}

	@Override
	public Role getRoleById(int role_id) {

		return safetyDao.getRoleById(role_id);
	}

	@Override
	public Role getRoleByName(String role_name) {
		
		return safetyDao.getRoleByName(role_name);
	}

}

package cn.scxh.carmangger.dao;

import java.util.ArrayList;

import cn.scxh.carmangger.model.Function;
import cn.scxh.carmangger.model.Module;
import cn.scxh.carmangger.model.Role;

public interface SafetyDao {
	// ===module===
	void addModule(Module module);

	ArrayList<Module> getAllModule();

	Module getModuleById(int id);

	void deleteModuleById(int id);

	void updateModule(Module module);

	// ===function===
	void addFunction(Function function);

	ArrayList<Function> getAllFunction();

	Function getFunctionById(int function_id);

	ArrayList<Function> getFunctionByModuleId(int module_id);

	void deleteFunctionById(int id);

	void updateFunction(Function function);

	// ===Role===
	void addRole(Role role);

	ArrayList<Role> getAllRole();

	void deleteRoleById(int id);

	void updateRole(Role role);

	Role getRoleById(int role_id);

	Role getRoleByName(String role_name);
}

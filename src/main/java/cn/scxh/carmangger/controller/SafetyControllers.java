package cn.scxh.carmangger.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.scxh.carmangger.model.Function;
import cn.scxh.carmangger.model.Module;
import cn.scxh.carmangger.model.Role;
import cn.scxh.carmangger.server.SafetyServer;

@Controller
@RequestMapping("/safety")
public class SafetyControllers {
	@Autowired
	private SafetyServer safetyServer;

	// ==========模块action==========

	@RequestMapping("/formAdd_module")
	public String addForm() {
		return "/module/add_module";
	}

	@RequestMapping("/addModule")
	public String addModule(Module module, Model model) {

		safetyServer.addModule(module);

		return "redirect:/safety/listModule.do";
	}

	@RequestMapping("/listModule")
	public String ModuleList(Model model) {
		ArrayList lists = safetyServer.getAllModule();
		model.addAttribute("lists", lists);
		return "/module/lists_module";

	}

	@RequestMapping("/deleteModule")
	public String deleteModule(Integer module_id) {
		safetyServer.deleteModuleById(module_id);

		return "redirect:/safety/listModule.do";

	}

	@RequestMapping("/getModule")
	public String getModule(Integer module_id, Model model) {
		Module module = safetyServer.getModuleById(module_id);
		model.addAttribute("module", module);
		return "/module/update_module";

	}

	@RequestMapping("/updateModule")
	public String updateModule(Module module,Integer module_id) {
		Module m = safetyServer.getModuleById(module_id);
		m.setModule_name(module.getModule_name());
		m.setDescription(module.getDescription());
		safetyServer.updateModule(m);

		return "redirect:/safety/listModule.do";

	}

	@RequestMapping("/listModule_Function")
	public String listModule_Function(Integer module_id, Model model) {		
		ArrayList lists = safetyServer.getFunctionByModuleId(module_id);
		model.addAttribute("lists", lists);
		model.addAttribute("module_id", module_id);
		return "/function/lists_function";
	}

	// ==========功能action==========

	@RequestMapping("/addFunctionForm")
	public String addFunctionForm(Integer module_id, Model model) {

		return "/function/add_function";
	}

	@RequestMapping("/addFunction")
	public String addFunction(Function function, Integer module_id, Model model) {
		System.out.println("module_id:" + module_id);
		Module module = safetyServer.getModuleById(module_id);
		function.setModule(module);
		safetyServer.addFunction(function);

		return "redirect:/safety/listModule_Function.do?module_id=" + module_id;
	}

	@RequestMapping("/listFunction")
	public String FunctionList(Model model) {
		ArrayList lists = safetyServer.getAllFunction();
		model.addAttribute("lists", lists);
		return "/function/lists_function";
	}

	@RequestMapping("/deleteFunction")
	public String deleteFunction(Integer function_id) {
		safetyServer.deleteFunctionById(function_id);
		return "redirect:/safety/listFunction.do";
	}

	@RequestMapping("/getFunction")
	public String getFunction(Integer function_id, Model model) {

		Function function = safetyServer.getFunctionById(function_id);
		model.addAttribute("function", function);
		return "/function/update_function";
	}

	@RequestMapping("/updateFunction")
	public String updateFunction(Function function, Integer function_id) {
		Function f = safetyServer.getFunctionById(function_id);
		f.setFunction_code(function.getFunction_code());
		f.setDescription(function.getDescription());
		safetyServer.updateFunction(f);
		return "redirect:/safety/listFunction.do";

	}

	// ==========角色action==========
	@RequestMapping("/formAddRole")
	public String addRoleForm() {
		return "/role/add_role";
	}

	/**
	 * 添加角色
	 * 
	 * @param role
	 * @param model
	 * @return
	 */
	@RequestMapping("/addRole")
	public String addRole(Role role, Model model) {
		safetyServer.addRole(role);
		return "redirect:/safety/listRole.do";
	}

	/**
	 * 角色列表
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/listRole")
	public String listRole(Model model) {
		ArrayList lists = safetyServer.getAllRole();
		model.addAttribute("lists", lists);
		return "/role/lists_role";
	}

	/**
	 * 删除单个角色
	 * 
	 * @param role_id
	 * @return
	 */
	@RequestMapping("/deleteRole")
	public String deleteRole(Integer role_id) {
		System.out.println("role_id：" + role_id);
		safetyServer.deleteRoleById(role_id);
		return "redirect:/safety/listRole.do";
	}

	/**
	 * 查找单个角色
	 * 
	 * @param role_id
	 * @param model
	 * @return
	 */
	@RequestMapping("/getRole")
	public String getRole(Integer role_id, Model model) {
		Role role = safetyServer.getRoleById(role_id);
		model.addAttribute("role", role);
		return "/role/update_role";
	}

	/**
	 * 修改角色名和角色描述
	 * 
	 * @param role
	 * @param model
	 * @return
	 */
	@RequestMapping("/updateRole")
	public String updateRole(Role role,Integer role_id) {
		Role r = safetyServer.getRoleById(role_id);
		r.setRole_name(role.getRole_name());
		r.setDescription(role.getDescription());
		safetyServer.updateRole(r);
		return "redirect:/safety/listRole.do";
	}

	/**
	 * 查看角色功能
	 * 
	 * @param role_id
	 * @param map
	 * @param model
	 * @return
	 */
	@RequestMapping("/listRoleFunction")
	public String RoleFunction(Integer role_id,
			Map<String, List<Function>> map, Model model) {
		Role role = safetyServer.getRoleById(role_id);

		Set<Function> lists = role.getFunctionLists();// 角色已经被赋予的功能集合
		ArrayList<Function> RolefunctionLists = new ArrayList<Function>();
		for (Function f : lists) {
			RolefunctionLists.add(f);
		}
		List<Function> AllFunctionLists = safetyServer.getAllFunction();// 所有模块所有功能集合
		map.put("RolefunctionLists", RolefunctionLists);
		map.put("AllFunctionLists", AllFunctionLists);
		model.addAttribute("role_id", role_id);
		return "/role/lists_rolefunction";
	}

	/**
	 * 更新角色功能
	 * 
	 * @param role_id
	 * @param map
	 * @param model
	 * @return
	 */
	@RequestMapping("/submitUpdateRoleFunction")
	public String submitUpdateRoleFunction(Integer role_id, Integer[] selectId) {
		Role role = safetyServer.getRoleById(role_id);
		role.getFunctionLists().clear();

		Set<Function> RolefunctionLists = new HashSet<Function>();

		for (Integer function_id : selectId) {
			Function function = safetyServer.getFunctionById(function_id);
			RolefunctionLists.add(function);
		}

		role.setFunctionLists(RolefunctionLists);
		safetyServer.updateRole(role);
		return "redirect:/safety/listRoleFunction.do?role_id=" + role_id;
	}

}

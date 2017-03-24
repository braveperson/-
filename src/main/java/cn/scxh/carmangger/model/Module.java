package cn.scxh.carmangger.model;

import java.util.Set;

public class Module {
	private int module_id;// 模块id
	private String module_name;// 模块名
	private String description;// 模块描述
	private Set<Function> functionLists;

	public Module() {
	}

	public Module(int module_id, String module_name, String description,
			Set<Function> functionLists) {
		this.module_id = module_id;
		this.module_name = module_name;
		this.description = description;
		this.functionLists = functionLists;
	}

	public Module(String module_name, String description) {
	
		this.module_name = module_name;
		this.description = description;

	}
	
	

	public Module(int module_id, String module_name, String description) {
	
		this.module_id = module_id;
		this.module_name = module_name;
		this.description = description;
	}

	public int getModule_id() {
		return module_id;
	}

	public void setModule_id(int module_id) {
		this.module_id = module_id;
	}

	public String getModule_name() {
		return module_name;
	}

	public void setModule_name(String module_name) {
		this.module_name = module_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Function> getFunctionLists() {
		return functionLists;
	}

	public void setFunctionLists(Set<Function> functionLists) {
		this.functionLists = functionLists;
	}

	@Override
	public String toString() {
		return "Module [module_id=" + module_id + ", module_name="
				+ module_name + ", description=" + description
				+ ", functionLists=" + "]";
	}

}

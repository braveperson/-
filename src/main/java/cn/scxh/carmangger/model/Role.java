package cn.scxh.carmangger.model;

import java.util.Set;

public class Role {
	private int role_id;// 角色id
	private String role_name;// 角色名
	private String description;// 角色描述
	private Set<Function> functionLists;// 角色功能
	private Set<User> userLists;// 角色用户

	public Role() {
	}

	public Role(String role_name, String description) {

		this.role_name = role_name;
		this.description = description;

	}

	public Role(int role_id, String role_name, String description) {
		this.role_id = role_id;
		this.role_name = role_name;
		this.description = description;

	}

	public Role(int role_id, String role_name, String description,
			Set<Function> functionLists) {
		this.role_id = role_id;
		this.role_name = role_name;
		this.description = description;
		this.functionLists = functionLists;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
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

	public Set<User> getUserLists() {
		return userLists;
	}

	public void setUserLists(Set<User> userLists) {
		this.userLists = userLists;
	}

	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", role_name=" + role_name
				+ ", description=" + description + "" + "]";
	}

}

package cn.scxh.carmangger.model;

public class User {
	private int user_id;// 用户id
	private String user_name;// 用户名
	private String password;// 用户密码
	private int state;// 用户状态
	private Role role;// 对应角色

	public User() {
	}

	public User(String user_name, String password, int state) {
		this.user_name = user_name;
		this.password = password;
		this.state = state;

	}

	public User(int user_id, String user_name, String password, int state,
			Role role) {
		this.user_id = user_id;
		this.user_name = user_name;
		this.password = password;
		this.state = state;
		this.role = role;
	}

	public User(int user_id, String user_name, String password, int state) {
		this.user_id = user_id;
		this.user_name = user_name;
		this.password = password;
		this.state = state;

	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name
				+ ", password=" + password + ", state=" + state + ", role="
				+ "]";
	}

}

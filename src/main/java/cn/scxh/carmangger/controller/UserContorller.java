package cn.scxh.carmangger.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

import cn.scxh.carmangger.model.Role;
import cn.scxh.carmangger.model.User;
import cn.scxh.carmangger.server.SafetyServer;
import cn.scxh.carmangger.server.UserServer;

@Controller
@RequestMapping("/user")
public class UserContorller {

	@Autowired
	private UserServer userServer;

	@Autowired
	private SafetyServer safetyServer;

	@RequestMapping("/addFormUser")
	public String addFormUser() {
		return "/user/add_user2";
	}

	@RequestMapping("/addUser")
	public void addUser(HttpServletResponse response, String name1)
			throws IOException {
		String mas = "";
		Map<String, Object> repMap = new HashMap<String, Object>();
		User user = userServer.getUserByName(name1);
		if (userServer.getUserByName(name1) != null) {
			mas = "no";
		}

		repMap.put("mas", mas);
		Gson gosn = new Gson();
		String Json = gosn.toJson(repMap);
		response.getWriter().write(Json);
		response.getWriter().flush();
		response.getWriter().close();

		/*
		 * User user = new User(user_name,password,state);
		 * if(userServer.registerUser(user)){
		 *  model.addAttribute("mess","注册成功,请等待一级管理员审核通过方可使用！谢谢！"); 
		 *  return "/user/add_user2"; 
		 *  }else{
		 * PrintWriter pw = response.getWriter(); pw.println("sss"); //
		 * model.addAttribute("message", "用户已存在"); return "/user/add_user2"; }
		 */
	}
	@RequestMapping("/registerUser")
	public String registerUser(String user_name,String password,Integer state,Model model){
		User user = new User(user_name,password,state);
		if(userServer.registerUser(user)){	
			model.addAttribute("mess","注册成功,请等待一级管理员审核通过方可使用！谢谢！");
			return "/user/add_user2";
		}else{
			model.addAttribute("message", "用户已存在");
			return "/user/add_user2";
		}
		
	}
	
	@RequestMapping("/listUser")
	public String listUser(Model model) {

		ArrayList<User> lists = userServer.getAllUser();
		model.addAttribute("lists", lists);
		return "/user/lists_user";
	}

	@RequestMapping("/deleteUser")
	public String deleteUser(Integer user_id, Model model) {
		userServer.deleteUserById(user_id);
		return "redirect:/user/listUser.do";
	}

	@RequestMapping("/getUser")
	public String getUser(HttpServletRequest request, Integer user_id,
			Model model) {
		HttpSession session = request.getSession();
		String userId = session.getAttribute("user_id").toString();
		int uid = Integer.parseInt(userId);
		if (user_id == uid) {
			User user = userServer.getUserById(user_id);
			model.addAttribute("user", user);
			return "/user/update_user";
		} else {
			return "/user/error";
		}
	}

	@RequestMapping("/updateUser")
	public String updateUser(Integer user_id, User user, Model model) {
		User u = userServer.getUserById(user_id);
		u.setPassword(user.getPassword());
		userServer.updateUser(u);
		return "redirect:/user/listUser.do";
	}

	/**
	 * 审核用户界面
	 */
	@RequestMapping("/verify_user")
	public String verify_userForm(Integer user_id, Model model) {
		User user = userServer.getUserById(user_id);
		ArrayList<Role> lists = safetyServer.getAllRole();
		model.addAttribute("lists", lists);
		model.addAttribute("user", user);
		return "/user/verify_user";
	}

	/**
	 * 审核用户
	 * 
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping("/verifyUser")
	public String verifyUser(User user, String roleName, Model model) {
		// System.out.println("user:"+user);
		// System.out.println("roleName:"+roleName);
		userServer.verifyUser(user, roleName);
		return "redirect:/user/listUser.do";
	}
}

package cn.scxh.carmangger.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.scxh.carmangger.model.User;
import cn.scxh.carmangger.server.UserServer;

@Controller
public class LoginController {
	@Autowired
	private UserServer userServer;

	@RequestMapping("/login")
	public String login() {
		return "login"; // 此处返回值是和jsp文件名一致
	}

	/*
	 * @RequestMapping("/login_submit") public String main(HttpServletRequest
	 * request,User user,Model model){ User u =
	 * userServer.login(user);//判断用户state 审核是否通过 if(userServer.login(user) ==
	 * null){ model.addAttribute("error","用户名、密码错误或还未审核您的用户！"); return "login";
	 * }else{ HttpSession session = request.getSession();
	 * System.out.println("u.getUser_id()  :"+u.getUser_id());
	 * session.setAttribute("user_id", u.getUser_id()); return "main"; } }
	 */

	@RequestMapping("/login_submit")
	public String main(HttpServletRequest request,
			HttpServletResponse response, User user, Model model) {
		User u = userServer.login(user);// 判断用户state 审核是否通过
		String userName = u.getUser_name();
		String passWord = u.getPassword();
		String autoLogin = request.getParameter("autoLogin");

		if (userServer.login(user) == null) {
			model.addAttribute("error", "用户名、密码错误或还未审核您的用户！");
			return "login";
		} else if ("true".equals(autoLogin)) {// 判断是否保存cookie状态
			saveCookie(response, userName, passWord, 60 * 2);

			HttpSession session = request.getSession();
			session.setAttribute("user_id", u.getUser_id());
			return "main";
		} else {
			saveCookie(response, userName, passWord, 0);

			HttpSession session = request.getSession();
			session.setAttribute("user_id", u.getUser_id());
			return "main";
		}
	}

	public void saveCookie(HttpServletResponse response, String userName,
			String passWord, int maxAGE) {
		Cookie cookie_use = new Cookie("name", userName);
		Cookie cookie_psw = new Cookie("psw", passWord);
		cookie_use.setMaxAge(maxAGE);
		cookie_psw.setMaxAge(maxAGE);
		response.addCookie(cookie_use);
		response.addCookie(cookie_psw);
	}
}
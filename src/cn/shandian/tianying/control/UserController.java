package cn.shandian.tianying.control;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import cn.shandian.tianying.entity.User;
import cn.shandian.tianying.service.UserServer;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserServer userSever;

	@RequestMapping("/queryUser.do")
	public String login(User user, HttpSession session, Model model) {
		System.out.println(user.getUserName());
		List<User> users = userSever.selectUsers(user.getUserName());
		System.out.println(users);
		model.addAttribute("data", users);
		return "/admin/homePage";
	}

	@RequestMapping("/updateUser.do")
	public String update(String userName, HttpSession session, Model model) {
		List<User> users = userSever.selectUsers(userName);
		model.addAttribute("data", users);
		return "/admin/editUser";
	}

	@RequestMapping("/saveUser.do")
	public String save(User user, HttpSession session, Model model) {
		try {
			userSever.updateUser(user);
		} catch (Exception e) {
			System.out.println("exeption");
			e.printStackTrace();
			model.addAttribute("errorMessage", "保存信息失败请检查！");
			return "redirect:/aUser.do";
		}
		return "/admin/homePage";
	}

	@RequestMapping("/aUser.do")
	public String auser(User user, HttpSession session, Model model) {
		// userSever.addUser(user);
		// model.addAttribute("data", users);
		return "/admin/addUser";
	}

	@RequestMapping("/addUser.do")
	public String add(User user, HttpSession session, Model model) {
		try {
			userSever.addUser(user);
		} catch (Exception e) {
			System.out.println("exeption");
			e.printStackTrace();
			model.addAttribute("errorMessage", "保存信息失败请检查！");
			return "/admin/addUser";
		}
		// model.addAttribute("data", users);
		return "/admin/homePage";
	}

	@RequestMapping("/delUser.do")
	public String delUser(String id, HttpSession session, Model model) {
		userSever.deleteUser(id);
		// model.addAttribute("data", users);
		return "/admin/homePage";
	}
}

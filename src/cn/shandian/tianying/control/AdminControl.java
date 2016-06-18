package cn.shandian.tianying.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.filter.CharacterEncodingFilter;

import cn.shandian.tianying.entity.User;
import cn.shandian.tianying.service.UserServer;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/admin")
public class AdminControl {
	private UserServer userSever;

	public UserServer getUserSever() {
		return userSever;
	}

	@Resource(name = "userServer")
	public void setUserSever(UserServer userSever) {
		this.userSever = userSever;
	}
	
	
	@RequestMapping("/login.do")
	public String login(User user, HttpSession session, Model model) {
		if (userSever.loginUser(user) == null) {
			model.addAttribute("errorMessage", "用户名不存在！");
			return "/index";
		}
		if (userSever.loginPasswordUswer(user) == null) {
			model.addAttribute("errorMessage", "密码错误！");
			return "/index";
		}
		session.setAttribute("userName", user.getUserName());
		return "/admin/homePage";
	}
	
	@RequestMapping("/paramtest.do")
	public @ResponseBody Map<String, String> paramtest(@RequestBody Map<String, String> params, HttpSession session) {
		String userName = params.get("userName");
		String moduleName = params.get("moduleName");
		String computerinfo_defaultBrowser = params.get("computerinfo_defaultBrowser");
		System.out.println("userName:" + userName);
		System.out.println("moduleName:" + moduleName);
		System.out.println("computerinfo_defaultBrowser:" + computerinfo_defaultBrowser);

		return params;
		// return "/admin/homePage";

	}

	@RequestMapping(value = "/pets/{petId}/{ownerId}", produces = "text/plain;charset=UTF-8")
	public @ResponseBody String findPet(@PathVariable String ownerId, @PathVariable String petId, Model model,
			@RequestHeader("Accept-Encoding") String encoding) {
		System.out.println("ownerId:" + ownerId);
		System.out.println("petId:" + petId);
		// , @RequestHeader("Keep-Alive") long keepAlive,
		// @CookieValue("JSESSIONID") String cookie)
		return "欢迎您encoding" + encoding ;
	}

	@RequestMapping("/param.do")
	public @ResponseBody String param(@RequestBody Map<String, String> params, HttpSession session) {

		System.out.println("paramtest:" + params);
		return "homePage";
		// return "/admin/homePage";
	}


	@RequestMapping("/test.do")
	public @ResponseBody String login(HttpSession session, Model model) {
		return "callback(aaa)";
	}

	@RequestMapping("/toHomePage.do")
	public String toHomePage() {
		return "/admin/homePage";
	}

	@RequestMapping("/hello.do")
	public String hello() {
		System.out.println("/admin/hello.do");
		return "homePage";
	}

	@RequestMapping("/loginOut.do")
	public String loginOut(HttpSession session, Model model) {
		session.invalidate();
		return "redirect:/admin/login.do";
		// return "/admin/homePage";

	}

	//
	@RequestMapping(value = "/welcome/{name}", produces = "text/plain;charset=UTF-8")
	public @ResponseBody String welcome(@PathVariable String name) {
		// User u = new User();
		// u.setUserName("admin");
		// u.setUserAddress("天河区人展大中115号");
		return "Welcome" + name;
	}

	@RequestMapping(value = "/getUserName", method = RequestMethod.POST)
	public String getUserName(@RequestParam(value = "name") String name) {
		return name;
	}

	@RequestMapping(value = "/say/{msg}", produces = "application/json;charset=UTF-8")
	public @ResponseBody String say(@PathVariable(value = "msg") String msg) {
		return "{\"msg\":\"you say:'" + msg + "'\"}";
	}

	@RequestMapping(value = "/person/{id:\\d+}", method = RequestMethod.GET)
	public @ResponseBody User getPerson(@PathVariable("id") int id) {
		User person = new User();
		person.setUserName("张三");
		person.setUserAge("30");
		person.setId(id);
		return person;
	}

	@RequestMapping(value = "/person/{id:\\d+}", method = RequestMethod.DELETE)
	public @ResponseBody Object deletePerson(@PathVariable("id") int id) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("msg", "删除人员信息成功");
		return jsonObject;
	}

	// @RequestMapping(value = "/person", method = RequestMethod.POST)
	// public @ResponseBody Object addPerson(User person) {
	// JSONObject jsonObject = new JSONObject();
	// return jsonObject;
	// }

	@RequestMapping(value = "/person", method = RequestMethod.PUT)
	public @ResponseBody Object updatePerson(User person) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("msg", "更新人员信息成功");
		return jsonObject;
	}

	@RequestMapping(value = "/person", method = RequestMethod.POST)
	public @ResponseBody List<User> listPerson(
			@RequestParam(value = "name", required = false, defaultValue = "") String name) {

		List<User> lstPersons = new ArrayList<User>();

		User person1 = new User();
		person1.setUserName("张三");
		person1.setUserAge("30");
		person1.setId(23);
		lstPersons.add(person1);

		User person2 = new User();
		person2.setUserName("李四");
		person2.setUserAge("45");
		person2.setId(23);
		lstPersons.add(person2);
		;

		User person3 = new User();
		person3.setUserName("王麻子");
		person3.setUserAge("50");
		person3.setId(23);
		lstPersons.add(person3);

		return lstPersons;
	}

}

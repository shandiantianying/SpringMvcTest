package cn.shandian.tianying.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import cn.shandian.tianying.entity.User;

@Component("userServer")
public class UserServer {

	private IUserLoginServer userLoginServer;

	public IUserLoginServer getUserLoginServer() {
		return userLoginServer;
	}

	@Resource(name = "userLoginServerImp")
	public void setUserLoginServer(IUserLoginServer userLoginServer) {
		this.userLoginServer = userLoginServer;
	}

	public User loginUser(User user) {

		ApplicationContext act = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println(act.getBean("userLoginServerImp"));

		return userLoginServer.loginUser(user);
	}

	public User loginPasswordUswer(User user) {
		return userLoginServer.loginUserPassword(user);
	}

	public List<User> selectUsers(String userName) {
		return userLoginServer.selectUsers(userName);
	}

	public void addUser(User user) {
		userLoginServer.addUser(user);
	}

	public void updateUser(User user) {
		userLoginServer.updateUser(user);
	}

	public void deleteUser(String id) {
		userLoginServer.deleteUser(id);
	}
}

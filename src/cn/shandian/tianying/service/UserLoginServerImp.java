package cn.shandian.tianying.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import cn.shandian.tianying.entity.User;
import cn.shandian.tianying.utils.ConDBUtils;

@Controller("userLoginServerImp")
public class UserLoginServerImp implements IUserLoginServer {

	@Override
	public User loginUser(User user) {

		return ConDBUtils.getiUser().loginUser(user);
	}

	@Override
	public User loginUserPassword(User user) {
		return ConDBUtils.getiUser().loginUserPassword(user);
	}

	@Override
	public List<User> selectUsers(String userName) {
		return ConDBUtils.getiUser().selectUsers(userName);
	}

	public void addUser(User user) {
		ConDBUtils.getiUser().addUser(user);
	}

	public void updateUser(User user) {
		ConDBUtils.getiUser().updateUser(user);
	}

	@Override
	public void deleteUser(String id) {
		ConDBUtils.getiUser().deleteUser(id);
	}

}

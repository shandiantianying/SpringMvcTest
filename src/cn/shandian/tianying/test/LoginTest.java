package cn.shandian.tianying.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.shandian.tianying.entity.IUser;
import cn.shandian.tianying.entity.User;
import cn.shandian.tianying.service.IUserLoginMapper;
import cn.shandian.tianying.service.IUserLoginServer;

public class LoginTest {

	private static ApplicationContext act;

	public static IUserLoginServer getiUser() {
		return getiUser();
	}

	static {
		act = new ClassPathXmlApplicationContext("beans.xml");

	}

	@Test
	public void test() {
		User user = new User();
		user.setUserName("admin");
		IUser iuser = (IUser)act.getBean("userMapp");
		System.out.println(iuser.selectUserById(1));
	}
	@Test 
	public void testM(){
		User user = new User();
		user.setUserName("zhou");
		
		IUserLoginMapper iUser = (IUserLoginMapper) act.getBean("userMapper");
	//	System.out.print(iUser.selectUserById(1));
		System.out.print(iUser.loginUser(user));
		// System.out.print(iUser.loginUser(user));
	}
	
	@Test 
	public void testN(){
		User user = new User();
		user.setUserName("zhou");
		
		IUserLoginMapper iUser = (IUserLoginMapper) act.getBean("userMapper");
	//	System.out.print(iUser.selectUserById(1));
		System.out.print(iUser.selectUsers(""));
		// System.out.print(iUser.loginUser(user));
	}
	
}

package cn.shandian.tianying.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.shandian.tianying.service.IUserLoginMapper;
import cn.shandian.tianying.service.IUserLoginServer;

public class ConDBUtils {
	private static IUserLoginMapper iUser;

	private static ApplicationContext act;

	public static IUserLoginMapper getiUser() {
		return iUser;
	}

	static {
		act = new ClassPathXmlApplicationContext("beans.xml");
		iUser = (IUserLoginMapper) act.getBean("userMapper");
	}
}

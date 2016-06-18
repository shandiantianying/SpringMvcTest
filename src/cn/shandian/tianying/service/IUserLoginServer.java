package cn.shandian.tianying.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.shandian.tianying.entity.User;

public interface IUserLoginServer {
	public User loginUser(User user);
	public User loginUserPassword(User user);
	public List<User> selectUsers(String userName);
	public void addUser(User user);
	public void updateUser(User user);
	public void deleteUser(String id);
}

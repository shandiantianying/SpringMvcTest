package cn.shandian.tianying.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.shandian.tianying.entity.User;

public interface IUserLoginMapper {
	public User selectUserById(int id);

	public User loginUser(User user);

	public User loginUserPassword(User user);

	public List<User> selectUsers(@Param(value = "userName") String userName);

	public void addUser(User user);

	public void updateUser(User user);

	public void deleteUser(@Param(value = "id") String id);

}

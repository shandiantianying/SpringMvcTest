package cn.shandian.tianying.entity;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface IUser {
	public User selectUserById(int id);

	public List<User> selectUsers(@Param(value = "userName") String userName);

	public void addUser(User user);
}

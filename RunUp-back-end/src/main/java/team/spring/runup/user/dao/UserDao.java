package team.spring.runup.user.dao;

import team.spring.runup.user.vo.User;

public interface UserDao {

	User getUser(User insertUser);

	User getUserById(String userId);

	int registUser(User user);

	int updateUser(User user);

	int deleteUser(String userId);


}

package team.spring.runup.user.dao;

import java.util.List;

import team.spring.runup.user.vo.User;

public interface UserDao {

	User getUser(User insertUser);

	User getUserById(String userId);
	
	List<User> getUserByNickname(String userNickname);

	int registUser(User user);

	int updateUser(User user);

	int deleteUser(String userId);

	User getUserByIdPhone(User user);

	int changePw(User user);


}

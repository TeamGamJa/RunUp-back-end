package team.spring.runup.user.dao;

import java.util.List;

import team.spring.runup.user.vo.User;

public interface UserDao {

	User getUser(User insertUser);

	User getUserById(String userId);
	
	User getUserByNum(int userNum);
	
	String getUserUrlByUserNum(int userNum);
	
	List<User> getUserByNickname(String userNickname);
	
	int getPointByUserNickname(User user);

	int registUser(User user);

	int updateUser(User user);
	
	int updateProfile(User user);
	
	int updateUserLuxColor(User user);
	
	int updateFinishLearning(User user);
	
	int updateFinishRunning(User user);

	int deleteUser(String userId);

	String getUserByIdPhone(User user);

	int changePw(User user);

	int checkUserNickName(String userNickname);

	int updateUserCategory(User user);

	int checkUserById(String userId);

}

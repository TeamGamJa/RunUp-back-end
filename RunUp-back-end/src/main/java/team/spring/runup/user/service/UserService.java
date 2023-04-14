package team.spring.runup.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.spring.runup.user.dao.UserDao;
import team.spring.runup.user.vo.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao dao;

	public User getUser(User insertUser) {
		
		User user = dao.getUser(insertUser);
		return user;
	}

	public User getUserById(String userId) {
		User user = dao.getUserById(userId);
		return user;
	}

	public int checkUserId(String userId) {
		
		User user = dao.getUserById(userId);
		if (user.equals(null))
			return 0; // 입력아이디 없음
		else
			return 1; // 입력아이디 존재함
	}

	public int registUser(User user) {
		int result = dao.registUser(user);
		return result;
	}

	public int updateUser(User user) {
		int result = dao.updateUser(user);
		return result;
	}

	public int deleteUser(String userId) {
		int result = dao.deleteUser(userId);
		return result;
	}

}

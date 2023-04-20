package team.spring.runup.user.service;

import java.security.SecureRandom;
import java.util.List;

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
	
	public List<User> getUserByNickname(String userNickname) {
		List<User> list = dao.getUserByNickname(userNickname);
		return list;
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

	public String makeNewPw() {
		
		StringBuilder sb = new StringBuilder();
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		
		SecureRandom random = new SecureRandom();
		for (int i = 0; i < 10; i++) {
			int idx = random.nextInt(chars.length());
			sb.append(chars.charAt(idx));
		}
		return sb.toString();
	}

	public int matchUserIdPhone(User user) {
		
		user = dao.getUserByIdPhone(user);
		
		if(user.equals(null)) {
			return 0;
		} else {
			return 1;
		}
	}

	public int changePw(User user) {
		int result = dao.changePw(user);
		if(result == 0) {
			return 0;
		} else {
			return 1;
		}
	}

}

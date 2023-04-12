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

}

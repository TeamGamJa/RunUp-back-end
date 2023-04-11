package team.spring.runup.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.spring.runup.user.dao.UserDao;
import team.spring.runup.user.vo.User;

@Service
public class LoginService {
	
	@Autowired
	private UserDao dao;

	public User checkUser(User insertUser) {
		
		User user = dao.getUser(insertUser);
		return user;
	}

}

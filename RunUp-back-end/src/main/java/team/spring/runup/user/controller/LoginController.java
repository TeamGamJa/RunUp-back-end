package team.spring.runup.user.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import team.spring.runup.user.service.LoginService;
import team.spring.runup.user.vo.User;

@RestController
@RequestMapping(value="login",produces="application/json")
@CrossOrigin(origins = "http://localhost:8081", allowedHeaders = "*")
public class LoginController {

	Logger log = LogManager.getLogger("case3");
	
	@Autowired
	private LoginService loginService;
	
	@GetMapping
	public User login(@RequestParam(value="userId", 
			required=false) String userId, @RequestParam(value="userPw", 
			required=false) String userPw) throws JsonProcessingException {
		
		User insertUser = new User();
		insertUser.setUserId(userId);
		insertUser.setUserPw(userPw);
		User user = loginService.getUser(insertUser);
		
		return user;
	}
	
	@GetMapping(value="kakao")
	public User kaKaoLogin (@RequestParam(value="userId", 
			required=false) String userId, @RequestParam(value="userNickname", 
			required=false) String userNickName) throws JsonProcessingException {
		
		User user = loginService.getUserById(userId);
		log.debug(user);
		return user;
	
	}
}

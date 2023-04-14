package team.spring.runup.user.controller;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import team.spring.runup.user.service.UserService;
import team.spring.runup.user.vo.User;

@RestController
@RequestMapping(value="user",produces="application/json")
@CrossOrigin(origins = "http://127.0.0.1:8081", allowedHeaders = "*")
public class UserController {

Logger log = LogManager.getLogger("case3");
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping(value="login")
	public User login(@RequestParam(value="userId", 
			required=false) String userId, @RequestParam(value="userPw", 
			required=false) String userPw) throws JsonProcessingException {
		
		User insertUser = new User();
		insertUser.setUserId(userId);
		insertUser.setUserPw(userPw);
		User user = userService.getUser(insertUser);
		
		return user;
	}
	
	@GetMapping(value="kakao")
	public User kaKaoLogin(@RequestParam(value="userId", 
			required=false) String userId, @RequestParam(value="userNickname", 
			required=false) String userNickName) throws JsonProcessingException {
		
		User user = userService.getUserById(userId);
		return user;
	}
	
	@GetMapping(value="id")
	public int checkExistId(@RequestParam(value="userId", 
			required=false) String userId) throws JsonProcessingException {
	
		int result = 0;
		
		result = userService.checkUserId(userId);
		
		return result;
	}
	
	@PostMapping
	public int registUser(@RequestParam(value="user",
			required=false) JsonParser inputUser) throws IOException {
		
		int result = 0;
		ObjectMapper mapper = new ObjectMapper();
		User user = mapper.readValue(inputUser, User.class);
		
		result = userService.registUser(user);
		
		return result;
	}

	@PutMapping
	public int updateUser(@RequestParam(value="user",
		required=false) JsonParser inputUser) throws IOException {

		int result = 0;
		ObjectMapper mapper = new ObjectMapper();
		User user = mapper.readValue(inputUser, User.class);
		
		result = userService.updateUser(user);
		
		return result;
	}
	
	@DeleteMapping
	public int deleteUser(@RequestParam(value="userId", 
			required=false) String userId) throws JsonProcessingException {
		
		int result = 0;
		result = userService.deleteUser(userId);
		
		return result;
	}
}

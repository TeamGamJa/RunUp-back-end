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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import team.spring.runup.email.service.EmailService;
import team.spring.runup.email.vo.Email;
import team.spring.runup.user.service.UserService;
import team.spring.runup.user.vo.User;

@RestController
@RequestMapping(value="user",produces="application/json")
@CrossOrigin(origins = "http://localhost:8081", allowedHeaders = "*")
public class UserController {

	Logger log = LogManager.getLogger("case3");
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private EmailService emailService;
	
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
	
	@GetMapping(value="nickname")
	public int checkExistNickname(@RequestParam String userNickname) throws JsonProcessingException {
		log.debug(userNickname);
		int result = userService.checkUserNickName(userNickname);
		
		return result;
	}
	
	@PostMapping
	public int registUser(@RequestBody User user) throws IOException {
		
		int result = userService.registUser(user);
		
		return result;
	}

	@PutMapping
	public int updateUser(@RequestBody User user) throws IOException {
		log.debug(user);
//		int result = 0;
//		ObjectMapper mapper = new ObjectMapper();
//		User user = mapper.readValue(inputUser, User.class);
		
		int result = userService.updateUser(user);
		
		return result;
	}
	
	@DeleteMapping
	public int deleteUser(@RequestParam(value="userId", 
			required=false) String userId) throws JsonProcessingException {
		
		int result = 0;
		result = userService.deleteUser(userId);
		
		return result;
	}
	
	@GetMapping(value="password")
	public int findPw(@RequestParam(value="userId", 
			required=false) String userId, @RequestParam(value="userPw", 
			required=false) String userPhone) throws JsonProcessingException {
		
		String newPw = userService.makeNewPw();
		Email email = new Email();
		int result = 0;
		User user = new User();
		
		user.setUserId(userId);
		user.setUserPhone(userPhone);
		result = userService.matchUserIdPhone(user);

		if (result == 1) {
			email.setReceiver(userId);
			email.setTitle(userId + " 님의 비밀번호 찾기 결과");
			email.setContent(userId + "님의 임시 비밀번호는 : " + newPw + "입니다.\n로그인후 비밀번호를 변경해주세요!");
			
			try {
				result = emailService.sendMail(email);
				user.setUserPw(newPw);
				result = userService.changePw(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	@GetMapping(value="user")
	public User getUserInfo(@RequestParam(value="userId", 
			required=false) String userId) {
		
		User user = userService.getUserById(userId);
		
		return user;
	}
	
	@PutMapping(value="ability")
	public int updateCategory(@RequestBody User user) throws IOException {
		log.debug(user);
//		int result = 0;
//		ObjectMapper mapper = new ObjectMapper();
//		User user = mapper.readValue(inputUser, User.class);
		
		int result = userService.updateUserCategory(user);
		
		return result;
	}
	
}

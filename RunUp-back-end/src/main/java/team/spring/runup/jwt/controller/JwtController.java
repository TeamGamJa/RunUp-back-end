package team.spring.runup.jwt.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.util.StringUtils;

import team.spring.runup.jwt.service.JwtServiceImpl;
import team.spring.runup.user.service.UserService;
import team.spring.runup.user.vo.User;

@RestController
//@CrossOrigin("*")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value="jwt",produces="application/json")
public class JwtController {

	Logger log = LogManager.getLogger("case3");
	
	@Autowired
	JwtServiceImpl jwtService;
	
	@Autowired
	UserService userService;
	
	@GetMapping(value="getuser")
	public ResponseEntity<Object> getUser(HttpServletRequest request) {
		try {
			log.debug(request);
			String token = request.getHeader("jwt-auth-token");
			log.debug("1" + token);
			Map<String, Object> tokenInfoMap = jwtService.getInfo(token);
			log.debug("2" + request);
			User user = new ObjectMapper().convertValue(tokenInfoMap.get("user"), User.class);
			log.debug("3" + request);
			return new ResponseEntity<Object>(user, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(null, HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping(value="login")
	public ResponseEntity<Object> login (@RequestParam(value="userId", 
			required=false) String userId, @RequestParam(value="userPw", 
			required=false) String userPw, HttpServletResponse response) {
		
		log.debug(userId + userPw);
		try {
			User insertUser = new User();
			insertUser.setUserId(userId);
			insertUser.setUserPw(userPw);
			User user = userService.getUser(insertUser);
			Map<String, String> map = new HashMap<String, String>();
			
			if (!(StringUtils.isNullOrEmpty(user.getUserId()))) {
				String token = jwtService.createToken(user);
				map.put("token", token);
				map.put("userId", user.getUserId());
				map.put("userNickname", user.getUserNickname());
				map.put("userNum", Integer.toString(user.getUserNum()));
				map.put("userUrl", user.getUserUrl());
				map.put("userPoint", Integer.toString(user.getUserPoint()));
				map.put("userLuxColor", user.getUserLuxColor());
				map.put("userColor", Integer.toString(user.getUserColor()));
				response.setHeader("jwt-auth-token", token);
				return new ResponseEntity<Object>(map, HttpStatus.OK);
			} else
				return new ResponseEntity<Object>("login Fail", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(null, HttpStatus.CONFLICT);
		}
	}
	
}

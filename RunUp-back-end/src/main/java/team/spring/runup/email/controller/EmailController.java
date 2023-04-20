package team.spring.runup.email.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import team.spring.runup.email.service.EmailService;
import team.spring.runup.email.vo.Email;

@Controller
@RequestMapping(value="mail")
public class EmailController {
	
//	Logger log = LogManager.getLogger("case3");
//	
//	@Autowired
//	protected EmailService service;
//	
//	@GetMapping
//	public String sendMail(@RequestParam(value="userId", 
//			required=false) String userId) throws Exception {
//		
//		Email email = new Email();
//		
//		log.debug(userId);
//		email.setReceiver(userId);
//		email.setTitle("test");
//		email.setContent("test");
//		
//		boolean result = service.sendMail(email);
//		
//		return null;
//	}

}

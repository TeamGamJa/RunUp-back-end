package team.spring.runup.message.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import team.spring.runup.message.service.MessageService;
import team.spring.runup.message.vo.Message;

@RestController
@RequestMapping(value="message", produces="application/json")
@CrossOrigin(origins = "http://localhost:8081", allowedHeaders = "*")
public class MessageController {

	// 로그 추가
	Logger log = LogManager.getLogger("case3");

	
	@Autowired
	private MessageService service;

	
	// 쪽지 전송(생성)
	@PostMapping(value="send", produces = "application/json; charset=UTF-8")
	public int sendMessage(@RequestBody Message message) {
		log.debug("test");
		
		log.debug("sendMessage ����={}", message);
		
		int result = service.sendMessage(message);
		
		if (result ==1) {
			log.debug("쪽지 생성 성공");
		} else {
			log.debug("이상이 있어요");
		}
		log.debug("결과={}", result);
		
		return result;
	}

	
	// 쪽지 삭제
	@PostMapping
	public ResponseEntity<String> deleteMessage(String messageId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	// 받은 쪽지함
	@GetMapping(value="message/inbox/{messageReceiver}")
	public List<String> receiveMessageList(String messageReceiver) {
		// TODO Auto-generated method stub
		return null;
	}

	
	// 보낸 쪽지함
	@GetMapping(value="message/sentbox/{messageSender}")
	public List<String> sendMessageList(String messageSender) {
		// TODO Auto-generated method stub
		return null;
	}

	
	// 받은 쪽지 상세
	@GetMapping(value="message/inbox/{messageId}")
	public Message receiveMessageDetail(String messageId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	// 보낸 쪽지 상세
	@GetMapping(value="message/sentbox/{messageId}")
	public Message sendMessageDetail(String messageId) {
		// TODO Auto-generated method stub
		return null;
	}

}

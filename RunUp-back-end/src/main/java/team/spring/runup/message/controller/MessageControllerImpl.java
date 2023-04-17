package team.spring.runup.message.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import team.spring.runup.message.service.MessageServiceImpl;
import team.spring.runup.message.vo.Message;

@RestController
@RequestMapping(value="message", produces="application/json")
@CrossOrigin(origins = "http://localhost:8081", allowedHeaders = "*")
public class MessageControllerImpl implements MessageController {

	Logger log = LogManager.getLogger("case3");
	
	@Autowired
	private MessageServiceImpl service;
	
	
	// 쪽지 전송
	@Override
	@PostMapping(produces = "application/json; charset=UTF-8")
	public ResponseEntity<String> sendMessage(Message message) {
		// TODO Auto-generated method stub
		int i = 0;
		return null;
	}

	
	// 쪽지 삭제
	@Override
	@PostMapping
	public ResponseEntity<String> deleteMessage(String messageId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	// 받은 쪽지함
	@Override
	@GetMapping(value="message/inbox/{messageReceiver}")
	public List<String> receiveMessageList(String messageReceiver) {
		// TODO Auto-generated method stub
		return null;
	}

	
	// 보낸 쪽지함
	@Override
	@GetMapping(value="message/sentbox/{messageSender}")
	public List<String> sendMessageList(String messageSender) {
		// TODO Auto-generated method stub
		return null;
	}

	
	// 받은 쪽지 상세
	@Override
	@GetMapping(value="message/inbox/{messageId}")
	public Message receiveMessageDetail(String messageId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	// 보낸 쪽지 상세
	@Override
	@GetMapping(value="message/sentbox/{messageId}")
	public Message sendMessageDetail(String messageId) {
		// TODO Auto-generated method stub
		return null;
	}

}

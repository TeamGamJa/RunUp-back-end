package team.spring.runup.message.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import team.spring.runup.message.service.MessageService;
import team.spring.runup.message.vo.Message;

@RestController
@RequestMapping(value="message", produces="application/json; charset=UTF-8")
@CrossOrigin(origins = "http://localhost:8081", allowedHeaders = "*")
public class MessageController {

	// 로그 추가
	Logger log = LogManager.getLogger("case3");

	
	@Autowired
	private MessageService service;

	
	// 쪽지 전송(생성)
	@PostMapping
	public int sendMessage(@RequestBody Message message) throws Exception {
	
		log.debug("sendMessage 실행 = {}", message);
		
		int result = service.sendMessage(message);
		
		if (result ==1) {
			log.debug("쪽지 생성 성공");
		} else {
			log.debug("이상이 있어요");
		}
		
		log.debug("결과 = {}", result);
		
		return result;
	}

	
	// 받은 쪽지함
	@GetMapping(value="inbox")
	public List<Message> receiveMessageList(@RequestParam(value="receiverNum", required=false) int receiverNum) throws Exception {
		
		log.debug("receiverNum 조회 = {}", receiverNum);
		
		List<Message> result = service.inboxList(receiverNum);
		
		log.debug("결과 = {}", result);
		
		return result;
	}

	
	// 보낸 쪽지함
	@GetMapping(value="sentbox")
	public List<Message> sendMessageList(@RequestParam(value="senderNum", required=false) int senderNum) throws Exception {
		log.debug("senderNum 조회 = {}", senderNum);
		
		List<Message> result = service.sentboxList(senderNum);
		
		log.debug("결과 = {}", result);
		
		return result;
	}

	
	// 쪽지 상세
	@GetMapping(value="content")
	public Message openMessage(int messageNum) throws Exception {
		log.debug("messageNum 조회 = {}", messageNum);
		
		Message result = service.openMessage(messageNum);
		
		log.debug("결과 = {}", result);
		
		return result;
	}
	
	
	// 쪽지 (휴지통에)버리기
	@PostMapping(value="trash")
	public int trashMessage(@RequestBody Message messageNum) throws Exception {
		log.debug("messageNum 조회 = {}", messageNum);
		
		int result = service.trashMessage(messageNum.getMessageNum());
		
		if (result ==1) {
			log.debug("쪽지 휴지통 성공");
		} else {
			log.debug("이상이 있어요");
		}
		
		log.debug("결과 = {}", result);
		
		return result;
	}
	
	
	// 쪽지 휴지통
	@GetMapping(value="trashcan")
	public List<Message> trashMesssageList(@RequestParam(value="userNum", required=false) int userNum) throws Exception {
		log.debug("userNum 조회 = {}", userNum);
		
		List<Message> result = service.trashcanList(userNum);
		
		log.debug("결과 = {}", result);
		
		return result;
	}
	

	// 쪽지 삭제
	@DeleteMapping(produces="application/json; charset=UTF-8")
	public int deleteMessage(int messageNum) throws Exception {
		log.debug("messageNum 조회 = {}", messageNum);
		
		int result = service.deleteMessage(messageNum);
		
		if (result ==1) {
			log.debug("쪽지 삭제 성공");
		} else {
			log.debug("이상이 있어요");
		}
		
		log.debug("결과 = {}", result);
		
		return result;
	}

}

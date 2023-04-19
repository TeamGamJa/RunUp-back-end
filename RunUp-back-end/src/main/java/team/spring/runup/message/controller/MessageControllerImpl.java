package team.spring.runup.message.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import team.spring.runup.message.service.MessageServiceImpl;
import team.spring.runup.message.vo.Message;

@RestController
@RequestMapping(value="message", produces="application/json")
@CrossOrigin(origins = "http://localhost:8081", allowedHeaders = "*")
public class MessageControllerImpl implements MessageController {

	// �α� �߰�
	Logger log = LogManager.getLogger("case3");
	
//	@Autowired
//	private Gson gson;
	
	@Autowired
	private MessageServiceImpl service;
	
	
	// ���� ���(��)
	@Override
	@PostMapping(value="send", produces = "application/json; charset=UTF-8")
	public int sendMessage(@RequestBody Message message) {
		log.debug("test");
		
		log.debug("sendMessage ����={}", message);
		
		int result = service.sendMessage(message);
		
		if (result ==1) {
			log.debug("���� �� ����");
		} else {
			log.debug("�̻��� �־��");
		}
		log.debug("���={}", result);
		
//		String jsonResult = gson.toJson("���� �� �Ϸ�");
		
//		return new ResponseEntity<String>(jsonResult, HttpStatus.OK);
		return result;
	}

	
	// ���� ���
	@Override
	@PostMapping
	public ResponseEntity<String> deleteMessage(String messageId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	// ��� ������
	@Override
	@GetMapping(value="message/inbox/{messageReceiver}")
	public List<String> receiveMessageList(String messageReceiver) {
		// TODO Auto-generated method stub
		return null;
	}

	
	// ���� ������
	@Override
	@GetMapping(value="message/sentbox/{messageSender}")
	public List<String> sendMessageList(String messageSender) {
		// TODO Auto-generated method stub
		return null;
	}

	
	// ��� ���� ��
	@Override
	@GetMapping(value="message/inbox/{messageId}")
	public Message receiveMessageDetail(String messageId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	// ���� ���� ��
	@Override
	@GetMapping(value="message/sentbox/{messageId}")
	public Message sendMessageDetail(String messageId) {
		// TODO Auto-generated method stub
		return null;
	}

}

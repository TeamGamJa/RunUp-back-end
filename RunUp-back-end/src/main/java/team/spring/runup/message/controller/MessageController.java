package team.spring.runup.message.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import team.spring.runup.message.vo.Message;

public interface MessageController {

	// 쪽지 전송
	int sendMessage(Message message);
	
	// 쪽지 삭제
	ResponseEntity<String> deleteMessage(String messageId) throws Exception;
	
	// 받은 쪽지함
	List<String> receiveMessageList(String messageReceiver);
	
	// 보낸 쪽지함
	List<String> sendMessageList(String messageSender);
	
	// 받은 쪽지 상세
	Message receiveMessageDetail(String messageId);
	
	// 보낸 쪽지 상세
	Message sendMessageDetail(String messageId);
	
	// 쪽지 차단
	
	
}

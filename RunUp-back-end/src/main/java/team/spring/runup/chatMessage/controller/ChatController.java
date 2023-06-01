package team.spring.runup.chatMessage.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import team.spring.runup.chatMessage.service.ChatService;
import team.spring.runup.chatMessage.vo.ChatMessage;

@RestController
@RequestMapping(value="chat",produces="application/json")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ChatController {

	Logger log = LogManager.getLogger("case3");
	
	@Autowired
	private ChatService service;
	
	@MessageMapping("chat/{roomId}/sendMessage")
    @SendTo("/topic/{roomId}")
    public ChatMessage sendMessage(@DestinationVariable String roomId, @Payload ChatMessage chatMessage) {
		int result = service.updateChat(chatMessage);
        return chatMessage;
    }
	
	@PostMapping
	public ResponseEntity<Integer> makeChatRoomDb(@RequestBody ChatMessage chatMessage) {
		
		log.debug(chatMessage);
		int result = service.insertChat(chatMessage);
		log.debug("test" + result);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping
	public ChatMessage checkRoomExist(@RequestParam(value="chatRoomId", 
					required=false) String chatRoomId) {
		log.debug(chatRoomId);
		ChatMessage chat = service.checkRoom(chatRoomId);
		log.debug(chat);
		return chat;
	}
	
}

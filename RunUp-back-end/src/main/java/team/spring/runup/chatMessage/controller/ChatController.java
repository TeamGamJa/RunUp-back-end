package team.spring.runup.chatMessage.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import team.spring.runup.chatMessage.vo.ChatMessage;

@RestController
public class ChatController {

	Logger log = LogManager.getLogger("case3");
	
	@MessageMapping("chat/{roomId}/sendMessage")
    @SendTo("/topic/{roomId}")
    public ChatMessage sendMessage(@DestinationVariable String roomId, @Payload ChatMessage chatMessage) {
		log.debug(chatMessage);
		log.debug(roomId);
        return chatMessage;
    }
}

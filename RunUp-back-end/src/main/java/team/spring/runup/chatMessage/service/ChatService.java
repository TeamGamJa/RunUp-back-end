package team.spring.runup.chatMessage.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.spring.runup.chatMessage.dao.ChatDao;
import team.spring.runup.chatMessage.vo.ChatMessage;

@Service
public class ChatService {

	Logger log = LogManager.getLogger("case3");
	
	@Autowired
	private ChatDao dao;
	
	public int updateChat(ChatMessage chatMessage) {
		
		int result = dao.updateChat(chatMessage);
		log.debug("저장결과 " + result);
		return result;
	}

	public int insertChat(ChatMessage chatMessage) {
		int result = dao.insertChat(chatMessage);
		log.debug(result);
		return result;
	}

	public ChatMessage checkRoom(String chatRoomId) {
		log.debug(chatRoomId);
		ChatMessage chat = dao.checkRoom(chatRoomId);
		log.debug(chat);
		return chat;
	}

}

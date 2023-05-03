package team.spring.runup.chatMessage.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import team.spring.runup.chatMessage.vo.ChatMessage;

@Repository
public class ChatDaoImpl implements ChatDao{

	Logger log = LogManager.getLogger("case3");
	
	@Autowired
	private SqlSession session;
	
	@Override
	public int updateChat(ChatMessage chatMessage) {
		
		int result = session.update("chat.updateChat", chatMessage);
		return result;
	}
	
	@Override
	public int insertChat(ChatMessage chatMessage) {
		int result = session.insert("chat.insertChat", chatMessage);
		return result;
	}

	@Override
	public ChatMessage checkRoom(String chatRoomId) {
		ChatMessage chat = session.selectOne("chat.getRoomInfo", chatRoomId);
		log.debug(chat);
		return chat;
	}

}

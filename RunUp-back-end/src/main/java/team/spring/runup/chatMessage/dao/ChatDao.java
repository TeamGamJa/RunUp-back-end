package team.spring.runup.chatMessage.dao;

import team.spring.runup.chatMessage.vo.ChatMessage;

public interface ChatDao {

	int updateChat(ChatMessage chatMessage);

	int insertChat(ChatMessage chatMessage);

	ChatMessage checkRoom(String chatRoomId);

}

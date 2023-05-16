package team.spring.runup.message.dao;

import java.util.List;

import team.spring.runup.message.vo.Message;

public interface MessageDao {

	// 쪽지 보내기(생성)
	int sendMessage(Message message) throws Exception;
	
	// 받은 쪽지함
	List<Message> inboxList(int receiverNum) throws Exception;
	
	// 보낸 쪽지함
	List<Message> sentboxList(int senderNum) throws Exception;
	
	// 쪽지 상세
	Message openMessage(int messageNum) throws Exception;
	
	// 쪽지 (휴지통에)버리기
	int trashMessage(int messageNum) throws Exception;
	
	// 쪽지 휴지통
	List<Message> trashcanList(int userNum) throws Exception;
	
	// 쪽지 삭제
	int deleteMessage(int messageNum) throws Exception;
	
	// 쪽지 열람여부 확인
	int checkMessage(int messageNum);
	
}

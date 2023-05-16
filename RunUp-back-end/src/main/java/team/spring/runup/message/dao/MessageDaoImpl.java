package team.spring.runup.message.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import team.spring.runup.message.vo.Message;

@Repository
public class MessageDaoImpl implements MessageDao {
	
	Logger log = LogManager.getLogger("case3");
	
	@Autowired
	private SqlSession session;

	// 쪽지 보내기(생성)
	public int sendMessage(Message message) throws Exception {
		return session.insert("message.sendMessage", message);
	}

	// 받은 쪽지함
	public List<Message> inboxList(int receiverNum) throws Exception {
		List<Message> message = session.selectList("message.inboxList", receiverNum);
		return message;
	}

	// 보낸 쪽지함
	public List<Message> sentboxList(int senderNum) throws Exception {
		List<Message> message = session.selectList("message.sentboxList", senderNum);
		return message;
	}

	// 쪽지 상세
	public Message openMessage(int messageNum) throws Exception {
		return session.selectOne("message.openMessage", messageNum);
	}

	// 쪽지 (휴지통에)버리기
	public int trashMessage(int messageNum) throws Exception {
		return session.update("message.trashMessage", messageNum);
	}

	// 쪽지 휴지통
	public List<Message> trashcanList(int userNum) throws Exception {
		List<Message> message = session.selectList("message.trashcanList", userNum);
		return message;
	}

	// 쪽지 삭제
	public int deleteMessage(int messageNum) throws Exception {
		return session.delete("message.deleteMessage", messageNum);
	}

	// 쪽지 열람여부 확인
	public int checkMessage(int messageNum) {
		return session.update("message.checkMessage", messageNum);
		
	}
	
	

}

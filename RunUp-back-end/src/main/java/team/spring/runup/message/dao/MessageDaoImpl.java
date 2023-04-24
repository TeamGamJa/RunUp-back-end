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
	public List<Message> inboxList(int receiverNum) {
		List<Message> message = session.selectList("message.inboxList", receiverNum);
		return message;
	}

	public List<Message> sentboxList(int senderNum) {
		List<Message> message = session.selectList("message.sentboxList", senderNum);
		return message;
	}
	
	

}

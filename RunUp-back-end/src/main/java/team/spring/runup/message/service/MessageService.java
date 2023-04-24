package team.spring.runup.message.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import team.spring.runup.message.dao.MessageDaoImpl;
import team.spring.runup.message.vo.Message;

@Service
@Transactional
public class MessageService {

	// 로그 추가
	Logger log = LogManager.getLogger("case3");
	
	@Autowired
	MessageDaoImpl dao;
	
	
	// 쪽지 전송(생성)
	public int sendMessage(Message message) {
		int result = 0;

		try {
			result = dao.sendMessage(message);
			if (result == 1) {
				log.debug("service => 잘실행되었어요");
			} else {
				throw new Exception("error");
			}
		} catch (Exception e) {
			log.debug("service => 뭔가 이상해요 사유={}", e);
			throw new RuntimeException("쪽지 생성 중 오류가 발생하였습니다.", e);
		}
		return result;
	}

	// 받은 쪽지함
	public List<Message> inboxList(int receiverNum) {
		List<Message> result = null;
		
		try {
			result = dao.inboxList(receiverNum);
			log.debug("service => 잘실행되었어요");
		} catch (Exception e) {
			log.debug("service => 이상해요 사유={}", e);
			throw new RuntimeException("받은 쪽지 목록 조회 중 오류가 발생하였습니다.", e);
		}
		return result;
	}

	public List<Message> sentboxList(int senderNum) {
		List<Message> result = null;
		
		try {
			result = dao.sentboxList(senderNum);
			log.debug("service => 잘실행되었어요");
		} catch (Exception e) {
			log.debug("service => 이상해요 사유={}", e);
			throw new RuntimeException("보낸 쪽지 목록 조회 중 오류가 발생하였습니다.", e);
		}
		return result;
	}

}


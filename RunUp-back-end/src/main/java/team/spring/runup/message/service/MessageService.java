package team.spring.runup.message.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
			log.debug("service => 뭔가 이상해요 사유 = {}", e);
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
			log.debug("service => 이상해요 사유 = {}", e);
			throw new RuntimeException("받은 쪽지 목록 조회 중 오류가 발생하였습니다.", e);
		}
		return result;
	}

	// 보낸 쪽지함
	public List<Message> sentboxList(int senderNum) {
		List<Message> result = null;
		
		try {
			result = dao.sentboxList(senderNum);
			log.debug("service => 잘실행되었어요");
		} catch (Exception e) {
			log.debug("service => 이상해요 사유 = {}", e);
			throw new RuntimeException("보낸 쪽지 목록 조회 중 오류가 발생하였습니다.", e);
		}
		return result;
	}

	// 쪽지 상세
	public Message openMessage(int messageNum) {
		Message result = null;
		
		try {
			result = dao.openMessage(messageNum); 
			log.debug("service => 잘실행되었어요");
			dao.checkMessage(messageNum);
			log.debug("service => 열람여부 잘실행되었어요");
		} catch (Exception e) {
			log.debug("service => 이상해요 사유 = {}", e);
			throw new RuntimeException("쪽지 상세 조회 중 오류가 발생하였습니다.", e);
		}
		return result;
	}

	// 쪽지 (휴지통에)버리기
	public int trashMessage(int messageNum) {
		int result = 0;
		
		try {
			result = dao.trashMessage(messageNum);
			if (result == 1) {
				log.debug("service => 잘실행되었어요");
			} else {
				throw new Exception("error");
			}
		} catch (Exception e) {
			log.debug("service => 뭔가 이상해요 사유 = {}", e);
			throw new RuntimeException("쪽지를 휴지통에 넣는 중 오류가 발생하였습니다.", e);
		}
		return result;
	}

	// 쪽지 휴지통
	public List<Message> trashcanList(int userNum) {
		List<Message> result = null;
		
		try {
			result = dao.trashcanList(userNum);
			log.debug("service => 잘실행되었어요");
		} catch (Exception e) {
			log.debug("service => 이상해요 사유 = {}", e);
			throw new RuntimeException("쪽지 휴지통 목록 조회 중 오류가 발생하였습니다.", e);
		}
		return result;
		
	}

	// 쪽지 삭제
	public int deleteMessage(int messageNum) {
		int result = 0;

		try {
			result = dao.deleteMessage(messageNum);
			if (result == 1) {
				log.debug("service => 잘실행되었어요");
			} else {
				throw new Exception("error");
			}
		} catch (Exception e) {
			log.debug("service => 뭔가 이상해요 사유 = {}", e);
			throw new RuntimeException("쪽지 삭제 중 오류가 발생하였습니다.", e);
		}
		return result;
	}

}


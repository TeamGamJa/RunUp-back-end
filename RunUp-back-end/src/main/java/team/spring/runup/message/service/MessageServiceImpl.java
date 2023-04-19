package team.spring.runup.message.service;

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
public class MessageServiceImpl implements MessageService {

	// 로그 추가
	Logger log = LogManager.getLogger("case3");
	
	@Autowired
	MessageDaoImpl dao;
	
//	private final PlatformTransactionManager transactionManager;
	
	
//	public MessageServiceImpl(PlatformTransactionManager transactionManager) {
//		this.transactionManager = transactionManager;
//	}
	
	// 쪽지 전송(생성)
	public int sendMessage(Message message) {
		int result = 0;
//			TransactionStatus txStatus =
//					transactionManager.getTransaction(new DefaultTransactionDefinition());
		try {
			result = dao.create(message);
			if (result == 1) {
//				transactionManager.commit(txStatus);
				log.debug("service => 잘실행되었어요");
			} else {
				throw new Exception("error");
			}
		} catch (Exception e) {
//			transactionManager.rollback(txStatus);
			log.debug("service => 뭔가 이상해요 사유={}", e);
			throw new RuntimeException("쪽지 생성 중 오류가 발생했습니다.", e);
		}
		return result;
	}

}

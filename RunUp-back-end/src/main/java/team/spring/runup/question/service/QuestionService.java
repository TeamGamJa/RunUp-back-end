package team.spring.runup.question.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team.spring.runup.question.dao.QuestionDaoImpl;
import team.spring.runup.question.vo.Question;


@Service
@Transactional
public class QuestionService {
	
	// 로그 추가
		Logger log = LogManager.getLogger("case3");

	@Autowired
	QuestionDaoImpl dao;
	
	// 상단바 검색 - 고민상담 게시판 결과
	public List<Question> getQuestionByKeyword(String keyword) {
		List<Question> list = dao.getQuestionByKeyword(keyword);
		return list;
	}

	// 고민상담 글 작성(생성)
	public int createQuestion(Question question) {
		int result = 0;

		try {
			result = dao.createQuestion(question);
			if (result == 1) {
				log.debug("service => 잘실행되었어요");
			} else {
				throw new Exception("error");
			}
		} catch (Exception e) {
			log.debug("service => 뭔가 이상해요 사유 = {}", e);
			throw new RuntimeException("고민 글 생성 중 오류가 발생하였습니다.", e);
		}
		return result;
	}
	
}

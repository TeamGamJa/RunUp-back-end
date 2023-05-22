package team.spring.runup.question.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team.spring.runup.question.dao.QuestionDaoImpl;
import team.spring.runup.question.vo.Question;
import team.spring.runup.question.vo.QuestionComment;
import team.spring.runup.question.vo.QuestionLike;


@Service
@Transactional
public class QuestionService {
	
	// 로그 추가
		Logger log = LogManager.getLogger("case3");

	@Autowired
	QuestionDaoImpl dao;
	
	// 상단바 검색 - 묻고답하기 게시판 결과
	public List<Question> getQuestionByKeyword(String keyword) {
		List<Question> list = dao.getQuestionByKeyword(keyword);
		return list;
	}

	// 묻고답하기 글 작성(생성)
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

	// 묻고답하기 글 전체 목록 
	public List<Question> searchAllQuestion() {
		List<Question> result = null;
			
		try {
			result = dao.searchAllQuestion();
			log.debug("service => 잘실행되었어요");
		} catch (Exception e) {
			log.debug("service => 이상해요 사유 = {}", e);
			throw new RuntimeException("고민상담 글 목록 전체 조회 중 오류가 발생하였습니다.", e);
		}
			return result;
		}
	
	// 도움요청 글 전체 목록
	public List<Question> searchRequest(int questionChoice) {
		List<Question> result = null;
		
		try {
			result = dao.searchRequest(questionChoice);
			log.debug("service => 잘실행되었어요");
		} catch (Exception e) {
			log.debug("service => 이상해요 사유 = {}", e);
			throw new RuntimeException("도움요청 글 목록 전체 조회 중 오류가 발생하였습니다.", e);
		}
			return result;
		}
	
	// 고민상담 글 전체 목록
	public List<Question> searchCounsel(int questionChoice) {
		List<Question> result = null;
		
		try {
			result = dao.searchCounsel(questionChoice);
			log.debug("service => 잘실행되었어요");
		} catch (Exception e) {
			log.debug("service => 이상해요 사유 = {}", e);
			throw new RuntimeException("도움요청 글 목록 전체 조회 중 오류가 발생하였습니다.", e);
		}
			return result;
		}
		
	// 묻고답하기 글 상세
	public Question openQuestion(int questionNum) {
		Question result = null;
		
		try {
			result = dao.openQuestion(questionNum); 
			log.debug("service => 잘실행되었어요");
		} catch (Exception e) {
			log.debug("service => 이상해요 사유 = {}", e);
			throw new RuntimeException("고민 글 상세 조회 중 오류가 발생하였습니다.", e);
		}
		return result;
	}

	// 묻고답하기 글 수정
	public int updateQuestion(Question question) {
		int result = 0;

		try {
			result = dao.updateQuestion(question);
			if (result == 1) {
				log.debug("service => 잘실행되었어요");
			} else {
				throw new Exception("error");
			}
		} catch (Exception e) {
			log.debug("service => 뭔가 이상해요 사유 = {}", e);
			throw new RuntimeException("고민 글 수정 중 오류가 발생하였습니다.", e);
		}
		return result;
	}

	// 묻고답하기 글 삭제
	public int deleteQuestion(int questionNum) {
		int result = 0;

		try {
			result = dao.deleteMessage(questionNum);
			if (result == 1) {
				log.debug("service => 잘실행되었어요");
			} else {
				throw new Exception("error");
			}
		} catch (Exception e) {
			log.debug("service => 뭔가 이상해요 사유 = {}", e);
			throw new RuntimeException("고민 글 삭제 중 오류가 발생하였습니다.", e);
		}
		return result;
	}

	// 댓글 작성(생성)
	public int createQuestionComment(QuestionComment questioncomment) {
		int result = 0;

		try {
			result = dao.createQuestionComment(questioncomment);
			if (result == 1) {
				log.debug("service => 잘실행되었어요");
			} else {
				throw new Exception("error");
			}
		} catch (Exception e) {
			log.debug("service => 뭔가 이상해요 사유 = {}", e);
			throw new RuntimeException("고민상담 댓글 생성 중 오류가 발생하였습니다.", e);
		}
		return result;
	}

	// 댓글 수정
	public int updateQuestionComment(QuestionComment questioncomment) {
		int result = 0;

		try {
			result = dao.updateQuestionComment(questioncomment);
			if (result == 1) {
				log.debug("service => 잘실행되었어요");
			} else {
				throw new Exception("error");
			}
		} catch (Exception e) {
			log.debug("service => 뭔가 이상해요 사유 = {}", e);
			throw new RuntimeException("고민상담 댓글 수정 중 오류가 발생하였습니다.", e);
		}
		return result;
	}

	// 댓글 삭제
	public int deleteQuestionComment(int qCommentNum) {
		int result = 0;

		try {
			result = dao.deleteQuestionComment(qCommentNum);
			if (result == 1) {
				log.debug("service => 잘실행되었어요");
			} else {
				throw new Exception("error");
			}
		} catch (Exception e) {
			log.debug("service => 뭔가 이상해요 사유 = {}", e);
			throw new RuntimeException("고민상담 댓글 삭제 중 오류가 발생하였습니다.", e);
		}
		return result;
	}
	
	// 댓글 목록 가져오기
	public List<QuestionComment> searchQuestionComment(int questionNum) {
		List<QuestionComment> result = null;
		
		try {
			result = dao.searchQuestionComment(questionNum);
			log.debug("service => 잘실행되었어요");
		} catch (Exception e) {
			log.debug("service => 이상해요 사유 = {}", e);
			throw new RuntimeException("댓글 목록 전체 조회 중 오류가 발생하였습니다.", e);
		}
			return result;
	}
	
	// 댓글 하나 가져오기
		public QuestionComment searchOneQuestionComment(int qCommentNum) {
			QuestionComment result = null;
			
			try {
				result = dao.searchOneQuestionComment(qCommentNum); 
				log.debug("service => 잘실행되었어요");
			} catch (Exception e) {
				log.debug("service => 이상해요 사유 = {}", e);
				throw new RuntimeException("댓글 1개 조회 중 오류가 발생하였습니다.", e);
			}
			return result;
		}

	// 묻고답하기 공감 삭제
	public int deleteQuestionLike(QuestionLike questionlike) {
		int result = 0;

		try {
			result = dao.deleteQuestionLike(questionlike);
			if (result == 1) {
				log.debug("service => 잘실행되었어요");
			} else {
				log.debug("service => 삭제할게 없음");
			}
		} catch (Exception e) {
			log.debug("service => 뭔가 이상해요 사유 = {}", e);
			throw new RuntimeException("고민상담 공감 삭제 중 오류가 발생하였습니다.", e);
		}
		return result;
	}

	// 묻고답하기 공감 생성
	public int createQuestionLike(QuestionLike questionlike) {
		int result = 0;

		try {
			result = dao.createQuestionLike(questionlike);
			if (result == 1) {
				log.debug("service => 잘실행되었어요");
			} else {
				throw new Exception("error");
			}
		} catch (Exception e) {
			log.debug("service => 뭔가 이상해요 사유 = {}", e);
			throw new RuntimeException("고민상담 공감 생성 중 오류가 발생하였습니다.", e);
		}
		return result;
		
	}

	// 묻고답하기 공감 1 감소
	public int decreaseLike(QuestionLike questionlike) {
		int result = 0;

		try {
			result = dao.decreaseLike(questionlike);
			if (result == 1) {
				log.debug("service => 잘실행되었어요");
			} else {
				throw new Exception("error");
			}
		} catch (Exception e) {
			log.debug("service => 뭔가 이상해요 사유 = {}", e);
			throw new RuntimeException("공감 1 감소 중 오류가 발생하였습니다.", e);
		}
		return result;
		
	}

	// 묻고답하기 공감 1 증가
	public int increaseLike(QuestionLike questionlike) {
		int result = 0;

		try {
			result = dao.increaseLike(questionlike);
			if (result == 1) {
				log.debug("service => 잘실행되었어요");
			} else {
				throw new Exception("error");
			}
		} catch (Exception e) {
			log.debug("service => 뭔가 이상해요 사유 = {}", e);
			throw new RuntimeException("공감 1 증가 중 오류가 발생하였습니다.", e);
		}
		return result;
		
	}

	// 묻고답하기 공감 수 가져오기
	public int searchQuestionLike(int questionNum) {
		int result = 0;

		try {
			result = dao.searchQuestionLike(questionNum);
			
		} catch (Exception e) {
			log.debug("service => 뭔가 이상해요 사유 = {}", e);
			throw new RuntimeException("공감 수 가져오는 중 오류가 발생하였습니다.", e);
		}
		return result;
	}

	

	

	
	
}

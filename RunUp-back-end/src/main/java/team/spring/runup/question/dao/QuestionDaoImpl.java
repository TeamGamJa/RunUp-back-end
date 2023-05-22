package team.spring.runup.question.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import team.spring.runup.question.vo.Question;
import team.spring.runup.question.vo.QuestionComment;
import team.spring.runup.question.vo.QuestionLike;

@Repository
public class QuestionDaoImpl implements QuestionDao {
	
	@Autowired
	private SqlSession session;
	
	Logger log = LogManager.getLogger("case3");
	
	// 상단바 검색 - 고민상담 게시판 결과
	@Override
	public List<Question> getQuestionByKeyword(String keyword) {
		List<Question> list = session.selectList("question.getQuestionByKeyword",keyword);
		return list;
	}
	
	// 묻고답하기 글 작성(생성)
	@Override
	public int createQuestion(Question question) throws Exception {
		return session.insert("question.createQuestion", question);
	}

	// 묻고답하기 글 전체 목록 
	@Override
	public List<Question> searchAllQuestion() {
		List<Question> question = session.selectList("question.searchAllQuestion");
		return question;
	}
	
	// 도움요청 글 전체 목록
	public List<Question> searchRequest(int questionChoice) {
		List<Question> question = session.selectList("question.searchRequest", questionChoice);
		return question;
	}
	
	// 고민상담 글 전체 목록
	public List<Question> searchCounsel(int questionChoice) {
		List<Question> question = session.selectList("question.searchCounsel", questionChoice);
		return question;
	}
	
	// 묻고답하기 글 상세
	@Override
	public Question openQuestion(int questionNum) {
		return session.selectOne("question.openQuestion", questionNum);
	}

	// 묻고답하기 글 수정
	@Override
	public int updateQuestion(Question question) {
		return session.update("question.updateQuestion", question);
	}

	// 묻고답하기 글 삭제
	@Override
	public int deleteMessage(int questionNum) {
		return session.delete("question.deleteQuestion", questionNum);
	}

	// 댓글 작성(생성)
	@Override
	public int createQuestionComment(QuestionComment questioncomment) {
		return session.insert("question.createQuestionComment", questioncomment);
	}

	// 댓글 수정
	@Override
	public int updateQuestionComment(QuestionComment questioncomment) {
		return session.update("question.updateQuestionComment", questioncomment);
	}

	// 댓글 삭제
	@Override
	public int deleteQuestionComment(int qCommentNum) {
		return session.delete("question.deleteQuestionComment", qCommentNum);
	}
	
	// 댓글 목록 가져오기
	public List<QuestionComment> searchQuestionComment(int questionNum) {
		List<QuestionComment> questionComment = session.selectList("question.searchQuestionComment", questionNum);
		return questionComment;
	}
	
	// 댓글 하나 가져오기
	public QuestionComment searchOneQuestionComment(int qCommentNum) {
		return session.selectOne("question.searchOneQuestionComment", qCommentNum);
	}

	// 묻고답하기 공감 삭제
	@Override
	public int deleteQuestionLike(QuestionLike questionlike) {
		return session.delete("question.deleteQuestionLike", questionlike);
	}

	// 묻고답하기 공감 생성
	@Override
	public int createQuestionLike(QuestionLike questionlike) {
		return session.insert("question.createQuestionLike", questionlike);
	}

	// 묻고답하기 공감 1 감소
	@Override
	public int decreaseLike(QuestionLike questionlike) {
		return session.update("question.decreaseLike", questionlike);
	}

	// 묻고답하기 공감 1 증가
	@Override
	public int increaseLike(QuestionLike questionlike) {
		return session.update("question.increaseLike", questionlike);
	}

	// 묻고답하기 공감 수 가져오기
	public int searchQuestionLike(int questionNum) {
		return session.selectOne("question.searchQuestionLike", questionNum);
	}

	

	

}

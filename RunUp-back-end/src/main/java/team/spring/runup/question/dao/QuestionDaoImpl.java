package team.spring.runup.question.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import team.spring.runup.question.vo.Question;
import team.spring.runup.question.vo.QuestionComment;

@Repository
public class QuestionDaoImpl implements QuestionDao {
	
	@Autowired
	private SqlSession session;
	
	// 상단바 검색 - 고민상담 게시판 결과
	@Override
	public List<Question> getQuestionByKeyword(String keyword) {
		List<Question> list = session.selectList("question.getQuestionByKeyword",keyword);
		return list;
	}
	
	// 고민상담 글 작성(생성)
	@Override
	public int createQuestion(Question question) throws Exception {
		return session.insert("question.createQuestion", question);
	}

	// 고민상담 글 전체 목록 
	@Override
	public List<Question> searchAllQuestion(int questionChoice) {
		List<Question> question = session.selectList("question.searchAllQuestion", questionChoice);
		return question;
	}
	
	// 고민상담 글 상세
	@Override
	public Question openQuestion(int questionNum) {
		return session.selectOne("question.openQuestion", questionNum);
	}

	// 고민상담 글 수정
	@Override
	public int updateQuestion(Question question) {
		return session.update("question.updateQuestion", question);
	}

	// 고민상담 글 삭제
	@Override
	public int deleteMessage(int questionNum) {
		return session.delete("question.deleteQuestion", questionNum);
	}

	// 댓글 작성(생성)
	@Override
	public int createQuestionComment(QuestionComment questioncomment) {
		return session.insert("question.createQuestionComment", questioncomment);
	}

	public int updateQuestionComment(QuestionComment questioncomment) {
		return session.update("question.updateQuestionComment", questioncomment);
	}

	
}

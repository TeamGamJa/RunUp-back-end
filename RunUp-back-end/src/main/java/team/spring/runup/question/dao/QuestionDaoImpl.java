package team.spring.runup.question.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import team.spring.runup.message.vo.Message;
import team.spring.runup.question.vo.Question;

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
	public List<Question> searchAllQuestion(int questionChoice) {
		List<Question> question = session.selectList("question.searchAllQuestion", questionChoice);
		return question;
	}
	
	// 고민상담 글 상세
	public Question openQuestion(int questionNum) {
		return session.selectOne("question.openQuestion", questionNum);
	}

	// 고민상담 글 수정
	public int updateQuestion(Question question) {
		return session.update("question.updateQuestion", question);
	}

	// 고민상담 글 삭제
	public int deleteMessage(int questionNum) {
		return session.delete("question.deleteQuestion", questionNum);
	}

	
}

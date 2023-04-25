package team.spring.runup.question.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}

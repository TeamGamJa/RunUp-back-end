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
	
	@Override
	public List<Question> getQuestionByKeyword(String keyword) {
		List<Question> list = session.selectList("question.getQuestionByKeyword",keyword);
		return list;
	}
}

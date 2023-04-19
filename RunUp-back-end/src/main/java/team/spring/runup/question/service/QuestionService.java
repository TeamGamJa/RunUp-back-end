package team.spring.runup.question.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.spring.runup.question.dao.QuestionDao;
import team.spring.runup.question.vo.Question;


@Service
public class QuestionService {

	@Autowired
	private QuestionDao dao;
	
	public List<Question> getQuestionByKeyword(String keyword) {
		List<Question> list = dao.getQuestionByKeyword(keyword);
		return list;
	}
		
}

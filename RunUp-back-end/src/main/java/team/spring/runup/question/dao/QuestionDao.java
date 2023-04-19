package team.spring.runup.question.dao;

import java.util.List;

import team.spring.runup.question.vo.Question;

public interface QuestionDao {

	List<Question> getQuestionByKeyword(String keyword); 
}

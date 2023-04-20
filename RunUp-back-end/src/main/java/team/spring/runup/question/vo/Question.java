package team.spring.runup.question.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
	private int QuestionNum;
	private int QuestionChoice;
	private String QuestionTitle;
	private String QuestionAuthor;
	private String QuestionDate;
	private String QuestionContent;
	private String QuestionCategoryBig;
	private String QuestionCategoryMedium;
	private int QuestionEmpathy;
	private int UserNum;
}

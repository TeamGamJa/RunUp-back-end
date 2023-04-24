package team.spring.runup.question.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
	private int questionNum;
	private int questionChoice;
	private String questionTitle;
	private String questionAuthor;
	private String questionDate;
	private String questionContent;
	private String questionCategoryBig;
	private String questionCategoryMedium;
	private int questionEmpathy;
	private int userNum;
}

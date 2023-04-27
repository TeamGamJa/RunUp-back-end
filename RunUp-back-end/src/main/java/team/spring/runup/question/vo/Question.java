package team.spring.runup.question.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
	
	private int questionNum;
	private String questionCategoryBig;
	private String questionCategoryMedium;
	private int questionChoice;
	private String questionTitle;
	private String questionContent;
	private String questionWriter;
	private int userNum;
	private String questionDate;
	private int questionLike;
		
}

package team.spring.runup.question.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionComment {

	private int qCommentNum;
	private String qCommentContent;
	private String qCommentWriter;
	private int questionNum;
}

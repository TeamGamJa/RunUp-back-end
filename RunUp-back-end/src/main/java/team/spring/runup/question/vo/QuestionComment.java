package team.spring.runup.question.vo;

import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Repository
public class QuestionComment {

	private int qCommentNum;
	private String qCommentContent;
	private String qCommentWriter;
	private int qNum;
}

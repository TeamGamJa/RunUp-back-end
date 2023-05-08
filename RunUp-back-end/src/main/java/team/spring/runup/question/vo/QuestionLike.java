package team.spring.runup.question.vo;

import lombok.Data;

@Data
public class QuestionLike {
	
	
	public QuestionLike() {
		
	}

	private int qlikeNum;
	private int userNum;
	private int questionNum;
	
	
	public QuestionLike(int qlikeNum, int userNum, int questionNum) {
		super();
		this.qlikeNum = qlikeNum;
		this.userNum = userNum;
		this.questionNum = questionNum;
	}


	public int getQlikeNum() {
		return qlikeNum;
	}


	public void setQlikeNum(int qlikeNum) {
		this.qlikeNum = qlikeNum;
	}


	public int getUserNum() {
		return userNum;
	}


	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}


	public int getQuestionNum() {
		return questionNum;
	}


	public void setQuestionNum(int questionNum) {
		this.questionNum = questionNum;
	}
	
	
}

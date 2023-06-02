package team.spring.runup.question.vo;


public class QuestionComment {

	
	
	
	public QuestionComment() {
		
	}
	

	public QuestionComment(int qCommentNum, String qCommentContent, String qCommentWriter, int questionNum,
			String qCommentDate, int userNum, String userUrl) {
		super();
		this.qCommentNum = qCommentNum;
		this.qCommentContent = qCommentContent;
		this.qCommentWriter = qCommentWriter;
		this.questionNum = questionNum;
		this.qCommentDate = qCommentDate;
		this.userNum = userNum;
		this.userUrl = userUrl;
	}


	private int qCommentNum;
	private String qCommentContent;
	private String qCommentWriter;
	private int questionNum;
	private String qCommentDate;
	private int userNum;
	private String userUrl;
	public int getqCommentNum() {
		return qCommentNum;
	}


	public void setqCommentNum(int qCommentNum) {
		this.qCommentNum = qCommentNum;
	}


	public String getqCommentContent() {
		return qCommentContent;
	}


	public void setqCommentContent(String qCommentContent) {
		this.qCommentContent = qCommentContent;
	}


	public String getqCommentWriter() {
		return qCommentWriter;
	}


	public void setqCommentWriter(String qCommentWriter) {
		this.qCommentWriter = qCommentWriter;
	}


	public int getQuestionNum() {
		return questionNum;
	}


	public void setQuestionNum(int questionNum) {
		this.questionNum = questionNum;
	}


	public String getqCommentDate() {
		return qCommentDate;
	}


	public void setqCommentDate(String qCommentDate) {
		this.qCommentDate = qCommentDate;
	}


	public String getUserUrl() {
		return userUrl;
	}


	public void setUserUrl(String userUrl) {
		this.userUrl = userUrl;
	}
	
	public int getUserNum() {
		return userNum;
	}
	
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	
}

package team.spring.runup.question.vo;

public class QuestionComment {

	
	public QuestionComment(int qCommentNum, String qCommentContent, String qCommentWriter, int questionNum) {
		super();
		this.qCommentNum = qCommentNum;
		this.qCommentContent = qCommentContent;
		this.qCommentWriter = qCommentWriter;
		this.questionNum = questionNum;
	}
	
	public QuestionComment() {
		
	}
	
	private int qCommentNum;
	private String qCommentContent;
	private String qCommentWriter;
	private int questionNum;
	
	
	
	
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
	
	
}

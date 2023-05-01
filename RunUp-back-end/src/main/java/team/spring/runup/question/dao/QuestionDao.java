package team.spring.runup.question.dao;

import java.util.List;

import team.spring.runup.question.vo.Question;
import team.spring.runup.question.vo.QuestionComment;

public interface QuestionDao {

	// 상단바 검색 - 고민상담 게시판 결과
	List<Question> getQuestionByKeyword(String keyword); 
	
	// 고민상담 글 작성
	int createQuestion(Question question) throws Exception;
	
	// 고민상담 글 전체 목록 
	public List<Question> searchAllQuestion(int questionChoice);
	
	// 고민상담 글 상세
	public Question openQuestion(int questionNum);
	
	// 고민상담 글 수정
	public int updateQuestion(Question question);
	
	// 고민상담 글 삭제
	public int deleteMessage(int questionNum);
	
	// 댓글 작성(생성)
	public int createQuestionComment(QuestionComment questioncomment);
	
	// 댓글 수정
	public int updateQuestionComment(QuestionComment questioncomment);
	
	// 댓글 삭제
	public int deleteQuestionComment(int qCommentNum);
	
	// 고민상담 글 공감
	
	// 공감 취소
}

package team.spring.runup.question.dao;

import java.util.List;

import team.spring.runup.question.vo.Question;
import team.spring.runup.question.vo.QuestionComment;
import team.spring.runup.question.vo.QuestionLike;

public interface QuestionDao {

	// 상단바 검색 - 고민상담 게시판 결과
	List<Question> getQuestionByKeyword(String keyword); 
	
	// 고민상담 글 작성
	int createQuestion(Question question) throws Exception;
	
	// 고민상담 글 전체 목록 
	public List<Question> searchAllQuestion();
	
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
	
	// 고민상담 공감 삭제
	public int deleteQuestionLike(QuestionLike questionlike);
	
	// 고민상담 공감 생성
	public int createQuestionLike(QuestionLike questionlike);
	
	// 고민상담 공감 1 감소
	public int decreaseLike(QuestionLike questionlike);
	
	// 고민상담 공감 1 증가
	public int increaseLike(QuestionLike questionlike);
}

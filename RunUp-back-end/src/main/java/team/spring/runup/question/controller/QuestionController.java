package team.spring.runup.question.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import team.spring.runup.question.service.QuestionService;
import team.spring.runup.question.vo.QuestionComment;
import team.spring.runup.question.vo.QuestionLike;
import team.spring.runup.question.vo.Question;

@RestController
@RequestMapping(value="question", produces="application/json; charset=UTF-8")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class QuestionController {

	// 로그 추가
	Logger log = LogManager.getLogger("case3");

		
	@Autowired
	private QuestionService service;

	// 묻고답하기 글 작성(생성)
	@PostMapping
	private ResponseEntity<Integer> createQuestion(@RequestBody Question question) throws Exception {
		
		log.debug("createQuestion 실행 = {}", question);
		
		int result = service.createQuestion(question);
		
		if (result ==1) {
			log.debug("고민상담 글 작성 성공");
		} else {
			log.debug("이상이 있어요");
		}
		
		log.debug("결과 = {}", result);
		
		return ResponseEntity.ok(result);
	}
		
	// 묻고답하기 글 전체 목록 
	// questionChoice = 0 -> 도움요청
	// questionChoice = 1 -> 고민상담
	@GetMapping(value="all")
	public ResponseEntity<List<Question>> searchAllQuestion() throws Exception {
		log.debug("questionChoice 조회 = {}");
		
		List<Question> result = service.searchAllQuestion();
		
		log.debug("결과 = {}", result);
		
		return ResponseEntity.ok(result);
	}
	
	// 도움요청 글 전체 목록
	@GetMapping(value="request")
	public ResponseEntity<List<Question>> searchRequest(@RequestParam(value="questionChoice", required=false) int questionChoice) throws Exception {
		log.debug("questionChoice 조회 = {}", questionChoice);
		
		List<Question> result = service.searchRequest(questionChoice);
		
		log.debug("결과 = {}", result);
		
		return ResponseEntity.ok(result);
	}
	
	
	// 고민상담 글 전체 목록
	@GetMapping(value="counsel")
	public ResponseEntity<List<Question>> searchCounsel(@RequestParam(value="questionChoice", required=false) int questionChoice) throws Exception {
		log.debug("questionChoice 조회 = {}", questionChoice);
		
		List<Question> result = service.searchCounsel(questionChoice);
		
		log.debug("결과 = {}", result);
		
		return ResponseEntity.ok(result);
	}
	
		
	// 묻고답하기 글 상세
	@GetMapping(value="content")
	public ResponseEntity<Question> openQuestion(int questionNum) throws Exception {
		log.debug("questionNum 조회 = {}", questionNum);
		
		Question result = service.openQuestion(questionNum);
		
		log.debug("결과 = {}", result);
		
		return ResponseEntity.ok(result);
	}
		
	// 묻고답하기 글 수정
	@PutMapping
	public ResponseEntity<Integer> updateQuestion(@RequestBody Question question) throws Exception {
		log.debug("updateQuestion 실행 = {}", question);
		
		int result = service.updateQuestion(question);
		
		if (result ==1) {
			log.debug("고민상담 글 수정 성공");
		} else {
			log.debug("이상이 있어요");
		}
		
		log.debug("결과 = {}", result);
		
		return ResponseEntity.ok(result);
	}
		
	// 묻고답하기 글 삭제
	@DeleteMapping
	public ResponseEntity<Integer> deleteQuestion(int questionNum) throws Exception {
		log.debug("questionNum 조회 = {}", questionNum);
		
		int result = service.deleteQuestion(questionNum);
		
		if (result ==1) {
			log.debug("고민상담 삭제 성공");
		} else {
			log.debug("이상이 있어요");
		}
		
		log.debug("결과 = {}", result);
		
		return ResponseEntity.ok(result);
	}
		
	// 댓글 작성(생성)
	@PostMapping(value="comment")
	private ResponseEntity<Integer> createQuestionComment(@RequestBody QuestionComment questioncomment) throws Exception {
		
		log.debug("createQuestionComment 실행 = {}", questioncomment);
		
		int result = service.createQuestionComment(questioncomment);
		
		if (result ==1) {
			log.debug("고민상담 댓글 작성 성공");
		} else {
			log.debug("이상이 있어요");
		}
		
		log.debug("결과 = {}", result);
		
		return ResponseEntity.ok(result);
	}
		
	// 댓글 수정
	@PutMapping(value="comment")
	public ResponseEntity<Integer> updateQuestionComment(@RequestBody QuestionComment questioncomment) throws Exception {
		
		log.debug("updateQuestionComment 실행 = {}", questioncomment.getqCommentWriter());
		
		int result = service.updateQuestionComment(questioncomment);
		
		if (result ==1) {
			log.debug("고민상담 댓글 수정 성공");
		} else {
			log.debug("이상이 있어요");
		}
		
		log.debug("결과 = {}", result);
		
		return ResponseEntity.ok(result);
	}
		
	// 댓글 삭제
	@DeleteMapping(value="comment")
	public ResponseEntity<Integer> deleteQuestionComment(@RequestBody QuestionComment qCommentNum) throws Exception {
		log.debug("qCommentNum 조회 = {}", qCommentNum);
		
		int result = service.deleteQuestionComment(qCommentNum.getqCommentNum());
		
		if (result ==1) {
			log.debug("고민상담 댓글 삭제 성공");
		} else {
			log.debug("이상이 있어요");
		}
		
		log.debug("결과 = {}", result);
		
		return ResponseEntity.ok(result);
	}
	
	// 댓글 목록 가져오기
	@GetMapping(value="comment")
	public ResponseEntity<List<QuestionComment>> searchQuestionComment(@RequestParam(value="questionNum", required=false) int questionNum) throws Exception {
		log.debug("questionNum 조회 = {}", questionNum);
		
		List<QuestionComment> result = service.searchQuestionComment(questionNum);
		
		log.debug("결과 = {}", result);
		
		return ResponseEntity.ok(result);
	}
	
	// 댓글 하나 가져오기
	@GetMapping(value="oneComment")
	public ResponseEntity<QuestionComment> searchOneQuestionComment(@RequestParam(value="qCommentNum", required=false) int qCommentNum) throws Exception {
		log.debug("questionNum 조회 = {}", qCommentNum);
		
		QuestionComment result = service.searchOneQuestionComment(qCommentNum);
		
		log.debug("결과 = {}", result);
		
		return ResponseEntity.ok(result);
	}
	
	
		
	// 묻고답하기 공감 삭제 요청
	// result = 1 -> '삭제' -> 공감 1 감소
	// result = 0 -> '삭제 실패' = 기존에 공감이 없었던 것 -> 곰감 1 증가 
	@PostMapping(value="like")
	private ResponseEntity<Integer> updateQuestionLike(@RequestBody QuestionLike questionlike) throws Exception {
		
		log.debug("deleteQuestionLike 실행 = {}", questionlike);
		
		int result = service.deleteQuestionLike(questionlike);
		
		if (result ==1) {
			log.debug("고민상담 좋아요 삭제");
			service.decreaseLike(questionlike);
			log.debug("고민상담 좋아요 1 감소");
		} if (result ==0) {
			service.createQuestionLike(questionlike); 
			log.debug("고민상담 좋아요 생성");
			service.increaseLike(questionlike);
			log.debug("고민상담 좋아요 1 증가");
		} else {
			log.debug("이상이 있어요");
		}
		
		log.debug("결과 = {}", result);
		
		return ResponseEntity.ok(result);
	}
	
	
	// 묻고답하기 공감 수 가져오기
	@GetMapping(value="like")
	public ResponseEntity<Integer> searchQuestionLike(Question QuestionNum) throws Exception {
		log.debug("QuestionNum 조회 = {}", QuestionNum);
		
		int result = service.searchQuestionLike(QuestionNum.getQuestionNum());
		
		log.debug("결과 = {}", result);
		
		return ResponseEntity.ok(result);
	}
	
		

}

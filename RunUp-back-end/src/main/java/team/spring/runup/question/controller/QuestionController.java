package team.spring.runup.question.controller;

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
import org.springframework.web.bind.annotation.RestController;

import team.spring.runup.question.service.QuestionService;
import team.spring.runup.question.vo.Question;

@RestController
@RequestMapping(value="question", produces="application/json; charset=UTF-8")
@CrossOrigin(origins = "http://localhost:8081", allowedHeaders = "*")
public class QuestionController {

	// 로그 추가
	Logger log = LogManager.getLogger("case3");

		
	@Autowired
	private QuestionService service;
	
	// 고민상담 글 작성(생성)
	@PostMapping
	private ResponseEntity<Integer> createQuestion(@RequestBody Question question) throws Exception {
		
		log.debug("createMessage 실행 = {}", question);
		
		int result = service.createQuestion(question);
		
		if (result ==1) {
			log.debug("고민상담 글 작성 성공");
		} else {
			log.debug("이상이 있어요");
		}
		
		log.debug("결과 = {}", result);
		
		return ResponseEntity.ok(result);
	}
		
	// 고민상담 글 전체 목록 
		
	// 고민상담 글 상세
	@GetMapping(value="content")
	public ResponseEntity<Question> openQuestion(int questionNum) throws Exception {
		log.debug("questionNum 조회 = {}", questionNum);
		
		Question result = service.openQuestion(questionNum);
		
		log.debug("결과 = {}", result);
		
		return ResponseEntity.ok(result);
	}
		
	// 고민상담 글 수정
	@PutMapping
	public ResponseEntity<Integer> updateQuestion(@RequestBody Question question) throws Exception {
		log.debug("updateMessage 실행 = {}", question);
		
		int result = service.updateQuestion(question);
		
		if (result ==1) {
			log.debug("고민상담 글 수정 성공");
		} else {
			log.debug("이상이 있어요");
		}
		
		log.debug("결과 = {}", result);
		
		return ResponseEntity.ok(result);
	}
		
	// 고민상담 글 삭제
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
		
	// 댓글 작성
		
	// 댓글 수정
		
	// 댓글 삭제
		
	// 고민상담 글 공감
		
	// 공감 취소
}

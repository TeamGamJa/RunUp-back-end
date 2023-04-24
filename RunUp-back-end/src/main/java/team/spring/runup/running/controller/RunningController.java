package team.spring.runup.running.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.fasterxml.jackson.core.JsonProcessingException;

import team.spring.runup.question.service.QuestionService;
import team.spring.runup.question.vo.Question;
import team.spring.runup.running.service.RunningService;
import team.spring.runup.running.vo.Category;
import team.spring.runup.running.vo.Running;
import team.spring.runup.user.service.UserService;
import team.spring.runup.user.vo.User;



@RestController
@RequestMapping(value="running",produces="application/json; charset=UTF-8")
@CrossOrigin(origins = "http://localhost:8081", allowedHeaders = "*")
public class RunningController {

Logger log = LogManager.getLogger("case3");
	
	@Autowired
	private RunningService runningservice;
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private QuestionService questionservice;
	
	@GetMapping(value="category")
	public HashMap<Object, Object> searchCategoryAll() throws JsonProcessingException {
		
		List<String> categoryBig = runningservice.selectCategoryBigAll();
		List<String> categoryMedium = runningservice.selectCategoryMediumAll();
		
		log.debug(categoryBig);
		log.debug(categoryMedium);
		
		HashMap<Object, Object> hashmap = new HashMap<Object, Object>();
		hashmap.put("categoryBig", categoryBig);
		hashmap.put("categoryMedium", categoryMedium);
		
		
		return hashmap;
	}
	
	@GetMapping(value="categorybig")
	public HashMap<Object, Object> searchCategoryBig() throws JsonProcessingException {
		
		List<String> categoryBig = runningservice.selectCategoryBigAll();
		
		
		log.debug(categoryBig);
		
		HashMap<Object, Object> hashmap = new HashMap<Object, Object>();
		hashmap.put("categoryBig", categoryBig);
		
		
		return hashmap;
	}
	
	@GetMapping(value="categorymedium")
	public HashMap<Object, Object> searchCategoryMedium(@RequestParam(value="categoryBig", 
			required=false) String categoryBig) throws JsonProcessingException {
		
		
		List<String> categoryMedium = runningservice.selectCategoryMediumList(categoryBig);
		
		log.debug(categoryMedium);
		HashMap<Object, Object> hashmap = new HashMap<Object, Object>();
		hashmap.put("categoryMedium", categoryMedium);
		
		return hashmap;
	}
	
	@GetMapping(value="bar")
	public HashMap<Object, Object> barSearch(@RequestParam(value="keyword", required=false) String keyword) throws JsonProcessingException {
		
		log.debug(keyword);
		List<Running> runninglist = runningservice.selectRunningByKeyword(keyword); 
		List<User> userlist = userservice.getUserByNickname(keyword);
		List<Question> questionlist = questionservice.getQuestionByKeyword(keyword);
		log.debug(runninglist);
		log.debug(userlist);
		log.debug(questionlist);
		HashMap<Object, Object> hashmap = new HashMap<Object, Object>();
		hashmap.put("runninglist", runninglist);
		hashmap.put("userlist", userlist);
		hashmap.put("questionlist", questionlist);
		return hashmap;
	}
	
	@GetMapping(value="bycategorybig")
	public ResponseEntity<List<Running>> searchRunningByCategoryBig(@RequestParam(value="categoryBig", required=false) String categoryBig) throws JsonProcessingException {
		
		List<Running> runninglistall = runningservice.selectRunningBycategoryBig(categoryBig); 
		log.debug(runninglistall);
		return ResponseEntity.ok(runninglistall);
	}
	
	@GetMapping(value="bycategorymedium")
	public ResponseEntity<List<Running>> searchRunningByCategoryMedium(@RequestParam(value="categoryMedium", required=false) String categoryMedium) throws JsonProcessingException {
		
		List<Running> runninglistall = runningservice.selectRunningBycategoryMedium(categoryMedium); 
		log.debug(runninglistall);
		return ResponseEntity.ok(runninglistall);
	}
	
	@GetMapping(value="all")
	public ResponseEntity<List<Running>> searchRunningAll() throws JsonProcessingException {
		
		List<Running> runningList = runningservice.selectRunningList(); 
		log.debug(runningList);
		return ResponseEntity.ok(runningList);
	}
	
	@GetMapping
	public ResponseEntity<Running> searchRunning(@RequestParam(value="runningNum", required=false) int runningNum) throws JsonProcessingException {
		
		Running run = new Running();
		run.setRunningNum(runningNum);
		runningservice.updateViewNum(run);
		Running runningone = runningservice.selectRunning(run); 
		log.debug(runningone);
		return ResponseEntity.ok(runningone);
	}
	
	@PostMapping
	public ResponseEntity<Integer> createRunning(@RequestBody Running run)  {

		log.debug(run);
		int result = runningservice.createRunning(run);
		log.debug(result);
		
		return ResponseEntity.ok(result);
		
	}
	
	@DeleteMapping
	public ResponseEntity<Integer> deleteRunning(@RequestBody Running run) {
		
		log.debug(run);
		int result = runningservice.deleteRunning(run);
		log.debug(result);
		
		return ResponseEntity.ok(result);
	}
	
	@PutMapping
	public ResponseEntity<Integer> updateRunning(@RequestBody Running run) {
		
		log.debug(run);
		int result = runningservice.updateRunning(run);
		log.debug(result);
		
		return ResponseEntity.ok(result);
	}
}

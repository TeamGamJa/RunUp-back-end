package team.spring.runup.running.controller;

import java.util.HashMap;
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
	public HashMap<Object, Object> searchCategoryBig() throws JsonProcessingException {
		
		List<String> categoryBig = runningservice.selectCategoryBigAll();
		List<String> categoryMedium = runningservice.selectCategoryMediumAll();
		
		log.debug(categoryBig);
		log.debug(categoryMedium);
		HashMap<Object, Object> hashmap = new HashMap<Object, Object>();
		hashmap.put("categoryBig", categoryBig);
		hashmap.put("categoryMedium", categoryMedium);
		
		return hashmap;
	}
	
//	@GetMapping(value="categorymedium")
//	public HashMap<Object, Object> searchCategoryMedium(@RequestParam(value="big", 
//			required=false) String big) throws JsonProcessingException {
//		
//		Category category = new Category();
//		category.setCategoryBig(big);
//		List<Category> mediumlist = runningservice.selectCategoryMediumAll(category);
//		
//		log.debug(mediumlist);
//		HashMap<Object, Object> hashmap = new HashMap<Object, Object>();
//	    hashmap.put("mediumlist", mediumlist);
//		
//		return hashmap;
//	}
	
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
	
	@GetMapping(value="s")
	public ResponseEntity<List<Running>> searchRunning() throws JsonProcessingException {
		
		List<Running> runninglistall = runningservice.selectRunningList(); 
		log.debug(runninglistall);
		return ResponseEntity.ok(runninglistall);
	}
	
	@PostMapping(value="i")
	public HashMap<Object, Object> createRunning(@RequestParam(value="title", required=false) String title, 
			@RequestParam(value="content",required=false) String content, 
			@RequestParam(value="categorybig",required=false) String categorybig,
			@RequestParam(value="categorymedium",required=false) String categorymedium,
			@RequestParam(value="startbig",required=false) int startbig,
			@RequestParam(value="startsmall",required=false) int startsmall,
			@RequestParam(value="endbig",required=false) int endbig,
			@RequestParam(value="endsmall",required=false) int endsmall,
			@RequestParam(value="keep",required=false) boolean keep,
			@RequestParam(value="usernum",required=false) int usernum) throws JsonProcessingException {
		
		log.debug(keep);
		Running run = new Running();
		run.setRunningTitle(title);
		run.setRunningContent(content);
		run.setRunningCategoryBig(categorybig);
		run.setRunningCategoryMedium(categorymedium);
		run.setRunningStartBig(startbig);
		run.setRunningStartSmall(startsmall);
		run.setRunningEndBig(endbig);
		run.setRunningEndSmall(endsmall);
		run.setRunningKeep(keep);
		run.setUserNum(usernum);
		log.debug(run);
		
		int result = runningservice.createRunning(run);
		log.debug(result);
		
		HashMap<Object, Object> hashmap = new HashMap<Object, Object>();
		hashmap.put("result", result);
		return hashmap;
		
	}
	
	@DeleteMapping(value="d") 
	public ResponseEntity<Integer> deleteRunning(@RequestParam int usernum, 
			@RequestParam int runningnum) {
		
		Running run = new Running();
		run.setUserNum(usernum);
		run.setRunningNum(runningnum);
		log.debug(run);
		
		int result = runningservice.deleteRunning(run);
		log.debug(result);
		

		return ResponseEntity.ok(result);
		
	}
	
	@PutMapping(value="u") 
	public int updateRunning(@RequestBody String title, 
			@RequestBody String content, @RequestBody String categorybig,
			@RequestParam(value="categorymedium",required=false) String categorymedium,
			@RequestParam(value="usernum",required=false) int usernum) throws JsonProcessingException {
		
		log.debug(usernum);
		Running run = new Running();
		run.setRunningTitle(title);
		run.setRunningContent(content);
		run.setRunningCategoryBig(categorybig);
		run.setRunningCategoryMedium(categorymedium);
		run.setUserNum(usernum);
		log.debug(run);
		
		int result = runningservice.updateRunning(run);
		log.debug(result);
		
		
		return result;
	}
}

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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import team.spring.runup.question.service.QuestionService;
import team.spring.runup.question.vo.Question;
import team.spring.runup.running.service.RunningService;
import team.spring.runup.running.vo.Category;
import team.spring.runup.running.vo.Point;
import team.spring.runup.running.vo.RunCalender;
import team.spring.runup.running.vo.Running;
import team.spring.runup.running.vo.RunningBarOne;
import team.spring.runup.running.vo.RunningBarTwo;
import team.spring.runup.running.vo.RunningLineOne;
import team.spring.runup.running.vo.RunningPieOne;
import team.spring.runup.running.vo.Runup;
import team.spring.runup.user.service.UserService;
import team.spring.runup.user.vo.User;



@RestController
@RequestMapping(value="running",produces="application/json; charset=UTF-8")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RunningController {

Logger log = LogManager.getLogger("case3");
	
	@Autowired
	private RunningService runningservice;
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private QuestionService questionservice;
	
	@GetMapping(value="allpointchart")
	public ResponseEntity<List<RunningBarTwo>> allPointChart() throws JsonProcessingException {
		
		//log.debug(userNum);
		List<RunningBarTwo> pointList = runningservice.getPointByUserNum();
		log.debug(pointList);
		
		return ResponseEntity.ok(pointList);
	}
	
	@GetMapping(value="allcolorchart")
	public ResponseEntity<List<RunningBarTwo>> allColorChart() throws JsonProcessingException {
		
		//log.debug(userNum);
		List<RunningBarTwo> colorList = runningservice.getColorByUserNum();
		log.debug(colorList);
		
		return ResponseEntity.ok(colorList);
	}
	
	@GetMapping(value="allchart")
	public ResponseEntity<List<RunningBarOne>> barChartOne() throws JsonProcessingException {
		
		//log.debug(userNum);
		List<RunningBarOne> barList = runningservice.getBarByUserNum();
		log.debug(barList);
		
		return ResponseEntity.ok(barList);
	}
	
	@GetMapping(value="weekchart")
	public ResponseEntity<List<RunningBarOne>> barCharttwo() throws JsonProcessingException {
		
		//log.debug(userNum);
		List<RunningBarOne> barList2 = runningservice.getBarByDate();
		log.debug(barList2);
		
		return ResponseEntity.ok(barList2);
	}
	
	@GetMapping(value="pchart")
	public ResponseEntity<List<RunningPieOne>> pieChart(@RequestParam(value="userNum", required=false) int userNum) throws JsonProcessingException {
		
		log.debug(userNum);
		List<RunningPieOne> pieList = runningservice.getPieByUserNum(userNum);
		log.debug(pieList);
		
		return ResponseEntity.ok(pieList);
	}
	
	@GetMapping(value="lchart")
	public ResponseEntity<List<RunningLineOne>> lineChart(@RequestParam(value="userNum", required=false) int userNum) throws JsonProcessingException {
		
		log.debug(userNum);
		List<RunningLineOne> lineList = runningservice.getLineByUserNum(userNum);
		log.debug(lineList);
		
		return ResponseEntity.ok(lineList);
	}
	
	@GetMapping(value="category")
	public HashMap<Object, Object> searchCategoryAll() throws JsonProcessingException {
		
		List<String> categoryBig = runningservice.getCategoryBigAll();
		List<String> categoryMedium = runningservice.getCategoryMediumAll();
		
		log.debug(categoryBig);
		log.debug(categoryMedium);
		
		HashMap<Object, Object> hashmap = new HashMap<Object, Object>();
		hashmap.put("categoryBig", categoryBig);
		hashmap.put("categoryMedium", categoryMedium);
		
		return hashmap;
	}
	
	@GetMapping(value="categorybig")
	public HashMap<Object, Object> searchCategoryBig() throws JsonProcessingException {
		
		List<String> categoryBig = runningservice.getCategoryBigAll();
		
		log.debug(categoryBig);
		
		HashMap<Object, Object> hashmap = new HashMap<Object, Object>();
		hashmap.put("categoryBig", categoryBig);
		
		return hashmap;
	}
	
	@GetMapping(value="categorymedium")
	public HashMap<Object, Object> searchCategoryMedium(@RequestParam(value="categoryBig", 
			required=false) String categoryBig) throws JsonProcessingException {
		
		List<String> categoryMedium = runningservice.getCategoryMediumList(categoryBig);
		
		log.debug(categoryMedium);
		HashMap<Object, Object> hashmap = new HashMap<Object, Object>();
		hashmap.put("categoryMedium", categoryMedium);
		
		return hashmap;
	}
	
	@GetMapping(value="bar")
	public HashMap<Object, Object> barSearch(@RequestParam(value="keyword", required=false) String keyword) throws JsonProcessingException {
		
		List<Running> runninglist = runningservice.getRunningByKeyword(keyword); 
		List<User> userlist = userservice.getUserByNickname(keyword);
		List<Question> questionlist = questionservice.getQuestionByKeyword(keyword); 
		log.debug(runninglist);
		log.debug(userlist);
		log.debug(questionlist);
		HashMap<Object, Object> hashmap = new HashMap<Object, Object>();
		hashmap.put("runningList", runninglist);
		hashmap.put("userList", userlist);
		hashmap.put("questionList", questionlist);
		return hashmap;
	}
	
	@GetMapping(value="mentor")
	public ResponseEntity<List<User>> searchMentor(@RequestParam(value="keyword", required=false) String keyword) throws JsonProcessingException {
		
		log.debug(keyword);
		List<User> userList = userservice.getUserByNickname(keyword);
		log.debug(userList);
		
		return ResponseEntity.ok(userList);
	}
	
	@GetMapping(value="bycategorybig")
	public ResponseEntity<List<Runup>> searchRunningByCategoryBig(@RequestParam(value="categoryBig", required=false) String categoryBig) throws JsonProcessingException {
		
		List<Runup> runningList = runningservice.getRunningBycategoryBig(categoryBig); 
		log.debug(runningList);
		return ResponseEntity.ok(runningList);
	}
	
	@GetMapping(value="bycategorymedium")
	public ResponseEntity<List<Runup>> searchRunningByCategoryMedium(@RequestParam(value="categoryBig", required=false) String categoryBig,
			@RequestParam(value="categoryMedium", required=false) String categoryMedium) throws JsonProcessingException {
		
		List<Runup> runningList = runningservice.getRunningBycategoryMedium(categoryMedium); 
		log.debug(runningList);
		return ResponseEntity.ok(runningList);
	}
	
	@GetMapping(value="searchbar")
	public ResponseEntity<List<Runup>> searchBar(@RequestParam(value="runningTitle", required=false) String runningTitle) throws JsonProcessingException {
		
		log.debug(runningTitle);
		List<Runup> keyList = runningservice.getRunningByRunningTitle(runningTitle);
		log.debug(keyList);
		
		return ResponseEntity.ok(keyList);
	}
	
	@GetMapping(value="finishlist")
	public ResponseEntity<List<Runup>> finishRunningList(@RequestParam(value="participateNum", required=false) int participateNum) throws JsonProcessingException {
		
		List<Runup> finishList = runningservice.getFinishRunningList(participateNum); 
		log.debug(finishList);
		return ResponseEntity.ok(finishList); 
	} 
	
	@GetMapping(value="all")
	public ResponseEntity<List<Runup>> searchRunningAll() throws JsonProcessingException {
		
		List<Runup> runningList = runningservice.getRunningList(); 
		log.debug(runningList);
		return ResponseEntity.ok(runningList); 
	}
	
	@GetMapping(value="alltake")
	public HashMap<Object, Object> takeRunningAll(@RequestParam(value="participateNum", required=false) int participateNum) throws JsonProcessingException {
		
		List<RunCalender> runningGreen = runningservice.getRunningByParticipateNum(participateNum);
		List<RunCalender> runningGray = runningservice.getRunningByRunningShow(participateNum); 
		log.debug(runningGray);
		log.debug(runningGreen);
		
		HashMap<Object, Object> hashmap = new HashMap<Object, Object>();
		hashmap.put("runningGreen", runningGreen);
		hashmap.put("runningGray", runningGray);
		return hashmap;
	}
	
	@GetMapping(value="allgive")
	public HashMap<Object, Object> giveRunningAll(@RequestParam(value="userNum", required=false) int userNum) throws JsonProcessingException {
		
		
		List<RunCalender> runningOrange = runningservice.getRunningByRunningAble(userNum); 
		List<RunCalender> runningBlue = runningservice.getRunningByRunningAbleTrue(userNum);  
		
		
		log.debug(runningOrange);
		log.debug(runningBlue);
		
		HashMap<Object, Object> hashmap = new HashMap<Object, Object>();
		hashmap.put("runningOrange", runningOrange);
		hashmap.put("runningBlue", runningBlue);
		return hashmap;
	}
	
	@GetMapping
	public ResponseEntity<Running> searchRunning(@RequestParam(value="runningNum", required=false) int runningNum) throws JsonProcessingException {
		
		Running run = new Running();
		run.setRunningNum(runningNum);
		runningservice.updateViewNum(run);
		Running runningOne = runningservice.getRunning(run); 
		log.debug(runningOne);
		return ResponseEntity.ok(runningOne);
	}
	
	@PostMapping
	public ResponseEntity<Integer> createRunning(@RequestBody Running run)  {

		log.debug(run);
		//log.debug(okay);
		int result = runningservice.createRunning(run);
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
	
	@PutMapping(value="participation")
	public ResponseEntity<Integer> participateRunning(@RequestBody Running run) {
		int result = 0;
		log.debug(run);
		int mypoint = runningservice.getRunningPoint(run);
		if (mypoint >= 30) {
		result = runningservice.updateRunningAble(run);
		runningservice.updateUserPointMinus(run);
		}
		return ResponseEntity.ok(result);
	}
	
	@PutMapping(value="finishlearning")
	public ResponseEntity<Integer> finishlearning(@RequestBody User user) {
		
		log.debug(user);
		int result = runningservice.updateFinishLearning(user);
		
		return ResponseEntity.ok(result);
	}
	
	@PutMapping(value="finishrunning")
	public ResponseEntity<Integer> finishRunning(@RequestBody User user) {
		
		log.debug(user);
		int result = runningservice.updateFinishRunning(user);
		Running run = new Running();
		run.setParticipateNum(user.getUserPoint());
		runningservice.updateUserPointPlus(run);
		
		return ResponseEntity.ok(result);
	}
	
	@PutMapping(value="cancellearning")
	public ResponseEntity<Integer> cancelLearning(@RequestBody Running run) {
		
		log.debug(run);

		int result = runningservice.updateCancelByParticipateNum(run);
		runningservice.updateUserPointPlus(run);
				
		return ResponseEntity.ok(result);
	}
		
	@PutMapping(value="salt")
	public ResponseEntity<Integer> saltRunning(@RequestBody Map<Object,Object> salt) {
		
		int runningnum = (int) salt.get("runningNum");
		int usercolor = (int) salt.get("userLuxColor");
		int usernum = runningservice.getUserNumByRunningNum(runningnum);
		User user = new User();
		user.setUserNum(usernum);
		user.setUserColor(usercolor);
		int result = runningservice.updateSalt(user);
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
	
	@DeleteMapping(value="cancelrunning")
	public ResponseEntity<Integer> cancelRunning(@RequestBody Running run) {
		
		log.debug(run);
		int result = runningservice.cancelRunning(run);
		log.debug(result);
		return ResponseEntity.ok(result);
	}
}

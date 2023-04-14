package team.spring.runup.running.controller;

import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import team.spring.runup.running.service.RunningService;
import team.spring.runup.running.vo.CategoryBig;
import team.spring.runup.running.vo.CategoryMedium;
import team.spring.runup.running.vo.Running;



@RestController
@RequestMapping(value="running",produces="application/json")
@CrossOrigin(origins = "http://localhost:8081", allowedHeaders = "*")
public class RunningController {

Logger log = LogManager.getLogger("case3");
	
	@Autowired
	private RunningService runningservice;
	
	
	@GetMapping(value="category")
	public HashMap<String, Object> category(@RequestParam(value="num", 
			required=false) String num) throws JsonProcessingException {
		
		
		
		List<CategoryBig> biglist = runningservice.selectCategoryBigAll();
		List<CategoryMedium> mediumlist = runningservice.selectCategoryMediumAll();
		log.debug(biglist);
		log.debug(mediumlist);
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("biglist", biglist);
	    hashmap.put("mediumlist", mediumlist);
		
		return hashmap;
	}
	
}

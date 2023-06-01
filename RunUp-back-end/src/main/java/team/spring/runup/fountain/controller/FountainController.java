package team.spring.runup.fountain.controller;

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

import team.spring.runup.donation.vo.Donation;
import team.spring.runup.fountain.service.FountainService;
import team.spring.runup.fountain.vo.Fountain;
import team.spring.runup.running.vo.Running;


@RestController
@RequestMapping(value="fountain",produces="application/json; charset=UTF-8")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FountainController {

Logger log = LogManager.getLogger("case3");
	
	@Autowired
	private FountainService fountainservice;
	
	@GetMapping(value="all")
	public ResponseEntity<List<Fountain>> searchFountainAll() throws JsonProcessingException {
		
		List<Fountain> fountainList = fountainservice.getFountainList(); 
		log.debug(fountainList);
		return ResponseEntity.ok(fountainList);
	}
	
//	@GetMapping
//	public ResponseEntity<Fountain> searchFountain(@RequestParam(value="fountainNum", required=false) int fountainNum) throws JsonProcessingException {
//		
//		Fountain fountain = new Fountain();
//		fountain.setFountainNum(fountainNum);
//		
//		Fountain fountainOne = fountainservice.getFountain(fountain); 
//		log.debug(fountainOne);
//		return ResponseEntity.ok(fountainOne);
//	}
	
	@PostMapping
	public ResponseEntity<Integer> createFountain(@RequestBody Fountain fountain)  {

		log.debug(fountain);
		//log.debug(okay);
		int result = fountainservice.createFountain(fountain);
		log.debug(result);
		return ResponseEntity.ok(result);
	}
	
//	@DeleteMapping
//	public ResponseEntity<Integer> deleteFountain(@RequestBody Fountain fountain) {
//		
//		log.debug(fountain);
//		int result = fountainservice.deleteFountain(fountain);
//		log.debug(result);
//		return ResponseEntity.ok(result);
//	}
//	
	
	
}

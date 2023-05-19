package team.spring.runup.donation.controller;

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

import team.spring.runup.donation.service.DonationService;
import team.spring.runup.donation.vo.Donation;
import team.spring.runup.fountain.service.FountainService;
import team.spring.runup.fountain.vo.Fountain;
import team.spring.runup.running.service.RunningService;
import team.spring.runup.running.vo.Running;


@RestController
@RequestMapping(value="donation",produces="application/json; charset=UTF-8")
@CrossOrigin(origins = "http://localhost:8081", allowedHeaders = "*")
public class DonationController {

Logger log = LogManager.getLogger("case3");
	
	@Autowired
	private DonationService donationservice;
	
	@Autowired
	private RunningService runningservice;
	
	@Autowired
	private FountainService fountainservice;
	
	@GetMapping(value="all")
	public ResponseEntity<List<Donation>> searchDonationAll() throws JsonProcessingException {
		
		List<Donation> donationList = donationservice.getDonationList(); 
		log.debug(donationList);
		return ResponseEntity.ok(donationList);
	}
	
	@GetMapping
	public ResponseEntity<Donation> searchDonation(@RequestParam(value="donationNum", required=false) int donationNum) throws JsonProcessingException {
		
		Donation donation = new Donation();
		donation.setDonationNum(donationNum);
		
		Donation donationOne = donationservice.getDonation(donation); 
		log.debug(donationOne);
		return ResponseEntity.ok(donationOne);
	}
	
	@PostMapping
	public ResponseEntity<Integer> createDonation(@RequestBody Donation donation)  {
		int result = 0;
		
		log.debug(donation);
		Running run = new Running();
		run.setUserNum(donation.getUserNum());
		Fountain fountain = new Fountain();
		fountain.setFountainNum(donation.getFountainNum());
		Fountain fountainOne = fountainservice.getFountain(fountain);
		
		int mypoint = runningservice.getRunningPoint(run);
		if (mypoint >= 10) {
		result = donationservice.createDonation(donation);
		donationservice.updateDonationPointMinus(donation.getUserNum());
		donationservice.updateDonationPointPlus(fountainOne.getUserNum());
		//fountainservice.updateFountainCount(donation.getFountainNum());
		}
		log.debug(result);
		return ResponseEntity.ok(result);
	}
	
	@DeleteMapping
	public ResponseEntity<Integer> deleteDonation(@RequestBody Donation donation) {
		
		log.debug(donation);
		int result = donationservice.deleteDonation(donation);
		log.debug(result);
		return ResponseEntity.ok(result);
	}
	
	@PutMapping
	public ResponseEntity<Integer> updateDonation(@RequestBody Donation donation) {
		
		log.debug(donation);
		int result = donationservice.updateDonation(donation);
		log.debug(result);
		
		return ResponseEntity.ok(result);
	}
}

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


@RestController
@RequestMapping(value="donation",produces="application/json; charset=UTF-8")
@CrossOrigin(origins = "http://localhost:8081", allowedHeaders = "*")
public class DonationController {

Logger log = LogManager.getLogger("case3");
	
	@Autowired
	private DonationService donationservice;
	
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

		log.debug(donation);
		//log.debug(okay);
		int result = donationservice.createDonation(donation);
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

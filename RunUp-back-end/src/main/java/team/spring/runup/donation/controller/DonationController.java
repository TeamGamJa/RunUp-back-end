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
import team.spring.runup.user.service.UserService;
import team.spring.runup.user.vo.User;


@RestController
@RequestMapping(value="donation",produces="application/json; charset=UTF-8")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DonationController {

Logger log = LogManager.getLogger("case3");
	
	@Autowired
	private DonationService donationservice;
	
	@Autowired
	private RunningService runningservice;
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private FountainService fountainservice;
	
//	@GetMapping(value="all")
//	public ResponseEntity<List<Donation>> searchDonationAll() throws JsonProcessingException {
//		
//		List<Donation> donationList = donationservice.getDonationList(); 
//		log.debug(donationList);
//		return ResponseEntity.ok(donationList);
//	}
//	
//	@GetMapping
//	public ResponseEntity<Donation> searchDonation(@RequestParam(value="donationNum", required=false) int donationNum) throws JsonProcessingException {
//		
//		Donation donation = new Donation();
//		donation.setDonationNum(donationNum);
//		
//		Donation donationOne = donationservice.getDonation(donation); 
//		log.debug(donationOne);
//		return ResponseEntity.ok(donationOne);
//	}
	
	@PostMapping
	public ResponseEntity<Integer> createDonation(@RequestBody Donation donation)  {
		int result = 0;
		int fountainResult = 0;
		String sender = new String();
		String receiver = new String();
		
		log.debug(donation);
		User user = new User();
		user.setUserNickname(donation.getDonationSender());

		int donationNum = donationservice.getDonationNum(donation);
		int mypoint = userservice.getPointByUserNickname(user);
		sender = donation.getDonationSender();
		receiver = donation.getDonationReceiver();
		
		if (!sender.equals(receiver)) {
		    
		    if (donationNum == 0) {
		       
		        if (mypoint >= donation.getDonationPoint()) {
		        	result = donationservice.createDonation(donation);
		    		donationservice.updateDonationPointMinus(donation);
		    		donationservice.updateDonationPointPlus(donation);
		        } else {
		            fountainResult = 3;
		        }

		    } else {
		        fountainResult = 2;
		    }

		} else {
		    fountainResult = 1;
		}
		
		log.debug(fountainResult);
		return ResponseEntity.ok(fountainResult);
	}
	
}

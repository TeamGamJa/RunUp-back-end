package team.spring.runup.donation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.spring.runup.donation.dao.DonationDao;
import team.spring.runup.donation.vo.Donation;


@Service
public class DonationService {
	
	@Autowired
	private DonationDao dao;
	
	public List<Donation> getDonationList() {
		
		List<Donation> list = dao.getDonationList();
		
		return list;
	}

	public Donation getDonation(Donation donation) {
		Donation getdonation = dao.getDonation(donation);
		return getdonation;
	}
	
	public int createDonation(Donation donation) {
		
		int result = dao.createDonation(donation);
		
		return result;
	}
	
	public int deleteDonation(Donation donation) {
		int result = dao.deleteDonation(donation);
		return result;
	}
	
	public int updateDonation(Donation donation) {
		int result = dao.updateDonation(donation);
		return result;
	}
	
	public int updateDonationPointPlus(int userNum) {
		int result = dao.updateDonationPointPlus(userNum);
		return result;
	}
	
	public int updateDonationPointMinus(int userNum) {
		int result = dao.updateDonationPointMinus(userNum);
		return result;
	}

}

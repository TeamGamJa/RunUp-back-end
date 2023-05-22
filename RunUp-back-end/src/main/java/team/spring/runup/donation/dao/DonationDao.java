package team.spring.runup.donation.dao;

import java.util.List;

import team.spring.runup.donation.vo.Donation;

public interface DonationDao {
	
	List<Donation> getDonationList();
	
	Donation getDonation(Donation donation);
	
	int getDonationNum(Donation donation);
	
	int createDonation(Donation donation);
	
	int deleteDonation(Donation donation);
	
	int updateDonation(Donation donation);
	
	int updateDonationPointPlus(Donation donation);
	
	int updateDonationPointMinus(Donation donation);

}

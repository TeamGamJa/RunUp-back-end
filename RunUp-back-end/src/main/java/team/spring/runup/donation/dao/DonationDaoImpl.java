package team.spring.runup.donation.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import team.spring.runup.donation.vo.Donation;


@Repository
public class DonationDaoImpl implements DonationDao {
	
	@Autowired
	private SqlSession session;
	
	@Override
	public List<Donation> getDonationList() {
		List<Donation> list = session.selectList("donation.getDonationList");
		return list;
	}
	
	@Override
	public Donation getDonation(Donation donation) {
		Donation donationone = session.selectOne("donation.getDonation",donation);
		return donationone;
	}
	
	@Override
	public int getDonationNum(Donation donation) {
		int result = session.selectOne("donation.getDonationNum",donation);
		return result;
	}
	
	@Override
	public int createDonation(Donation donation) {
		int result = session.insert("donation.createDonation",donation);
		return result;
	}
	
	@Override
	public int deleteDonation(Donation donation) {
		int result = session.delete("donation.deleteDonation",donation);
		return result;
	}
	
	@Override
	public int updateDonation(Donation donation) {
		int result = session.update("donation.updateDonation",donation);
		return result;
	}
	
	@Override
	public int updateDonationPointPlus(Donation donation) {
		int result = session.update("donation.updateDonationPointPlus",donation);
		return result;
	}
	
	@Override
	public int updateDonationPointMinus(Donation donation) {
		int result = session.update("donation.updateDonationPointMinus",donation);
		return result;
	}
	
}

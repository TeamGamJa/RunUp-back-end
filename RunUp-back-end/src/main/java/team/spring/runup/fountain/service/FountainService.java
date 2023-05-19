package team.spring.runup.fountain.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.spring.runup.fountain.dao.FountainDao;
import team.spring.runup.fountain.vo.Fountain;


@Service
public class FountainService {
	
	@Autowired
	private FountainDao dao;
	
	public List<Fountain> getFountainList() {
		
		List<Fountain> list = dao.getFountainList();
		
		return list;
	}

	public Fountain getFountain(Fountain fountain) {
		Fountain getfountain = dao.getFountain(fountain);
		return getfountain;
	}
	
	public int createFountain(Fountain fountain) {
		
		int result = dao.createFountain(fountain);
		
		return result;
	}
	
	public int deleteFountain(Fountain fountain) {
		int result = dao.deleteFountain(fountain);
		return result;
	}
	
	public int updateFountain(Fountain fountain) {
		int result = dao.updateFountain(fountain);
		return result;
	}
	
	

}

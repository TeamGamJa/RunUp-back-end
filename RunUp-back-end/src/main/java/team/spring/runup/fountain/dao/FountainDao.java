package team.spring.runup.fountain.dao;

import java.util.List;

import team.spring.runup.fountain.vo.Fountain;

public interface FountainDao {

	List<Fountain> getFountainList();
	
	Fountain getFountain(Fountain fountain);
	
	int createFountain(Fountain fountain);
	
	int deleteFountain(Fountain fountain);
	
	int updateFountain(Fountain fountain);
}

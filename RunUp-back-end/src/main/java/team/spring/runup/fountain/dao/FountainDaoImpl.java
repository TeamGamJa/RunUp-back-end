package team.spring.runup.fountain.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import team.spring.runup.fountain.vo.Fountain;


@Repository
public class FountainDaoImpl implements FountainDao {

	@Autowired
	private SqlSession session;
	
	@Override
	public List<Fountain> getFountainList() {
		List<Fountain> list = session.selectList("fountain.getFountainList");
		return list;
	}
	
	@Override
	public Fountain getFountain(Fountain fountain) {
		Fountain fountainone = session.selectOne("fountain.getFountain",fountain);
		return fountainone;
	}
	
	@Override
	public int createFountain(Fountain fountain) {
		int result = session.insert("fountain.createFountain",fountain);
		return result;
	}
	
	@Override
	public int deleteFountain(Fountain fountain) {
		int result = session.delete("fountain.deleteFountain",fountain);
		return result;
	}
	
	@Override
	public int updateFountain(Fountain fountain) {
		int result = session.update("fountain.updateFountain",fountain);
		return result;
	}
}

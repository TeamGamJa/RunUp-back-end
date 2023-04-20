package team.spring.runup.running.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import team.spring.runup.running.vo.Category;
import team.spring.runup.running.vo.Running;

@Repository
public class RunningDaoImpl implements RunningDao {
	
	@Autowired
	private SqlSession session;
	
	@Override
	public List<Category> selectCategoryBigAll() {
		List<Category> list = session.selectList("running.selectCategoryBigList");
		return list;
	}
	
	@Override
	public List<Category> selectCategoryMediumAll(Category category) {
		List<Category> list = session.selectList("running.selectCategoryMediumList",category);
		return list;
	}
	
	@Override
	public List<Running> selectRunningList() {
		List<Running> list = session.selectList("running.selectRunningList");
		return list;
	}
	
	@Override
	public List<Running> selectRunningByKeyword(String keyword) {
		List<Running> list = session.selectList("running.selectRunningByKeyword",keyword);
		return list;
	}
	
	@Override
	public int createRunning(Running run) {
		int result = session.insert("running.createRunning",run);
		return result;
	}
	
	@Override
	public int deleteRunning(Running run) {
		int result = session.delete("running.deleteRunning",run);
		return result;
	}
	
	@Override
	public int updateRunning(Running run) {
		int result = session.update("running.updateRunning",run);
		return result;
	}
}
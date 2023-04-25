package team.spring.runup.running.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import team.spring.runup.running.vo.Category;
import team.spring.runup.running.vo.Running;
import team.spring.runup.running.vo.Runup;

@Repository
public class RunningDaoImpl implements RunningDao {
	
	@Autowired
	private SqlSession session;
	
	@Override
	public List<String> getCategoryBigAll() {
		List<String> list = session.selectList("running.getCategoryBigList");
		return list;
	}
	
	@Override
	public List<String> getCategoryMediumAll() {
		List<String> list = session.selectList("running.getCategoryMediumList");
		return list;
	}
	
	@Override
	public List<String> getCategoryMediumList(String categoryBig) {
		List<String> list = session.selectList("running.getCategoryMediumListByCategoryBig", categoryBig);
		return list;
	}
	
	@Override
	public List<Running> getRunningList() {
		List<Running> list = session.selectList("running.getRunningList");
		return list;
	}
	
	@Override
	public List<Running> getRunningBycategoryBig(String categoryBig) {
		List<Running> list = session.selectList("running.getRunningBycategorybig", categoryBig);
		return list;
	}
	
	@Override
	public List<Running> getRunningBycategoryMedium(String categoryMedium) {
		List<Running> list = session.selectList("running.getRunningBycategorymedium", categoryMedium);
		return list;
	}
	
	@Override
	public List<Running> getRunningByKeyword(String keyword) {
		List<Running> list = session.selectList("running.getRunningByKeyword",keyword);
		return list;
	}
	
	@Override
	public Running getRunning(Running run) {
		Running runningone = session.selectOne("running.getRunning",run);
		return runningone;
	}
	
	@Override
	public int getUserNumByRunningNum(int runningnum) {
		int num = session.selectOne("running.getUserNumByRunningNum",runningnum);
		return num;
	}
	
	@Override
	public int getMentorByUserNum(int num) {
		int count = session.selectOne("running.countMentor",num);
		return count;
	}
	
	@Override
	public int createRunning(Running run) {
		int result = session.insert("running.createRunning",run);
		return result;
	}
	
	@Override
	public int createRegister(Running run) {
		int result = session.insert("running.createRegister",run);
		return result;
	}
	
	@Override
	public int deleteRegister(Running run) {
		int result = session.delete("running.deleteRegister",run);
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
	
	@Override
	public int updateRunningAble(Running run) {
		int result = session.update("running.updateRunningAble",run);
		return result;
	}
	
	@Override
	public int updateRunningView(Running run) {
		int result = session.update("running.updateViewNum",run);
		return result;
	}
}
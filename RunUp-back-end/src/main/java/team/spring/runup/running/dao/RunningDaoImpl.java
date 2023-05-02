package team.spring.runup.running.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import team.spring.runup.running.vo.Category;
import team.spring.runup.running.vo.RunCalender;
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
	public List<Runup> getRunningList() {
		List<Runup> list = session.selectList("running.getRunningList");
		return list;
	}
	
	@Override
	public List<Runup> getRunningBycategoryBig(String categoryBig) {
		List<Runup> list = session.selectList("running.getRunningBycategorybig", categoryBig);
		return list;
	}
	
	@Override
	public List<Runup> getRunningBycategoryMedium(String categoryMedium) {
		List<Runup> list = session.selectList("running.getRunningBycategorymedium", categoryMedium);
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
	public List<RunCalender> getRunningByRunningAble(int userNum) {
		List<RunCalender> list = session.selectList("running.getRunningByRunningAble", userNum);
		return list;
	}
	
	@Override
	public List<RunCalender> getRunningByRunningAbleTrue(int userNum) {
		List<RunCalender> list = session.selectList("running.getRunningByRunningAbleTrue", userNum);
		return list;
	}
	
	@Override
	public List<RunCalender> getRunningByRunningShow(int userNum) {
		List<RunCalender> list = session.selectList("running.getRunningByRunningShow", userNum);
		return list;
	}
	
	@Override
	public List<RunCalender> getRunningByParticipateNum(int participateNum) {
		List<RunCalender> list = session.selectList("running.getRunningByParticipateNum", participateNum);
		return list;
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
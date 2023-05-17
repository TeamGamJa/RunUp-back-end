package team.spring.runup.running.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import team.spring.runup.running.vo.Category;
import team.spring.runup.running.vo.Point;
import team.spring.runup.running.vo.RunCalender;
import team.spring.runup.running.vo.Running;
import team.spring.runup.running.vo.RunningBarOne;
import team.spring.runup.running.vo.RunningBarTwo;
import team.spring.runup.running.vo.RunningLineOne;
import team.spring.runup.running.vo.RunningPieOne;
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
	public List<Runup> getRunningByRunningTitle(String runningTitle) {
		List<Runup> list = session.selectList("running.getRunningByRunningTitle", runningTitle);
		return list;
	}
	
	@Override
	public List<Runup> getRunningList() {
		List<Runup> list = session.selectList("running.getRunningList");
		return list;
	}
	
	@Override
	public List<Runup> getFinishRunningList(int participateNum) {
		List<Runup> list = session.selectList("running.getFinishRunningList",participateNum);
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
	public List<RunningPieOne> getPieByUserNum(int userNum) {
		List<RunningPieOne> list = session.selectList("running.getPieByUserNum",userNum);
		return list;
	}
	
	@Override
	public List<RunningLineOne> getLineByUserNum(int userNum) {
		List<RunningLineOne> list = session.selectList("running.getLineByUserNum", userNum);
		return list;
	}
	
	@Override
	public List<RunningBarOne> getBarByUserNum() {
		List<RunningBarOne> list = session.selectList("running.getBarByUserNum");
		return list;
	}
	
	@Override
	public List<RunningBarOne> getBarByDate() {
		List<RunningBarOne> list = session.selectList("running.getBarByDate");
		return list;
	}
	
	@Override
	public List<RunningBarTwo> getPointByUserNum() {
		List<RunningBarTwo> list = session.selectList("running.getPointByUserNum");
		return list;
	}
	
	@Override
	public List<RunningBarTwo> getColorByUserNum() {
		List<RunningBarTwo> list = session.selectList("running.getColorByUserNum");
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
	public List<RunCalender> getRunningByRunningShow(int participateNum) {
		List<RunCalender> list = session.selectList("running.getRunningByRunningShow", participateNum);
		return list;
	}
	
	@Override
	public List<RunCalender> getRunningByParticipateNum(int participateNum) {
		List<RunCalender> list = session.selectList("running.getRunningByParticipateNum", participateNum);
		return list;
	}
	
	@Override
	public int getRunningPoint(Running run) {
		int result = session.selectOne("running.getRunningPoint", run);
		return result;
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
	public int cancelRunning(Running run) {
		int result = session.delete("running.cancelRunning",run);
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
	public int updateCancelByParticipateNum(Running run) {
		int result = session.update("running.updateCancelByParticipateNum",run);
		return result;
	}
	
	@Override
	public int updateUserPointPlus(Running run) {
		int result = session.update("running.updateUserPointPlus",run);
		return result;
	}
	
	@Override
	public int updateUserPointMinus(Running run) {
		int result = session.update("running.updateUserPointMinus",run);
		return result;
	}
	
	@Override
	public int updateRunningView(Running run) {
		int result = session.update("running.updateViewNum",run);
		return result;
	}
}
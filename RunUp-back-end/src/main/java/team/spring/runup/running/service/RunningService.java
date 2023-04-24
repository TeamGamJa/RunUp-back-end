package team.spring.runup.running.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.spring.runup.running.dao.RunningDao;
import team.spring.runup.running.vo.Category;
import team.spring.runup.running.vo.Running;
import team.spring.runup.running.vo.Runup;
import team.spring.runup.user.dao.UserDao;
import team.spring.runup.user.vo.User;

@Service
public class RunningService {
	
	@Autowired
	private RunningDao dao;
	
	@Autowired
	private UserDao udao;
	
	public List<String> selectCategoryBigAll() {
		List<String> list = dao.selectCategoryBigAll();
		return list;
	}
	
	public List<String> selectCategoryMediumAll() {
		List<String> list = dao.selectCategoryMediumAll();
		return list;
	}
	
	public List<String> selectCategoryMediumList(String categoryBig) {
		List<String> list = dao.selectCategoryMediumList(categoryBig);
		return list;
	}
	
	public List<Runup> selectRunningList() {
		int i=0 ;
		List<Running> list = dao.selectRunningList();
		List<Runup> resultList = new ArrayList<>();
		while (i<list.size()) {
			Running running = list.get(i);
			User user = udao.getUserByNum(running.getUserNum());
			Runup runup = new Runup();
			runup.setRunningNum(running.getRunningNum());
			runup.setRunningTitle(running.getRunningTitle());
			runup.setUserNickname(user.getUserNickname());
			runup.setRunningCategoryMedium(running.getRunningCategoryMedium());
			runup.setUserLuxColor(user.getUserLuxColor());
			runup.setUserMentorCnt(user.getUserMentorCnt());
			runup.setRunningDate(running.getRunningDate());
			runup.setRunningAble(running.isRunningAble());
			resultList.add(runup);
			i++;
		}
		return resultList;
	}
	
	public Running selectRunning(Running run) {
		Running running = dao.selectRunning(run);
		return running;
	}
	
	public List<Running> selectRunningBycategoryBig(String categoryBig) {
		List<Running> list = dao.selectRunningBycategoryBig(categoryBig);
		return list;
	}
	
	public List<Running> selectRunningBycategoryMedium(String categoryMedium) {
		List<Running> list = dao.selectRunningBycategoryMedium(categoryMedium);
		return list;
	}
	
	public List<Running> selectRunningByKeyword(String keyword) {
		List<Running> list = dao.selectRunningByKeyword(keyword);
		return list;
	}
	
	public int createRunning(Running run) {
		int result = dao.createRunning(run);
		return result;
	}
	
	public int deleteRunning(Running run) {
		int result = dao.deleteRunning(run);
		return result;
	}
	
	public int updateRunning(Running run) {
		int result = dao.updateRunning(run);
		return result;
	}
	
	public int updateViewNum(Running run) {
		int result = dao.updateRunningView(run);
		return result;
	}
}

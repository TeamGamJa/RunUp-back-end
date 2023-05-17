package team.spring.runup.running.service;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.spring.runup.running.dao.RunningDao;
import team.spring.runup.running.vo.Category;
import team.spring.runup.running.vo.Point;
import team.spring.runup.running.vo.RunCalender;
import team.spring.runup.running.vo.Running;
import team.spring.runup.running.vo.RunningBarOne;
import team.spring.runup.running.vo.RunningBarTwo;
import team.spring.runup.running.vo.RunningLineOne;
import team.spring.runup.running.vo.RunningPieOne;
import team.spring.runup.running.vo.Runup;
import team.spring.runup.user.dao.UserDao;
import team.spring.runup.user.vo.User;

@Service
public class RunningService {
	
	@Autowired
	private RunningDao dao;
	
	@Autowired
	private UserDao udao;
	
	public List<String> getCategoryBigAll() {
		List<String> list = dao.getCategoryBigAll();
		return list;
	}
	
	public List<String> getCategoryMediumAll() {
		List<String> list = dao.getCategoryMediumAll();
		return list;
	}
	
	public List<String> getCategoryMediumList(String categoryBig) {
		List<String> list = dao.getCategoryMediumList(categoryBig);
		return list;
	}
	
	public List<RunningPieOne> getPieByUserNum(int userNum) {
		List<RunningPieOne> list = dao.getPieByUserNum(userNum);
		return list;
	}
	
	public List<RunningLineOne> getLineByUserNum(int userNum) {
		
		List<RunningLineOne> list = dao.getLineByUserNum(userNum);
		
		return list;
	}
	
	public List<RunningBarOne> getBarByUserNum() {
		List<RunningBarOne> list = dao.getBarByUserNum();
		
		return list;
	}
	
	public List<RunningBarOne> getBarByDate() {
		List<RunningBarOne> list = dao.getBarByDate();
		
		return list;
	}
	
	public List<RunningBarTwo> getPointByUserNum() {
		List<RunningBarTwo> list = dao.getPointByUserNum();
		
		return list;
	}
	
	public List<RunningBarTwo> getColorByUserNum() {
		List<RunningBarTwo> list = dao.getColorByUserNum();
		
		return list;
	}
	
	public List<Runup> getRunningByRunningTitle(String runningTitle) {
		List<Runup> list = dao.getRunningByRunningTitle(runningTitle);
		return list;
	}
	
	public List<Runup> getRunningList() {
		
		List<Runup> list = dao.getRunningList();
		
		return list;
	}
	
	public List<Runup> getFinishRunningList(int participateNum) {
		
		List<Runup> list = dao.getFinishRunningList(participateNum);
		
		return list;
	}

	public Running getRunning(Running run) {
		Running running = dao.getRunning(run);
		return running;
	}
	
	public List<Runup> getRunningBycategoryBig(String categoryBig) {
		
		List<Runup> list = dao.getRunningBycategoryBig(categoryBig);
		
		return list;
	}
	
	public List<Runup> getRunningBycategoryMedium(String categoryMedium) {
		
		List<Runup> list = dao.getRunningBycategoryMedium(categoryMedium);
		
		return list;
	}
	
//	public List<Runup> getRunningBycategoryBig(String categoryBig) {
//		int i=0;
//		List<Running> list = dao.getRunningBycategoryBig(categoryBig);
//		List<Runup> resultList = new ArrayList<>();
//		while (i<list.size()) {
//			Running running = list.get(i);
//			User user = udao.getUserByNum(running.getUserNum());
//			int num = running.getUserNum();
//			int cnt = dao.getMentorByUserNum(num);
//			Runup runup = new Runup();
//			runup.setRunningNum(running.getRunningNum());
//			runup.setRunningTitle(running.getRunningTitle());
//			runup.setUserNickname(user.getUserNickname());
//			runup.setRunningCategoryMedium(running.getRunningCategoryMedium());
//			
//			String luxcolor = new String();
//			int luxnum = user.getUserLuxColor();
//			if (luxnum<100) {
//				luxcolor = "red";
//			} else if (luxnum>=100 & luxnum<200) {
//				luxcolor = "orange";
//			} else if (luxnum>=200 & luxnum<300) {
//				luxcolor = "yellow";
//			} else if (luxnum>=300 & luxnum<400) {
//				luxcolor = "green";
//			} else if (luxnum>=400 & luxnum<500) {
//				luxcolor = "blue";
//			} else if (luxnum>=500 & luxnum<600) {
//				luxcolor = "navy";
//			} else if (luxnum>=600 & luxnum<700) {
//				luxcolor = "purple";
//			} else if (luxnum>=700) {
//				luxcolor = "white";
//			}
//			
//			runup.setUserLuxColor(luxcolor);
//			runup.setUserMentorCnt(cnt);
//			SimpleDateFormat newDtFormat = new SimpleDateFormat("yyyy-MM-dd");
//			String newrunningdate = newDtFormat.format(running.getRunningDate());
//			runup.setRunningDate(newrunningdate);
//			runup.setRunningAble(running.isRunningAble());
//			resultList.add(runup);
//			i++;
//		}
//		return resultList;
//	}
//	
//	public List<Runup> getRunningBycategoryMedium(String categoryMedium) {
//		int i=0;
//		List<Running> list = dao.getRunningBycategoryMedium(categoryMedium);
//		List<Runup> resultList = new ArrayList<>();
//		while (i<list.size()) {
//			Running running = list.get(i);
//			User user = udao.getUserByNum(running.getUserNum());
//			int num = running.getUserNum();
//			int cnt = dao.getMentorByUserNum(num);
//			Runup runup = new Runup();
//			runup.setRunningNum(running.getRunningNum());
//			runup.setRunningTitle(running.getRunningTitle());
//			runup.setUserNickname(user.getUserNickname());
//			runup.setRunningCategoryMedium(running.getRunningCategoryMedium());
//			
//			String luxcolor = new String();
//			int luxnum = user.getUserLuxColor();
//			if (luxnum<100) {
//				luxcolor = "red";
//			} else if (luxnum>=100 & luxnum<200) {
//				luxcolor = "orange";
//			} else if (luxnum>=200 & luxnum<300) {
//				luxcolor = "yellow";
//			} else if (luxnum>=300 & luxnum<400) {
//				luxcolor = "green";
//			} else if (luxnum>=400 & luxnum<500) {
//				luxcolor = "blue";
//			} else if (luxnum>=500 & luxnum<600) {
//				luxcolor = "navy";
//			} else if (luxnum>=600 & luxnum<700) {
//				luxcolor = "purple";
//			} else if (luxnum>=700) {
//				luxcolor = "white";
//			}
//			
//			runup.setUserLuxColor(luxcolor);
//			runup.setUserMentorCnt(cnt);
//			SimpleDateFormat newDtFormat = new SimpleDateFormat("yyyy-MM-dd");
//			String newrunningdate = newDtFormat.format(running.getRunningDate());
//			runup.setRunningDate(newrunningdate);
//			runup.setRunningAble(running.isRunningAble());
//			resultList.add(runup);
//			i++;
//		}
//		return resultList;
//	}
	
	public List<Running> getRunningByKeyword(String keyword) {
		List<Running> list = dao.getRunningByKeyword(keyword);
		return list;
	}
	
	public List<RunCalender> getRunningByRunningAble(int userNum) {
		List<RunCalender> list = dao.getRunningByRunningAble(userNum);
		return list;
	}
	
	public List<RunCalender> getRunningByRunningAbleTrue(int userNum) {
		List<RunCalender> list = dao.getRunningByRunningAbleTrue(userNum);
		return list;
	}
	
	public List<RunCalender> getRunningByRunningShow(int participateNum) {
		List<RunCalender> list = dao.getRunningByRunningShow(participateNum);
		return list;
	}
	
	public List<RunCalender> getRunningByParticipateNum(int participateNum) {
		List<RunCalender> list = dao.getRunningByParticipateNum(participateNum);
		return list;
	}
	
	public int getRunningPoint(Running run) {
		int num = dao.getRunningPoint(run);
		return num;
	}
	
	public int getUserNumByRunningNum(int runningnum) {
		int num = dao.getUserNumByRunningNum(runningnum);
		return num;
	}
	
	public int createRunning(Running run) {
		String string = new String();
		String chat = new String();
		StringBuilder sb = new StringBuilder();
		SecureRandom random = new SecureRandom();
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		
		for (int i=0; i<7; i++) {
			int idx = random.nextInt(chars.length());
			sb.append(chars.charAt(idx));
		}
		
		User user = udao.getUserByNum(run.getUserNum());
		run.setUserNickname(user.getUserNickname());
		run.setRunningColor(user.getUserColor());
		run.setUserMentorCnt(run.getUserMentorCnt());
		
		
		string = run.getRunningDate() + ' ' + run.getRunningEndSmall();
		chat = String.valueOf(run.getUserNum())+"room"+sb.toString();
		run.setChatRoomId(chat);
		run.setRunningDate(string);
		int result = dao.createRunning(run);
		
		return result;
	}
	
	public int createRegister(Running run) {
		int result = dao.createRegister(run);
		return result;
	}
	
	public int deleteRegister(Running run) {
		int result = dao.deleteRegister(run);
		return result;
	}
	
	public int deleteRunning(Running run) {
		int result = dao.deleteRunning(run);
		return result;
	}
	
	public int cancelRunning(Running run) {
		int result = dao.cancelRunning(run);
		return result;
	}
	
	public int updateRunning(Running run) {
		int result = dao.updateRunning(run);
		return result;
	}
	
	public int updateRunningAble(Running run) {
		int result = dao.updateRunningAble(run);
		return result;
	}
	
	public int updateCancelByParticipateNum(Running run) {
		int result = dao.updateCancelByParticipateNum(run);
		return result;
	}
	
	public int updateViewNum(Running run) {
		int result = dao.updateRunningView(run);
		return result;
	}
	
	public int updateFinishLearning(User user) {
		int result = udao.updateFinishLearning(user);
		return result;
	}
	
	public int updateFinishRunning(User user) {
		int result = udao.updateFinishRunning(user);
		return result;
	}
	
	public int updateSalt(User user) {
		int result = udao.updateUserLuxColor(user);
		return result;
	}
	
	public int updateUserPointPlus(Running run) {
		int result = dao.updateUserPointPlus(run);
		return result;
	}
	
	public int updateUserPointMinus(Running run) {
		int result = dao.updateUserPointMinus(run);
		return result;
	}

}

package team.spring.runup.running.dao;

import java.util.List;

import team.spring.runup.running.vo.Category;
import team.spring.runup.running.vo.Point;
import team.spring.runup.running.vo.RunCalender;
import team.spring.runup.running.vo.Running;
import team.spring.runup.running.vo.RunningBarOne;
import team.spring.runup.running.vo.RunningBarTwo;
import team.spring.runup.running.vo.RunningLineOne;
import team.spring.runup.running.vo.RunningPieOne;
import team.spring.runup.running.vo.Runup;
import team.spring.runup.user.vo.User;

public interface RunningDao {

	List<String> getCategoryBigAll();
	
	List<String> getCategoryMediumAll();
	
	List<String> getCategoryMediumList(String categoryBig);
	
	List<Runup> getRunningByRunningTitle(String runningTitle);
	
	List<Runup> getRunningList();
	
	List<Runup> getFinishRunningList(int participateNum);
	
	List<Runup> getRunningBycategoryBig(String categoryBig);
	
	List<Runup> getRunningBycategoryMedium(String categoryMedium);
	
	List<Running> getRunningByKeyword(String keyword);
	
	List<RunCalender> getRunningByRunningAble(int userNum);
	
	List<RunCalender> getRunningByRunningAbleTrue(int userNum);
	
	List<RunCalender> getRunningByRunningShow(int participateNum);
	
	List<RunCalender> getRunningByParticipateNum(int participateNum);
	
	List<RunningPieOne> getPieByUserNum(int userNum);
	
	List<RunningLineOne> getLineByUserNum(int userNum);
	
	List<RunningBarOne> getBarByUserNum();
	
	List<RunningBarOne> getBarByDate();
	
	List<RunningBarTwo> getPointByUserNum();
	
	List<RunningBarTwo> getColorByUserNum();
	
	Running getRunning(Running run);
	
	int getRunningPoint(Running run);
	
	int getUserNumByRunningNum(int runningnum);
	
	int getMentorByUserNum(int num);
	
	int updateRunningView(Running run);
	
	int updateCancelByParticipateNum(Running run);
	
	int createRunning(Running run);
	
	int deleteRunning(Running run);
	
	int cancelRunning(Running run);
	
	int updateRunning(Running run);
	
	int updateRunningAble(Running run);
	
	int updateUserPointPlus(Running run);
	
	int updateUserPointMinus(Running run);
	
	int createRegister(Running run);
	
	int deleteRegister(Running run);

}

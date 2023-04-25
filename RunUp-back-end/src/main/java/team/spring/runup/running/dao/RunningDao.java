package team.spring.runup.running.dao;

import java.util.List;

import team.spring.runup.running.vo.Category;
import team.spring.runup.running.vo.Running;
import team.spring.runup.running.vo.Runup;

public interface RunningDao {

	List<String> getCategoryBigAll();
	
	List<String> getCategoryMediumAll();
	
	List<String> getCategoryMediumList(String categoryBig);
	
	List<Running> getRunningList();
	
	List<Running> getRunningBycategoryBig(String categoryBig);
	
	List<Running> getRunningBycategoryMedium(String categoryMedium);
	
	List<Running> getRunningByKeyword(String keyword);
	
	Running getRunning(Running run);
	
	int getUserNumByRunningNum(int runningnum);
	
	int getMentorByUserNum(int num);
	
	int updateRunningView(Running run);
	
	int createRunning(Running run);
	
	int deleteRunning(Running run);
	
	int updateRunning(Running run);
	
	int updateRunningAble(Running run);
	
	int createRegister(Running run);
	
	int deleteRegister(Running run);

}

package team.spring.runup.running.dao;

import java.util.List;

import team.spring.runup.running.vo.Category;
import team.spring.runup.running.vo.Running;

public interface RunningDao {

	List<String> selectCategoryBigAll();
	
	List<String> selectCategoryMediumAll();
	
	List<String> selectCategoryMediumList(String categoryBig);
	
	List<Running> selectRunningList();
	
	List<Running> selectRunningBycategoryBig(String categoryBig);
	
	List<Running> selectRunningBycategoryMedium(String categoryMedium);
	
	List<Running> selectRunningByKeyword(String keyword);
	
	Running selectRunning(Running run);
	
	int updateRunningView(Running run);
	
	int createRunning(Running run);
	
	int deleteRunning(Running run);
	
	int updateRunning(Running run);

}

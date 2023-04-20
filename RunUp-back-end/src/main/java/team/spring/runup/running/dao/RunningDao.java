package team.spring.runup.running.dao;

import java.util.List;

import team.spring.runup.running.vo.Category;
import team.spring.runup.running.vo.Running;

public interface RunningDao {

	List<Category> selectCategoryBigAll();
	
	List<Category> selectCategoryMediumAll(Category category);
	
	List<Running> selectRunningList();
	
	List<Running> selectRunningByKeyword(String keyword);
	
	int createRunning(Running run);
	
	int deleteRunning(Running run);
	
	int updateRunning(Running run);

}

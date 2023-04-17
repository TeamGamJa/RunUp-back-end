package team.spring.runup.running.dao;

import java.util.List;

import team.spring.runup.running.vo.CategoryBig;
import team.spring.runup.running.vo.CategoryMedium;

public interface RunningDao {

	List<CategoryBig> selectCategoryBigAll();
	
	List<CategoryMedium> selectCategoryMediumAll();

}

package team.spring.runup.running.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.spring.runup.running.dao.RunningDao;
import team.spring.runup.running.vo.CategoryBig;
import team.spring.runup.running.vo.CategoryMedium;

@Service
public class RunningService {
	
	@Autowired
	private RunningDao dao;
	
	public List<CategoryBig> selectCategoryBigAll() {
		List<CategoryBig> list = dao.selectCategoryBigAll();
		return list;
	}
	
	public List<CategoryMedium> selectCategoryMediumAll() {
		List<CategoryMedium> list = dao.selectCategoryMediumAll();
		return list;
	}
	
}

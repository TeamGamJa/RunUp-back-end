package team.spring.runup.running.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import team.spring.runup.running.vo.CategoryBig;
import team.spring.runup.running.vo.CategoryMedium;

@Repository
public class RunningDaoImpl implements RunningDao {
	
	@Autowired
	private SqlSession session;
	
	@Override
	public List<CategoryBig> selectCategoryBigAll() {
		List<CategoryBig> list = session.selectList("running.selectCategoryBigList");
		return list;
	}
	
	@Override
	public List<CategoryMedium> selectCategoryMediumAll() {
		List<CategoryMedium> list = session.selectList("running.selectCategoryMediumList");
		return list;
	}
}
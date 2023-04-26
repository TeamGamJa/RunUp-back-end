package team.spring.runup.report.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import team.spring.runup.report.vo.Report;

@Repository
public class ReportDaoImpl implements ReportDao {

	Logger log = LogManager.getLogger("case3");
	
	@Autowired
	private SqlSession session;
	
	@Override
	public int createReport(Report report) {
		int result = session.insert("report.createReport",report);
		return result;
	}
}

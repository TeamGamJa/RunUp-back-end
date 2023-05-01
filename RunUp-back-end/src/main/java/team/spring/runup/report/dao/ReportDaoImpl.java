package team.spring.runup.report.dao;

import java.util.List;

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
	public List<Report> getReportList() {
		List<Report> list = session.selectList("report.getReportList");
		return list;
	}
	
	@Override
	public Report getReport(int reportNum) {
		Report result = session.selectOne("report.getReport",reportNum);
		return result;
	}
	
	@Override
	public String getReportImage(int reportNum) {
		String result = session.selectOne("report.getReportImage",reportNum);
		return result;
	}
	
	@Override
	public int createReport(Report report) {
		int result = session.insert("report.createReport",report);
		return result;
	}
	
	@Override
	public int deleteReport(Report report) {
		int result = session.delete("report.deleteReport",report);
		return result;
	}
	
	@Override
	public int updateReport(Report report) {
		int result = session.update("report.updateReport",report);
		return result;
	}
	
	@Override
	public int updateReportFile(Report report) {
		int result = session.update("report.updateReportFile",report);
		return result;
	}
	
	@Override
	public int saveReport(Report report) {
		int result = session.update("report.updateReportResult",report);
		return result;
	}
}

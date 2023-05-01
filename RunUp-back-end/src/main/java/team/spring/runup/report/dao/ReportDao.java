package team.spring.runup.report.dao;

import java.util.List;

import team.spring.runup.report.vo.Report;

public interface ReportDao {
	
	List<Report> getReportList();
	
	Report getReport(int reportNum);
	
	String getReportImage(int reportNum);
	
	int createReport(Report report);
	
	int deleteReport(Report report);
	
	int updateReport(Report report);
	
	int updateReportFile(Report report);
	
	int saveReport(Report report);
	
}

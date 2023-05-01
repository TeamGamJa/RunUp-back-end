package team.spring.runup.report.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.spring.runup.report.dao.ReportDaoImpl;
import team.spring.runup.report.vo.Report;

@Service
public class ReportService {
	
	Logger log = LogManager.getLogger("case3");
	
	@Autowired
	ReportDaoImpl dao;
	
	public List<Report> getReportList() {
		List<Report> list = dao.getReportList();
		return list;
	}
	
	public Report getReport(int reportNum) {
		Report list = dao.getReport(reportNum);
		return list;
	}
	
	public String getReportImage(int reportNum) {
		String result = dao.getReportImage(reportNum);
		return result;
	}
	
	public int createReport(Report report) {
		int result = dao.createReport(report);
		return result;
	}
	
	public int deleteReport(Report report) {
		int result = dao.deleteReport(report);
		return result;
	}
	
	public int updateReport(Report report) {
		int result = dao.updateReport(report);
		return result;
	}
	
	public int updateReportFile(Report report) {
		int result = dao.updateReportFile(report);
		return result;
	}
	
	public int saveReport(Report report) {
		int result = dao.saveReport(report);
		return result;
	}
	
}

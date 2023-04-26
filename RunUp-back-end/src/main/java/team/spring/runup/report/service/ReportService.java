package team.spring.runup.report.service;

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
	
	public int createReport(Report report) {
		int result = dao.createReport(report);
		return result;
	}
	
	
}

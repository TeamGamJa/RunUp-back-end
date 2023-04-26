package team.spring.runup.report.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Report {
	private int reportNum;
	private String reporter;
	private String accused;
	private String reportDate;
	private String reportContent;
	private String reportResult;
	private String reportCategory;
	private String reportFile;
	private int userNum;
}

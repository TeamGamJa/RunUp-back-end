package team.spring.runup.running.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Running {
	private int runningNum;
	private String runningTitle;
	private String runningContent;
	private String runningCategoryBig;
	private String runningCategoryMedium;
	private int runningStartBig;
	private int runningStartSmall;
	private int runningEndBig;
	private int runningEndSmall;
	private boolean runningKeep;
	private boolean runningShow;
	private boolean runningAble;
	private Date runningDate;
	private int runningViewNum;
	private int userNum;
}
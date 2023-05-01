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
	private String runningStartSmall;
	private int runningEndBig;
	private String runningEndSmall;
	private boolean runningKeep;
	private boolean runningShow;
	private boolean runningAble;
	private String runningDate;
	private int runningViewNum;
	private int userNum;
	private int runningPoint;
	private String runningNickName;
	private String runningRegisterDate;
	private int runningColor;
	private String runningColorName;
	private int runningMentorCnt;
}
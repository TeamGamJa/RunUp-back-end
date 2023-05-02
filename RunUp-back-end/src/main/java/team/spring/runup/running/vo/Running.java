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
	private String runningDay;
	private int runningViewNum;
	private int userNum;
	private int runningPoint;
	private String userNickname;
	private String runningDate;
	private int runningColor;
	private String userLuxColor;
	private int userMentorCnt;
	private String chatRoomId;
	private int participateNum;
}
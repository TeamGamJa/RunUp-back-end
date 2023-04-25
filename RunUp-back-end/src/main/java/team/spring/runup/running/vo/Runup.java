package team.spring.runup.running.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Runup {
	private int runningNum;
	private String runningTitle;
	private String userNickname;
	private String runningCategoryMedium;
	private int userLuxColor;
	private int userMentorCnt;
	private String runningDate;
	private boolean runningAble;
}

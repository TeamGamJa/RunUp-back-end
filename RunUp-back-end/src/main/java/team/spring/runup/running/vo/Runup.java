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
	private String runningContent;
	private String userNickname;
	private String runningCategoryBig;
	private String runningCategoryMedium;
	private String userLuxColor;
	private int userMentorCnt;
	private String runningDate;
	private String runningStartSmall;
	private String runningEndSmall;
	private int runningAble;
}

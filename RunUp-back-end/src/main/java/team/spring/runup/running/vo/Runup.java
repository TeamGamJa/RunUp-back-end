package team.spring.runup.running.vo;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Runup {
	private int runningNum;
	private String runningTitle;
	private String runningNickName;
	private String runningCategoryMedium;
	private String runningColorName;
	private int runningMentorCnt;
	private String runningDate;
	private boolean runningAble;
}

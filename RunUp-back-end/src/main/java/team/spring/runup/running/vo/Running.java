package team.spring.runup.running.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Running {
	private int RunningNum;
	private String RunningTitle;
	private String RunningContent;
	private String RunningCategoryBig;
	private String RunningCategoryMedium;
	private int RunningStartBig;
	private int RunningStartSmall;
	private int RunningEndBig;
	private int RunningEndSmall;
	private boolean RunningKeep;
	private boolean RunningShow;
	private boolean RunningAble;
	private String RunningDate;
	private int RunningViewNum;
	private int RunningScore;
	private int UserNum;
}
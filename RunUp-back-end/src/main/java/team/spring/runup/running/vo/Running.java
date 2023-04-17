package team.spring.runup.running.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Running {
	private String RunningNum;
	private String RunningTitle;
	private String RunningContent;
	private String RunningCategoryBig;
	private String RunningCategoryMedium;
	private String RunningStart;
	private String RunningAble;
	private String RunningDate;
	private String RunningViewNum;
	private String Salt;
	private String RunningPick;
	private String UserNum;
}
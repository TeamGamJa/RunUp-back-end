package team.spring.runup.fountain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FountainList {
	private int fountainNum;
	private String fountainContent;
	private String fountainCategoryBig;
	private String fountainCategoryMedium;
	private String fountainDate;
	private String fountainWriter;
	private String fountainPoint;
	private int userNum;
}

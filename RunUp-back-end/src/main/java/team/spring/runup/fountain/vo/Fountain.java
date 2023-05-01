package team.spring.runup.fountain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fountain {
	private int fountainNum;
	private String fountainContent;
	private String fountainCategoryBig;
	private String fountainCategoryMedium;
	private String fountainDate;
	private String fountainAuthor;
	private int fountainPoint;
	private int userNum;
}

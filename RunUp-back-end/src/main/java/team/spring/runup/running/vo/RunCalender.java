package team.spring.runup.running.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RunCalender {
	
	private String runningTitle;
	private String runningCategoryMedium;
	private String userNickname;
	private String runningDate;
	private String runningStartSmall;
	private String runningEndSmall;
	private String runningContent;
	private String chatRoomId;
	
}

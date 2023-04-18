package team.spring.runup.user.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	private int userNum;
	private String userId;
	private String userPw;
	private String userName;
	private String userNickname;
	private String userAddr;
	private String userPhone;
	private String userInfo;
	private String userCategoryBig;
	private String userCategoryMedium;
	private int userAbility;
	private int userPoint;
	private Boolean isOut;
	private String userUrl;
	private int userLuxColor;
	private int userReportCnt;
	private Boolean AdminBoolean;
	private int userMentorCnt;
	private int userMenteeCnt;
	private String userWant;
	
}

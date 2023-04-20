package team.spring.runup.chatting.vo;

import com.google.protobuf.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import team.spring.runup.user.vo.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chatting {

	private long id;
	private User user;
	private String message;
	private Timestamp sendAt;
	private Boolean isReqest;
}

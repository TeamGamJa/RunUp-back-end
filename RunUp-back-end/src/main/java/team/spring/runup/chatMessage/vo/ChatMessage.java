package team.spring.runup.chatMessage.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage {

	private String sender;
	private String content;
	private String roomId;
	private String title;
}

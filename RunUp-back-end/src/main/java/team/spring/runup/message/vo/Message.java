package team.spring.runup.message.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Message {

	private int messageNum;
	private String messageSender;
	private String messageReceiver;
	private String messageTitle;
	private String messageContent;
	private String messageDate;
	private int userNum;
}
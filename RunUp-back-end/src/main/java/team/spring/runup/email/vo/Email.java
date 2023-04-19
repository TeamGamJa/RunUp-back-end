package team.spring.runup.email.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Email {

	private String title;
	private String content;
	private String date;
	private String receiver;
}

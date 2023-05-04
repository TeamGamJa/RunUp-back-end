package team.spring.runup.running.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Point {
	private int pointNum;
	private String pointSender;
	private String pointReceiver;
	private String pointReview;
	private int pointMovement;
	private String pointDate;
	private int participateNum;
}

package team.spring.runup.donation.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Donation {
	private int donationNum;
	private String donationSender;
	private String donationReceiver;
	private String donationComment;
	private int donationPoint;
	private String donationDate;
	private int fountainNum;
}

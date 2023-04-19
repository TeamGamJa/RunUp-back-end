package team.spring.runup.email.service;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import team.spring.runup.email.vo.Email;

@Service
public class EmailService {

	Logger log = LogManager.getLogger("case3");
	
	@Autowired
	private JavaMailSender mailSender;

	public int sendMail(Email email) throws Exception {
		
		MimeMessage msg = mailSender.createMimeMessage();
		
		log.debug("test123123" + msg);
		log.debug("test123123213" + mailSender);
		try {
			msg.setFrom("someone@paran.com");
			msg.setSubject(email.getTitle());
			msg.setText(email.getContent());
			msg.setRecipient(RecipientType.TO, new InternetAddress(email.getReceiver()));
			
			mailSender.send(msg);
			
			return 1;
		} catch (AddressException e) {
			e.printStackTrace();
		}
		return 0;
	}
}

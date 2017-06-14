package org.raj.archive.service;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class SendEmail {
	public static void main(String[] args) {

		final String username = "vardhan0327@gmail.com";
		final String password = "Hunter@123";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {
			
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("vardhan0327@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("vardhan0327@gmail.com"));
			
			message.setSubject("New Record Inserted");
			message.setText(" Successfully Inserted ");

			Transport.send(message);

			System.out.println("Successfully Inserted and Notification sent");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}

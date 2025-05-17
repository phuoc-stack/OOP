package com.longg.service;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailService {
	// Recipient's email ID
	String to = "hosuthaophuoc@gmail.com";

	// Sender's email info
	String from = "hosuthaophuoc@gmail.com";
	private final String username = "hosuthaophuoc@gmail.com";
	private final String password = "zfdb yrdq afau zlgg";
	
	// Subject
	private String subject;
	private String message;

	// Gmail SMTP server
	String host = "smtp.gmail.com";

	public void sendEmail(String subject, String messageContent) {
		// Setup mail server properties
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");

		// Get the Session object with authenticator
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			// Create a default MimeMessage object
			Message message = new MimeMessage(session);

			// Set From: header field
			message.setFrom(new InternetAddress(from));

			// Set To: header field
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

			// Set Subject: header field
			message.setSubject(subject);

			// Set the actual message
			message.setText(messageContent);

			// Send message
			Transport.send(message);
			
			System.out.println("Email sent successfully!");
		} catch (MessagingException e) {
			throw new RuntimeException("Failed to send email: " + e.getMessage(), e);
		}
	}
}
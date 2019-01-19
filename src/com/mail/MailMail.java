package com.mail;


import org.springframework.mail.*;
 
public class MailMail{
	
	private static MailSender mailSender;
 
	public void setMailSender(MailSender mailSender) {
		MailMail.mailSender = mailSender;
	}
		
	public static void sendMail(String emailid){
		SimpleMailMessage message = new SimpleMailMessage(); 
		String subject="Thanks from usbtoken.in";
		String from="noreply@usbtoken.in";
		message.setFrom(from);
		message.setTo(emailid);
		message.setSubject(subject);
		message.setText("Than you for your contacting us through our websites.<br> A representative will contact you soon.");				
		mailSender.send(message);		
	}
	
	public static void subscribe(String email){
		SimpleMailMessage message = new SimpleMailMessage(); 
		String subject="Thanks from usbtoken.in";
		String from="noreply@usbtoken.in";
		message.setFrom(from);
		message.setTo(email);
		message.setSubject(subject);
		message.setText("Thank you for subscription on usbtoken.in.  Regular mail will be dropped in yoour inbox.");				
		mailSender.send(message);		
	}
	
	public static void forum(int forumid){
		SimpleMailMessage message = new SimpleMailMessage(); 
		String subject="New query posted on usbtoken site forum!";
		String from="noreply@usbtoken.in";
		message.setFrom(from);
		message.setTo("support@dsc.expert");
		message.setSubject(subject);
		message.setText("New Query posted on usbtoken.in. Check now: http://usbtoken.in/discuss"+forumid);
		mailSender.send(message);		
	}
}
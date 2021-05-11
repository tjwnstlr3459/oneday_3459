//package ajax.controller;
//
//import java.io.UnsupportedEncodingException;
//import java.util.Date;
//import java.util.Properties;
//import java.util.Random;
//
//import javax.mail.Authenticator;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//
//public class MailSender {
//	//매개변수로 받은 이메일주소로 랜덤코드 생성해서 메일을 전송한 후 랜덤코드를 리턴
//	//랜덤코드생성
//	public String mailSend(String email) {
//		Random r = new Random();
//		StringBuilder sb = new StringBuilder();
//		for(int i=0; i<6; i++) {
//			sb.append(r.nextInt(10));
//		}
//		System.out.println("생성된 랜덤코드 : " + sb.toString());
//		
//		
//		Properties prop = System.getProperties();
//		prop.put("mail.smtp.host", "smtp.gmail.com");
//		prop.put("mail.smtp.port", 465);
//		prop.put("mail.smtp.auth", "true");
//		prop.put("mail.smtp.ssl.enable", "true");
//		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
//		
//		//계정정보 접속 준비
//		Session session = Session.getDefaultInstance(prop,new Authenticator() {
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication("tjwnstlr3459@gmail.com","nx5406br!!");
//			}
//		});
//		
//		//실제 메일을 씀
//		MimeMessage msg = new MimeMessage(session);
//		
//		try {
//			msg.setSentDate(new Date());
//			msg.setFrom(new InternetAddress("tjwnstlr3459@gmail.com","당산a Class"));
//			InternetAddress to = new InternetAddress(email);
//			msg.setRecipient(Message.RecipientType.TO, to);//보내는사람/받는사람설정
//			msg.setSubject("KH정보교육원 인증메일입니다.","UTF-8"); //제목
//			msg.setContent("<h1>안녕하세요 KH정보교육원입니다.</h1>"+"<h3>인증번호는["+sb.toString()+"]입니다.",
//							"text/html; charset=UTF-8");	//메일내용
//			Transport.send(msg);	//전송
//		} catch (MessagingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return sb.toString();
//	}
//}
//
//
//
//
//
//
//
//
package ajax.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {
	//매개변수로 받은 이메일주소로 랜덤코드 생성해서 메일을 전송한 후 랜덤코드를 리턴
	public String mailSend(String email) {
		Random r = new Random();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<6;i++) {
			sb.append(r.nextInt(10));
		}
		System.out.println("생성된 랜덤코드 : "+sb.toString());
		
		Properties prop = System.getProperties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", 465);
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		
		Session session = Session.getDefaultInstance(prop, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("tjwnstlr3459@gmail.com","nx5406br!!");
			}
		});
		MimeMessage msg = new MimeMessage(session);
		
		try {
			msg.setSentDate(new Date());
			msg.setFrom(new InternetAddress("tjwnstlr3459@gmail.com","당산A Class"));
			InternetAddress to = new InternetAddress(email);
			msg.setRecipient(Message.RecipientType.TO, to);
			msg.setSubject("KH정보교육원 인증메일입니다.","UTF-8");
			msg.setContent("<h1>안녕하세요 KH정보교육원입니다.</h1>"+"<h3>인증번호는["+sb.toString()+"] 입니다."
							,"text/html;charset=UTF-8");
			Transport.send(msg);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}
}








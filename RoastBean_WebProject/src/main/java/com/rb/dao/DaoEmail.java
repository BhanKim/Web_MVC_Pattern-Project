package com.rb.dao;

import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class DaoEmail {
	
	public DaoEmail() {
		// TODO Auto-generated constructor stub
	}
	
	
	public String send(String email) {
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2"); // 추가된 코드
		props.put("mail.smtp.ssl.enable", "true");  // 추가된 코드
		
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("wjd6408@gmail.com", "egadildxnhcxtrji");
			}
		});
		
		Random random = new Random();
		StringBuffer buf = new StringBuffer();
		for(int i=0;i<6;i++){
		    // rnd.nextBoolean() 는 랜덤으로 true, false 를 리턴. true일 시 랜덤 한 소문자를, false 일 시 랜덤 한 숫자를 StringBuffer 에 append 한다.
		    if(random.nextBoolean()){
		        buf.append((char)((int)(random.nextInt(26))+65));
		    }else{
		        buf.append((random.nextInt(6)));
		    }
		}
		
		String certifyNum = buf.toString();
		
		String receiver = email; // 메일 받을 주소
		String title = "[RoastBean] 회원가입 이메일 인증";
		String content = "<div"
				+ "		style=\"font-family: 'Apple SD Gothic Neo', 'sans-serif' !important; width: 540px; height: 600px; border-top: 4px solid{$point_color\">"
				+ "		<h1"
				+ "			style=\"margin: 0; padding: 0 5px; font-size: 28px; font-weight: 400;\">"
				+ "			<span style=\"font-size: 30px; margin: 0 0 10px 3px; color: #F2BCBB;\"><strong>RoastBean</strong></span><br />"
				+ "			<span style=\"color: {$point_color\">메일인증</span> 안내입니다."
				+ "		</h1>"
				+ "		<p"
				+ "			style=\"font-size: 16px; line-height: 26px; margin-top: 50px; padding: 0 5px;\">"
				+ "			안녕하세요.<br /> RoastBean 입니다.<br /> 이메일 인증을 위한 코드를 발송드립니다. <br> <b"
				+ "				style=\"color: {$point_color\">'인증 번호'</b>를 입력하여 회원가입을 완료해 주세요.<br />"
				+ "			<br />"
				+ "			인증번호 : "
				+ "			<br />"
				+ "			<h2><strong>" + certifyNum + "</strong></h2><br />"
				+ "			<br /> 감사합니다."
				+ "		</p>"
				+ "	</div>";
		Message message = new MimeMessage(session);
		
		try {
			message.setFrom(new InternetAddress("raindrop6651@gmail.com", "RoastBean", "utf-8"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
			message.setSubject(title);
			message.setContent(content, "text/html; charset=utf-8");

			Transport.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return certifyNum;
	}
}
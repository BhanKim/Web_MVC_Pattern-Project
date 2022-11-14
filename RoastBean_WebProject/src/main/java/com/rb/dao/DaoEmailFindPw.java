package com.rb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.rb.dto.DtoUser;

public class DaoEmailFindPw {
	
	DataSource dataSource;
	
	public DaoEmailFindPw() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/roastbean");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public String findPw(String user_id, String user_name, String user_email) {
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            String user_pwemail = null;

            try {
                
                connection = dataSource.getConnection();

                String query = "select user_pw from user where user_id = '" + user_id + "'" + " and user_email = '" + user_email + "'" + " and user_name = '" + user_name + "'";
                
                preparedStatement = connection.prepareStatement(query);
                resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                	user_pwemail = resultSet.getString("user_pw");
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (resultSet != null)
                        resultSet.close();
                    if (preparedStatement != null)
                        preparedStatement.close();
                    if (connection != null)
                        connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
	
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
		
		String receiver = user_email; // 메일 받을 주소
		String title = "[RoastBean] 비밀번호 찾기";
		String content = "<div"
				+ "		style=\"font-family: 'Apple SD Gothic Neo', 'sans-serif' !important; width: 540px; height: 600px; border-top: 4px solid{$point_color\">"
				+ "		<h1"
				+ "			style=\"margin: 0; padding: 0 5px; font-size: 28px; font-weight: 400;\">"
				+ "			<span style=\"font-size: 30px; margin: 0 0 10px 3px; color: #F2BCBB;\"><strong>RoastBean</strong></span><br />"
				+ "			<span style=\"color: {$point_color\">비밀번호</span> 안내입니다."
				+ "		</h1>"
				+ "		<p"
				+ "			style=\"font-size: 16px; line-height: 26px; margin-top: 50px; padding: 0 5px;\">"
				+ "			안녕하세요.<br /> RoastBean 입니다.<br /> 비밀번호 발송드립니다. <br>"
				+ "			<br />"
				+ "			비밀번호 : "
				+ "			<br />"
				+ "			<h2><strong>" + user_pwemail + "</strong></h2><br />"
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
		
		return user_pwemail;
	}
}
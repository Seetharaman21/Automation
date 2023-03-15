package com.profit.qa.Utills;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.profit.qa.Base.Base;


public class SendReport {


	public static void sentEmail() throws IOException, InterruptedException{
	Properties prop ;
	prop=Base.getPropertyAccess("src/main/java/com/profit/qa/Properties/email.properties");
	final String username =prop.getProperty("sentEmailUserName");
	final String password =prop.getProperty("sentEmallPassword");
	String host =prop.getProperty("sentEmailHost");
	String to =prop.getProperty("sentTo");

    Calendar calendar = Calendar.getInstance();
    Date currentDate = calendar.getTime();
    SimpleDateFormat format = new SimpleDateFormat(" dd_MM_yyyy HH:mm");
	Date date = new Date();
	String actualDate = format.format(date);

	Properties props = new Properties();
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.starttls.enable", "true");
	props.put("mail.smtp.host",host );
	props.put("mail.smtp.port", "587");

	Session session = Session.getInstance(props,new javax.mail.Authenticator()
	{ @Override
	protected PasswordAuthentication getPasswordAuthentication() { return new PasswordAuthentication(username, password);}});

	try {
	    Message message = new MimeMessage(session);
	    message.setFrom(new InternetAddress(username));
	    message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
	    message.setSubject("Test Case Report " + currentDate);

	    message.setText(" HI Team , Here i have attached the test report , Kinldy have a look on it.2");

        // Have to handle this file path directory as platform and machine independence
	   // String filePath = "C:\\Users\\Aabdul\\eclipse-workspace\\Profit\\Reports\\"+prop.getProperty("reportName");

	    String filePath = System.getProperty("user.dir")+"/Reports/"+prop.getProperty("reportName");
	    System.out.println(filePath);
	    MimeBodyPart messageBodyPart = new MimeBodyPart();

	    Multipart multipart = new MimeMultipart();
	    messageBodyPart = new MimeBodyPart();
	    DataSource source = new FileDataSource(filePath);

	    messageBodyPart.setDataHandler(new DataHandler(source));
	    messageBodyPart.setFileName(filePath);

	    multipart.addBodyPart(messageBodyPart);
	    message.setContent(multipart);
	    Transport.send(message);

	    System.out.println("Test case report sent successfully.");
	} catch (MessagingException e) { throw new RuntimeException(e);}


}
}

